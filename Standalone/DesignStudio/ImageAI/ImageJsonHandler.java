package Standalone.DesignStudio.ImageAI;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ImageJsonHandler {

    private static final String FILE_PATH = "/Users/harish-10327/Downloads/AI Space/Final/document.json";

    static void main(String[] args) throws IOException {

        JSONArray jsonArray = loadJsonArray();
        String category = "cset/education/";
        String folderPath = "/Users/harish-10327/Downloads/AI Space/Education/T5/";
        ArrayList<String> images = fileNameList(folderPath);
        ArrayList<String> success = new ArrayList<>();
        ArrayList<String> failure = new ArrayList<>();


        Set<String> existingUrls = new HashSet<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            existingUrls.add(jsonArray.getJSONObject(i).getString("image_url"));
        }

        System.out.println("Number of images: " + images.size());
        for (String imageName : images) {
            System.out.println("Processing image: " + imageName);
            JSONObject imageJson = processSingleImage(folderPath + imageName, category);

            if (imageJson != null) {
                String originalUrl = imageJson.getString("image_url");
                String uniqueUrl = originalUrl;
                int counter = 1;

                // Ensure unique URL
                while (existingUrls.contains(uniqueUrl)) {
                    int dotIndex = originalUrl.lastIndexOf(".");
                    if (dotIndex != -1) {
                        String namePart = originalUrl.substring(0, dotIndex);
                        String extPart = originalUrl.substring(dotIndex);
                        uniqueUrl = namePart + "_" + counter + extPart;
                    } else {
                        uniqueUrl = originalUrl + "_" + counter;
                    }
                    counter++;
                }

                // If file name has changed → rename the file too
                if (!originalUrl.equals(uniqueUrl)) {
//                    System.out.println("Renaming file: " + originalUrl + " -> " + uniqueUrl);

                    String oldFileName = Paths.get(folderPath, imageName).toString();
                    String newFileName = Paths.get(folderPath, Paths.get(uniqueUrl).getFileName().toString()).toString();

                    File oldFile = new File(oldFileName);
                    File newFile = new File(newFileName);

                    if (oldFile.renameTo(newFile)) {
//                        System.out.println("File renamed on disk: " + newFile.getName());
                    } else {
                        System.err.println("Failed to rename file: " + oldFile.getName());
                    }
                }

                // Update JSON object with unique URL
                imageJson.put("image_url", uniqueUrl);

                // Add to JSON + Set
                jsonArray.put(imageJson);
                existingUrls.add(uniqueUrl);

                success.add(uniqueUrl);
            } else {
                failure.add(imageName);
            }
        }

        saveJsonArray(jsonArray);

        System.out.println("Success Count: " + success.size());
//        System.out.println("Success: " + success);
        System.out.println("Failure: " + failure);

        System.out.println("✅ Image JSON added successfully!");
    }


    public static ArrayList<String> fileNameList(String folderPath) {
        ArrayList<String> fileNames = new ArrayList<>();
        File folder = new File(folderPath);

        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        String fileName = file.getName();

                        if (fileName.contains(" ")) {
                            String newFileName = fileName.replace(" ", "_");
                            File newFile = new File(folderPath + File.separator + newFileName);

                            boolean renamed = file.renameTo(newFile);
                            if (renamed) {
//                                System.out.println("Renamed: " + fileName + " -> " + newFileName);
                                fileNames.add(newFileName);
                            } else {
                                System.out.println("Failed to rename: " + fileName);
                            }
                        } else {
//                            System.out.println("No change: " + fileName);
                            fileNames.add(fileName);
                        }
                    }
                }
            } else {
                System.out.println("Folder is empty!");
            }
        } else {
            System.out.println("Invalid folder path!");
        }
        return fileNames;
    }


    public static JSONObject processSingleImage(String filePath, String category) throws IOException {
        String imageUrl = imageUrlGenerator(filePath, category);

        ImageResolutionFinder imageResolution = new ImageResolutionFinder();
        OpenAIVisionCaption caption = new OpenAIVisionCaption();
        int[] resolution = imageResolution.resolution(filePath);
        if(resolution == null){
            return null;
        }
        String desc = caption.extractTextByAIBasedOCR(filePath).replaceAll("^\"|\"$", "");

        if( desc.contains("API OCR FAILED")){
            return null;
        }

        JSONObject newImage = buildImageJson(
                imageUrl,
                desc,
                resolution[0],
                resolution[1]
        );
        return newImage;
    }


    public static JSONObject buildImageJson(String imageUrl, String description, int width, int height) {
        JSONObject imageObject = new JSONObject();
        imageObject.put("image_url", imageUrl);
        imageObject.put("description", description);

        JSONObject sizeObject = new JSONObject();
        sizeObject.put("width", width);
        sizeObject.put("height", height);

        imageObject.put("image_size", sizeObject);

        return imageObject;
    }

    public static JSONArray loadJsonArray() {
        try {
            if (Files.exists(Paths.get(FILE_PATH))) {
                String content = new String(Files.readAllBytes(Paths.get(FILE_PATH)));
                if (!content.isBlank()) {
                    return new JSONArray(content);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return new JSONArray();
    }

    public static void saveJsonArray(JSONArray jsonArray) {
        try {
            Files.write(
                    Paths.get(FILE_PATH),
                    jsonArray.toString(2).getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING
            );
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }

    public static String imageUrlGenerator(String filePath, String categoryName) {
        String fileName = Paths.get(filePath).getFileName().toString();
        return categoryName + fileName;
    }
}
