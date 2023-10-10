package API.Java;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

public class PatchRequest {

    public static void PatchRequestInit(){
        PatchRequestUsingApacheCloseableHttpClient(); // Direct Way
        PatchRequestUsingHttpURLConnection(); // Workaround
    }


    public static void PatchRequestUsingApacheCloseableHttpClient(){
        String urlValue = "https://example.com/internalapi/v2/16485289/zsa-16485289/form/Volunteer";
        String requestBody = "{\"data\" : {\"set_email_notification\":{\"cc\":[\"abc@abc.com\",\"xyz@xyz.com\"],\"bcc\":[\"xyz@abc.com\",\"abc@xyz.com\"],\"content_type\":\"HTML\",\"subject\":\"Temporary\",\"from\":\"zoho.adminuserid\",\"language\":\"English\",\"template_type\":\"inline\",\"to\":[\"harish.vk@zohocorp.com\",\"harish.vk@zohotest.com\"],\"message\":\"Dummy\",\"include_field_values\":true},\"has_email_notification\":false}}";

        String result = SendPatchRequest(urlValue, requestBody, null);
        JSONObject resultObj = new JSONObject(result);
        if(!resultObj.get("code").equals(3000)){
            System.out.println( "Email Notification update failed due to unknown reasons,  Response : "+ result);
        }
    }

    public static String SendPatchRequest(String url, String requestBody, HashMap<String,String> headerMap) {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {

            HttpPatch patchRequest = new HttpPatch(url);
            for(String key : headerMap.keySet()){
                patchRequest.addHeader(key, headerMap.get(key));
            }
            StringEntity entity = new StringEntity(requestBody);
            patchRequest.setEntity(entity);

            CloseableHttpResponse response = httpClient.execute(patchRequest);
            return EntityUtils.toString(response.getEntity());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void PatchRequestUsingHttpURLConnection(){
        //Sample
        String urlValue = "https://example.com/internalapi/v2/16485289/zsa-16485289/form/Volunteer";
        String requestBody = "{\"data\" : {\"set_email_notification\":{\"cc\":[\"abc@abc.com\",\"xyz@xyz.com\"],\"bcc\":[\"xyz@abc.com\",\"abc@xyz.com\"],\"content_type\":\"HTML\",\"subject\":\"Temporary\",\"from\":\"zoho.adminuserid\",\"language\":\"English\",\"template_type\":\"inline\",\"to\":[\"harish.vk@zohocorp.com\",\"harish.vk@zohotest.com\"],\"message\":\"Dummy\",\"include_field_values\":true},\"has_email_notification\":false}}";
        allowMethods("PATCH");
        PatchRequest(urlValue, requestBody);
    }

    public static HttpURLConnection PatchRequestBuilder(HttpURLConnection connection){
        connection.setRequestProperty("Authorization", "Bearer 16425917");
        connection.setRequestProperty("Content-Type", "application/json");
        return connection;
    }

    @SuppressWarnings("ReassignedVariable")
    public static void  PatchRequest(String urlValue, String requestBody){
        try {
            URL url = new URL(urlValue);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("PATCH");
            PatchRequestBuilder(connection);
            connection.setDoOutput(true);
            connection.setDoOutput(true);

            try (DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream())) {
                outputStream.writeBytes(requestBody);
                outputStream.flush();
            }

            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                StringBuilder response = new StringBuilder();
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                System.out.println("Response: " + response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void allowMethods(String... methods) {
        try {
            Field methodsField = HttpURLConnection.class.getDeclaredField("methods");

            Field modifiersField = Field.class.getDeclaredField("modifiers");
            modifiersField.setAccessible(true);
            modifiersField.setInt(methodsField, methodsField.getModifiers() & ~Modifier.FINAL);

            methodsField.setAccessible(true);

            String[] oldMethods = (String[]) methodsField.get(null);
            Set<String> methodsSet = new LinkedHashSet<>(Arrays.asList(oldMethods));
            methodsSet.addAll(Arrays.asList(methods));
            String[] newMethods = methodsSet.toArray(new String[0]);

            methodsField.set(null/*static field*/, newMethods);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new IllegalStateException(e);
        }
    }
}
