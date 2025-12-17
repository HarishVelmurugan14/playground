package SelfLearn.Java.API.AI;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.nio.file.Files;
import java.time.Duration;
import java.time.Instant;
import java.util.Base64;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BatchAIOCR {

    private static final String IMAGE_FOLDER = "/Users/harish-10327/Downloads/delete";

    public static void main(String[] args) {
        File folder = new File(IMAGE_FOLDER);
        File[] images = folder.listFiles((dir, name) ->
                name.toLowerCase().endsWith(".jpg") ||
                        name.toLowerCase().endsWith(".jpeg") ||
                        name.toLowerCase().endsWith(".png")
        );

        if (images == null || images.length == 0) {
            System.out.println("No image files found.");
            return;
        }

        for (int i = 0; i < images.length; i++) {
            File imgFile = images[i];
            try {
                BufferedImage image = ImageIO.read(imgFile);
                if (image == null) {
                    System.out.println("Skipping unreadable image: " + imgFile.getName());
                    continue;
                }

                String result = extractTextByAIBasedOCR(image, i);
                System.out.println("Result for " + imgFile.getName() + ":");
                System.out.println(result);
                System.out.println("--------------------------------------------------");

            } catch (Exception e) {
                System.err.println("Failed to process image: " + imgFile.getName());
                e.printStackTrace();
            }
        }
    }

    private static String extractTextByAIBasedOCR(BufferedImage image, int pageIndex) {
        Instant ocrStartTime = Instant.now();
        System.out.println("  Starting AI OCR for image " + (pageIndex + 1) + "...");

        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(image, "jpeg", baos);
            byte[] imageBytes = baos.toByteArray();
            String base64Image = Base64.getEncoder().encodeToString(imageBytes);

            JsonObject requestBody = new JsonObject();
            requestBody.addProperty("image", base64Image);
            requestBody.addProperty("type", "generate");
            requestBody.addProperty("user_prompt", "extract the text in the image");
            requestBody.addProperty("system_prompt", "");
            requestBody.addProperty("route", "/vision/generate");
            requestBody.addProperty("url", "http://10.63.28.71:8092");

            JsonObject samplingParams = new JsonObject();
            samplingParams.addProperty("temperature", 0);
            samplingParams.addProperty("top_p", 0.9);
            samplingParams.addProperty("top_k", 15);
            samplingParams.addProperty("max_tokens", 768);
            requestBody.add("sampling_params", samplingParams);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://172.24.182.32:8090/api/forward"))
                    .header("Content-Type", "application/json")
                    .header("Accept", "*/*")
                    .header("Accept-Language", "en-GB,en-US;q=0.9,en;q=0.8")
                    .header("Referer", "http://dl-llm-playground.localzoho.com:8090/")
                    .POST(HttpRequest.BodyPublishers.ofString(new Gson().toJson(requestBody)))
                    .build();

            Instant apiCallStart = Instant.now();
            System.out.println("  Sending API request...");
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Instant apiCallEnd = Instant.now();
            System.out.println("  API call completed in " + Duration.between(apiCallStart, apiCallEnd).toMillis() + "ms");

            String result;
            if (response.statusCode() == 200) {
                JsonObject responseJson = JsonParser.parseString(response.body()).getAsJsonObject();
                if (responseJson.has("text")) {
                    result = responseJson.get("text").getAsString();
                } else if (responseJson.has("content")) {
                    result = responseJson.get("content").getAsString();
                } else {
                    result = responseJson.toString();
                }
            } else {
                System.err.println("API OCR failed for image " + (pageIndex + 1) + ": HTTP " + response.statusCode());
                result = "[API OCR FAILED - Image " + (pageIndex + 1) + "]";
            }

            Instant ocrEndTime = Instant.now();
            System.out.println("  AI OCR completed in " + Duration.between(ocrStartTime, ocrEndTime).toMillis() + "ms");
            return result;

        } catch (Exception e) {
            Instant ocrEndTime = Instant.now();
            System.err.println("API OCR failed for image " + (pageIndex + 1) + ": " + e.getMessage());
            return "[API OCR FAILED - Image " + (pageIndex + 1) + "]";
        }
    }
}
