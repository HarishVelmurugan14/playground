package SelfLearn.Java.Defaultpackage.Advanced;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XMLTemplateChecker {
    public static void main(String[] args) {
        String filePath = "/Users/harish-10327/Workspace/ZohoDesignStudio/current_work/jsonTemplate.xml";

        try {
            String xmlContent = readFileContent(filePath);
            Set<String> usedTemplates = extractAttributeValues(xmlContent, "template");
            Set<String> definedTemplates = extractAttributeValues(xmlContent, "name");
            Set<String> usedRegexes = findAttributeValues(xmlContent, "regex");
            Set<String> usedXss = findAttributeValues(xmlContent, "xss");


            usedTemplates.removeAll(definedTemplates);

            if (usedTemplates.isEmpty()) {
                System.out.println("All templates used are defined.");
            } else {
                System.out.println("Templates used but not defined:");
                for (String template : usedTemplates) {
                    System.out.println(template);
                }
            }

            System.out.println("\nAll regex values found:");
            for (String regex : usedRegexes) {
                System.out.println(regex);
            }

            System.out.println("\nAll xss values found:");
            for (String xss : usedXss) {
                System.out.println(xss);
            }

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }

    private static String readFileContent(String filePath) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                contentBuilder.append(line);
            }
        }
        return contentBuilder.toString();
    }

    private static Set<String> extractAttributeValues(String xmlContent, String attribute) {
        Set<String> values = new HashSet<>();
        String regex = attribute + "=\"([^\"]+)\"";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(xmlContent);
        while (matcher.find()) {
            values.add(matcher.group(1));
        }
        return values;
    }

    private static Set<String> findAttributeValues(String xmlContent, String attribute) {
        Set<String> values = new HashSet<>();
        String regex = attribute + "=\"([^\"]+)\"";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(xmlContent);

        while (matcher.find()) {
            String regexString = matcher.group(1);
//            String[] regexArray = matcher.group(1).split("\\|");

            if(regexString.contains("(") && regexString.contains(")")){
                //Ignore
            }else{
                values.add(regexString);
            }

        }

        return values;
    }
}
