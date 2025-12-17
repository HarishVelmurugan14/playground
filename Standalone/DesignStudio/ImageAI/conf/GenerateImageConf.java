package Standalone.DesignStudio.ImageAI.conf;

import Standalone.DesignStudio.ImageAI.ImageResolutionFinder;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class GenerateImageConf {


    private static final String BASE_PATH = "/Users/harish-10327/Workspace/ZohoCreator/builds/designStudio/39_Oct24Build_IconLibrary/dev_resource/AdventNetBuilder/Sas/tomcat/webapps/ROOT";
    private static final String SERVICE_PATH = "/creator/11769779/";
    private static final String TEMPLATE_PATH = "/designstudio/portal/templates";

    public static List<JSONObject> extractImageEntries(JSONObject pageContent) throws IOException {
        List<JSONObject> results = new ArrayList<>();

        JSONObject elements = pageContent.getJSONObject("elements");
        for (String key : elements.keySet()) {
            String src = "";
            JSONObject elementWrapper = elements.getJSONObject(key);
            String type = elementWrapper.optString("type");
            JSONObject entry = new JSONObject();
            if ("image".equalsIgnoreCase(type)) {
                JSONObject element = elementWrapper.getJSONObject("element");
                JSONObject data = element.getJSONObject("data");

                src = data.optString("src", "");
                entry.put("is_background_image", false);

            } else if ("vertical_flex".equalsIgnoreCase(type) || "xycoordinates".equalsIgnoreCase(type)) {
                JSONObject element = elementWrapper.getJSONObject("element");
                JSONObject style = element.getJSONObject("style");
                if (!style.has("background")) {
                    continue;
                }
                JSONObject bg = style.getJSONObject("background");
                if (!bg.has("image")) {
                    continue;
                }
                JSONObject img = bg.getJSONObject("image");

                src = img.optString("src", "");
                entry.put("is_background_image", true);
            }
            if (!src.isEmpty()) {
                String fullPath = BASE_PATH + SERVICE_PATH + src;

                ImageResolutionFinder finder = new ImageResolutionFinder();
                int[] resolutionArr = finder.resolution(fullPath);
                String resolution = resolutionArr[0] + "x" + resolutionArr[1];

                entry.put("id", elementWrapper.optString("elementId"));
                entry.put("url", src);
                entry.put("purpose", "");
                entry.put("resolution", resolution);
                results.add(entry);
            }
        }

        return results;
    }

    static void main(String[] args) throws IOException {
        String folder = "/ZP_00002";
        String path = BASE_PATH + TEMPLATE_PATH + folder;

        Files.list(Paths.get(path)).filter(p -> p.toString().endsWith(".json")).forEach(file -> {
            try {
                String jsonStr = Files.readString(file);
                JSONObject content = new JSONObject(jsonStr);

                List<JSONObject> images = extractImageEntries(content.getJSONObject("page_content"));

                String fileName = file.getFileName().toString();
                String keyName = fileName.substring(0, fileName.lastIndexOf('.'));

                Path confPath = Paths.get(path, "image.conf");
                String confStr = Files.readString(confPath);
                JSONObject confJson = new JSONObject(confStr);

                JSONObject prompt = confJson.optJSONObject("prompt");
                if (prompt == null) {
                    prompt = new JSONObject();
                    confJson.put("prompt", prompt);
                }

                prompt.remove(keyName);


                JSONArray newArr = new JSONArray();
                for (JSONObject img : images) {
                    newArr.put(img);
                }

                prompt.put(keyName, newArr);

                Files.writeString(confPath, confJson.toString(2));

            } catch (Exception e) {
                System.err.println("Error processing file: " + file + " -> " + e.getMessage());
            }
        });
    }
}
