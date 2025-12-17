package Standalone.DesignStudio.ImageAI;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.Instant;
import java.util.Base64;

public class OpenAIVisionCaption {

    static void main(String[] args) throws IOException {
        
        
        OpenAIVisionCaption caption = new OpenAIVisionCaption();

        File file = new File("/Users/harish-10327/Downloads/AI Space/Construction/Template1/01_Image_c.jpg");
        BufferedImage image = ImageIO.read(file);
        String res = caption.extractTextByAIBasedOCR(image, 1);
        System.out.println(res);
    }


    public static BufferedImage convertToRGB(String filePath) throws IOException {
        BufferedImage image = ImageIO.read(new File(filePath));
        if (image == null) {
            throw new IOException("Unsupported image: " + filePath);
        }
        BufferedImage newImage = new BufferedImage(
                image.getWidth(),
                image.getHeight(),
                BufferedImage.TYPE_INT_RGB
        );
        Graphics2D g = newImage.createGraphics();
        g.drawImage(image, 0, 0, Color.WHITE, null);
        g.dispose();
        return newImage;
    }

    public String extractTextByAIBasedOCR(String imagePath) throws IOException {
        File file = new File(imagePath);
        BufferedImage image = convertToRGB(imagePath);
        String res = extractTextByAIBasedOCR(image, 1);
//        System.out.println(res);
        return res.trim().toString();
    }

    private String extractTextByAIBasedOCR(BufferedImage image, int pageIndex) {
        Instant ocrStartTime = Instant.now();

        try {
            Instant imageConversionStart = Instant.now();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(image, "jpeg", baos);
            byte[] imageBytes = baos.toByteArray();
            String base64Image = Base64.getEncoder().encodeToString(imageBytes);
            Instant imageConversionEnd = Instant.now();
//            System.out.println("  Image conversion completed in " + Duration.between(imageConversionStart, imageConversionEnd).toMillis() + "ms");

            JsonObject requestBody = new JsonObject();
            requestBody.addProperty("image", base64Image);
            requestBody.addProperty("type", "generate");
            requestBody.addProperty("user_prompt", "describe the image in a detailed manner explaining things, actions and background");
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
                    .uri(URI.create("http://172.20.90.186:8090/api/forward"))
                    .header("Content-Type", "application/json")
                    .header("Accept", "*/*")
                    .header("Accept-Language", "en-GB,en-US;q=0.9,en;q=0.8")
                    .header("Referer", "http://dl-llm-playground.localzoho.com:8090/")
                    .POST(HttpRequest.BodyPublishers.ofString(new Gson().toJson(requestBody)))
                    .build();

            Instant apiCallStart = Instant.now();
//            System.out.println("  Sending API request...");
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Instant apiCallEnd = Instant.now();
//            System.out.println("  API call completed in " + Duration.between(apiCallStart, apiCallEnd).toMillis() + "ms");

            String result;
            if (response.statusCode() == 200) {
                JsonObject responseJson = JsonParser.parseString(response.body()).getAsJsonObject();
                if (responseJson.has("text")) {
                    result = responseJson.get("text").getAsString();
                } else if (responseJson.has("content")) {
                    result = responseJson.get("content").getAsString();
                } else {
                    result = responseJson.get("response").toString();
                }
            } else {
                System.err.println("API OCR failed for page " + (pageIndex + 1) + ": HTTP " + response.statusCode());
                result = "[API OCR FAILED - Page " + (pageIndex + 1) + "]";
            }

            Instant ocrEndTime = Instant.now();
//            System.out.println("  AI OCR completed for page " + (pageIndex + 1) + " in " + Duration.between(ocrStartTime, ocrEndTime).toMillis() + "ms");
            return result;

        } catch (Exception e) {
            Instant ocrEndTime = Instant.now();
            System.err.println("API OCR failed for page " + (pageIndex + 1) + " after " + Duration.between(ocrStartTime, ocrEndTime).toMillis() + "ms: " + e.getMessage());
            return "[API OCR FAILED - Page " + (pageIndex + 1) + "]";
        }
    }

}
