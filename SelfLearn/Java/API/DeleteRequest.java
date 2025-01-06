package SelfLearn.Java.API;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DeleteRequest {
    public static void DeleteRequestInit(){
        DeleteRequestUsingHttpURLConnection();
    }

    @SuppressWarnings("ReassignedVariable")
    public static void DeleteRequestUsingHttpURLConnection() {
        try {
            String url = "https://example.com/internalapi/v2/16485289/zsa-16485289/form/Contact_Us";
            URL obj = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
            conn.setRequestMethod("DELETE");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Authorization", "Bearer 16425917");

            String parameters = "iscsignature=";
            conn.setDoOutput(true);
            conn.getOutputStream().write(parameters.getBytes("UTF-8"));
            int responseCode = conn.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            System.out.println("Response: " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
