package Standalone.DesignStudio.ContentAI;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.jsoup.Jsoup;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;

@SuppressWarnings("preview")
public class JsonFolderProcessor {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final String TEMPLATE_CONF_NAME = "template.conf";
    private static final String RESULT_CONF_NAME = "content.conf";
    private static final int MINIMUM_CONTENT_LENGTH = 10;

    private static final int MAX_SLUG_WORDS = 10;
    private static final int MAX_SLUG_LENGTH = 40;

    private static final Pattern NUMERIC_PATTERN = Pattern.compile("^[0-9]+([+MmkK%]*)$");
    private static final Pattern SINGLE_WORD_PATTERN = Pattern.compile("^[A-Za-z]+$");

    static void main(String[] args) {

        generateContentConf();

        // delete unnecessary keys

        // i will provide a json which has id, description and content and I will also provide current topic/theme the
        // contents in the json is based on the the current topic. but what i need is to update description of each content
        // which should provide the purpose of that content with respect to the theme. need to be generic. Future usage :
        // so that when a new topic is given based on the description, content can be generated as per need. In short update
        // description based on purpose of content with respect to topic.
        // description : it need to be underscore separated and precise not exceeding 30 character

        // Use this to get proper response description

    }

    private static void generateContentConf() {
        String folderPath = "/Users/harish-10327/Workspace/ZohoCreator/builds/designStudio/45_HTMLGenerate/" +
                "dev_resource/AdventNetBuilder/Sas/tomcat/webapps/ROOT/designstudio/portal/templates/ZP_00001";

        File folder = new File(folderPath);
        if (!folder.exists() || !folder.isDirectory()) {
            System.err.println(STR."Invalid folder path: \{folderPath}");
            return;
        }



        ObjectNode finalResult = MAPPER.createObjectNode();

        try {
            Map<String, String> fileToUrlMap = buildFileToUrlMap(folder);

            if (fileToUrlMap.isEmpty()) {
                System.out.println(STR."Could not find or process 'pages' in \{TEMPLATE_CONF_NAME}. Aborting.");
                return;
            }

            processJsonFiles(folder, fileToUrlMap, finalResult);

            File resultFile = new File(folder, RESULT_CONF_NAME);
            writeResultFile(finalResult, resultFile);

            unifyDuplicateDescriptions(resultFile);

        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }

    private static void processJsonFiles(File folder, Map<String, String> fileToUrlMap, ObjectNode finalResult) throws IOException {
        Files.list(folder.toPath())
                .filter(path -> path.toString().endsWith(".json"))
                .forEach(jsonFile -> {
                    String fileName = jsonFile.getFileName().toString();
                    String pageUrl = fileToUrlMap.get(fileName);

                    if (pageUrl != null) {
                        ArrayNode pageEntries = processFile(jsonFile);
                        if (pageEntries != null && !pageEntries.isEmpty()) {
                            finalResult.set(pageUrl, pageEntries);
                        }
                    } else {
                        System.out.println(STR."Skipping \{fileName}: No corresponding 'page_url' found in \{TEMPLATE_CONF_NAME}");
                    }
                });
    }

    private static ArrayNode processFile(Path jsonFile) {
        ArrayNode resultArray = MAPPER.createArrayNode();

        try {
            JsonNode root = MAPPER.readTree(jsonFile.toFile());
            JsonNode elements = root.path("page_content").path("elements");

            if (elements.isObject()) {
                elements.fields().forEachRemaining(entry -> {
                    JsonNode elementNode = entry.getValue();
                    String elementId = elementNode.path("elementId").asText("");
                    JsonNode contentNode = elementNode.path("element").path("content");

                    if (contentNode.isTextual()) {
                        String rawContent = contentNode.asText().trim();
                        if (shouldSkipContent(rawContent)) return;

                        String cleanedContent = Jsoup.parse(rawContent)
                                .text()
                                .trim()
                                .replaceAll("\\s+", " ");

                        if (shouldSkipContent(cleanedContent)) return;

                        String slug = generateDescriptiveSlug(cleanedContent);

                        ObjectNode entryNode = MAPPER.createObjectNode();
                        entryNode.put("id", elementId);
                        entryNode.put("description", slug);
                        entryNode.put("content", cleanedContent);

                        resultArray.add(entryNode);
                    }
                });
            }

            System.out.println(STR."Processed \{jsonFile.getFileName()} successfully.");
        } catch (Exception e) {
            System.err.println(STR."Error processing \{jsonFile.getFileName()}: \{e.getMessage()}");
        }

        return resultArray;
    }

    private static Map<String, String> buildFileToUrlMap(File folder) {
        Map<String, String> fileToUrlMap = new HashMap<>();
        File templateFile = new File(folder, TEMPLATE_CONF_NAME);

        if (!templateFile.exists()) {
            System.err.println(STR."Error: \{TEMPLATE_CONF_NAME} not found in \{folder.getAbsolutePath()}");
            return fileToUrlMap;
        }

        try {
            JsonNode root = MAPPER.readTree(templateFile);
            JsonNode pagesNode = root.path("pages");

            if (pagesNode.isArray()) {
                for (JsonNode page : pagesNode) {
                    String pageJson = page.path("page_json").asText(null);
                    String pageUrl = page.path("page_url").asText(null);

                    if (pageJson != null && pageUrl != null) {
                        fileToUrlMap.put(pageJson, pageUrl);
                    }
                }
            }
            System.out.println(STR."Template config processed. Found \{fileToUrlMap.size()} page mappings.");

        } catch (IOException e) {
            System.err.println(STR."Error reading \{TEMPLATE_CONF_NAME}: \{e.getMessage()}");
        }

        return fileToUrlMap;
    }

    private static void writeResultFile(ObjectNode finalResult, File resultFile) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(resultFile))) {
            writer.write(MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(finalResult));
        }
        System.out.println(STR."Combined result written to \{resultFile.getAbsolutePath()}");
    }

    private static void unifyDuplicateDescriptions(File resultFile) throws IOException {
        JsonNode root = MAPPER.readTree(resultFile);
        Map<String, String> contentToDescription = new HashMap<>();

        root.fields().forEachRemaining(page -> {
            ArrayNode entries = (ArrayNode) page.getValue();
            for (JsonNode node : entries) {
                String content = normalizeContent(node.path("content").asText());
                String description = node.path("description").asText();
                contentToDescription.putIfAbsent(content, description);
            }
        });

        root.fields().forEachRemaining(page -> {
            ArrayNode entries = (ArrayNode) page.getValue();
            for (JsonNode node : entries) {
                if (node instanceof ObjectNode obj) {
                    String content = normalizeContent(obj.path("content").asText());
                    String unifiedDesc = contentToDescription.get(content);

                    if (unifiedDesc != null && !unifiedDesc.equals(obj.path("description").asText())) {
                        obj.put("description", unifiedDesc);
                    }
                }
            }
        });

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(resultFile))) {
            writer.write(MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(root));
        }

        System.out.println(STR."Unified duplicate descriptions in \{resultFile.getName()}");
    }

    private static boolean shouldSkipContent(String text) {
        if (text == null || text.isEmpty()) return true;

        String cleaned = text.trim();

        // Skip content shorter than 10 characters
        if (cleaned.length() < MINIMUM_CONTENT_LENGTH) return true;

        // Skip if the content is purely numeric (e.g., "100", "5k", "25%")
        if (NUMERIC_PATTERN.matcher(cleaned).matches()) return true;

        // Skip if it is a single, uninteresting word
        return !cleaned.contains(" ") && SINGLE_WORD_PATTERN.matcher(cleaned).matches();
    }

    private static String generateDescriptiveSlug(String text) {
        if (text == null || text.isEmpty()) return "";

        String[] words = text.toLowerCase().split("\\s+");
        // Use up to 10 words for maximum context within the length constraint
        int count = Math.min(words.length, MAX_SLUG_WORDS);

        String slug = String.join("_", Arrays.copyOfRange(words, 0, count))
                .replaceAll("[^a-z0-9_]", "");

        // Limit the final slug length to 50 characters
        return slug.length() > MAX_SLUG_LENGTH ? slug.substring(0, MAX_SLUG_LENGTH) : slug;
    }

    private static String normalizeContent(String content) {
        return content.toLowerCase(Locale.ROOT).trim().replaceAll("\\s+", " ");
    }
}