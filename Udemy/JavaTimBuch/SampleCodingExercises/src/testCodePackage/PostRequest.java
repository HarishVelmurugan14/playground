package testCodePackage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class PostRequest {

    public void POSTReq() throws IOException {

        int count = 0;

        URL obj = new URL("https://www.zohoapis.com/crm/v3/Presales_Task/actions/mass_update");


        FileReader fr = new FileReader("/Users/harish-10327/Downloads/Presales_Reseller_Identification.csv");
        BufferedReader br = new BufferedReader(fr);
        String thisLine = ""s
        String POST_PARAMS = "";

        POST_PARAMS = "{ \"data\": [{\"Type_of_user\": \"Cross Sell\"}],\"over_write\": true,\"ids\": [";
        while ((thisLine = br.readLine()) != null) {
            String[] param = thisLine.split(",");
            //POST_PARAMS = "{\n \"data\": [ \n { \"id\": \"" + param[0] + "\",\n \"Type_of_user\": \"" + param[1] + "\" }\n]\n}";
            count++;
            POST_PARAMS = POST_PARAMS + "\"" + param[0] + "\",";

            if (count % 287 == 0) {

                POST_PARAMS = POST_PARAMS.substring(0, POST_PARAMS.length() - 1) + "]}";
                //System.out.println(POST_PARAMS);
                HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
                postConnection.setRequestProperty("Authorization", "Zoho-oauthtoken " + "1000.9f5314d7bc6d4fb48dc37a1a0733774d.e32fdfc6802dfe2c8bfc1109345f17bb");
                postConnection.setRequestMethod("POST");
                postConnection.setRequestProperty("userId", "a1bcdefgh");
                postConnection.setRequestProperty("Content-Type", "application/json");
                postConnection.setDoOutput(true);

                if (POST_PARAMS != "") {

                    OutputStream os = postConnection.getOutputStream();
                    os.write(POST_PARAMS.getBytes());
                    os.flush();
                    os.close();
                    int responseCode = postConnection.getResponseCode();
                    if (responseCode == 200) {
                        System.out.println(postConnection.getResponseMessage());
                        count++;
                    } else {
                        System.out.println(responseCode);
                        System.out.println(postConnection.getErrorStream());
                    }
                }


                POST_PARAMS = "{ \"data\": [{\"Type_of_user\": \"Cross Sell\"}],\"over_write\": true,\"ids\": [";
                System.out.println(count);
            }


            //  System.out.println(POST_PARAMS)

        }

//        System.out.println("POST Response Code :  " + responseCode);
//        System.out.println("POST Response Message : " + postConnection.getResponseMessage());
//
//        if (responseCode == HttpURLConnection.HTTP_CREATED) { //success
//            BufferedReader in = new BufferedReader(new InputStreamReader(
//                    postConnection.getInputStream()));
//            String inputLine;
//            StringBuffer response = new StringBuffer();
//
//            while ((inputLine = in.readLine()) != null) {
//                response.append(inputLine);
//            }
//            in.close();
//        }
        // print result

        System.out.println(count);
    }

    public static void main(String[] args) throws IOException {
        PostRequest pos = new PostRequest();
        pos.POSTReq();
    }

}