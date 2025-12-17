package Standalone.DesignStudio.HTMLGenerate;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SuppressWarnings({"preview", "deprecation", "CallToPrintStackTrace"})
public class JsonToHTMLGenerator {

    private static final String domain = "https://harish-10327.csez.zohocorpin.com:8444";
    private static final String scope = "harish.vk1_zohotest834";
    private static final String appName = "asdasdas";
    
    private static final String folderPath = "/Users/harish-10327/Workspace/ZohoCreator/builds/designStudio/" +
            "38_ErrorHandling/dev_resource/AdventNetBuilder/Sas/tomcat/webapps/ROOT/designstudio/portal/templates/";
    private static final List<String> excludeList = List.of(".DS_Store", "newpage", "template");

    static void main(String[] args) {
        jsonToHTML();
    }

    static void jsonToHTML() {
        String templateCode = "ZP_00002";
        List<String> fileNames = listFileNamesWithoutExtension(templateCode);
        for(String fileName : fileNames) {
            apiCall(templateCode, fileName);
        }
    }

    private static List<String> listFileNamesWithoutExtension(String templateCode) {
        String folderPath = JsonToHTMLGenerator.folderPath + templateCode;
        List<String> fileNames = new ArrayList<>();
        Set<String> excludeSet = new HashSet<>(excludeList);
        File folder = new File(folderPath);

        if (!folder.exists() || !folder.isDirectory()) {
            System.err.println(STR."Invalid folder path: \{folderPath}");
            return fileNames;
        }

        File[] files = folder.listFiles();
        if (files == null || files.length == 0) {
            System.out.println(STR."Folder is empty: \{folderPath}");
            return fileNames;
        }

        for (File file : files) {
            if (file.isFile()) {
                String name = file.getName();
                int dotIndex = name.lastIndexOf('.');
                if (dotIndex > 0) {
                    name = name.substring(0, dotIndex);
                }

                if (excludeSet.contains(name)) {
                    continue;
                }

                fileNames.add(name);
            }
        }

        return fileNames;
    }


    private static void apiCall(String templateCode, String pageLinkName) {
        String requestUrl = STR."\{domain}/appbuilder/\{scope}/\{appName}/customerportal/edit/htmlGenerate";
        String jsonPayload = STR."{\"templateCode\":\"\{templateCode}\",\"pageLinkName\":\"\{pageLinkName}\"}";

        try {
            URL url = new URL(requestUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setRequestProperty("Accept", "*/*");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("X-Requested-With", "XMLHttpRequest");
            conn.setRequestProperty("X-ZCSRF-TOKEN",
                    "zccpn=4633358f2a0e0920e38704744c7d5942b3ca8639789f9bfbb49291359f90d5816362e1a7ca2002ba261b591416c2467bc955c1479e8032ce494a4450b4bcafec");
            conn.setRequestProperty("Cookie",
                    "ZCBUILDERFIVE=true; " +
                            "zccpn=4633358f2a0e0920e38704744c7d5942b3ca8639789f9bfbb49291359f90d5816362e1a7ca2002ba261b591416c2467bc955c1479e8032ce494a4450b4bcafec; " +
                            "_zcsr_tmp=4633358f2a0e0920e38704744c7d5942b3ca8639789f9bfbb49291359f90d5816362e1a7ca2002ba261b591416c2467bc955c1479e8032ce494a4450b4bcafec");

            // Send JSON
            try (OutputStream os = conn.getOutputStream()) {
                os.write(jsonPayload.getBytes(StandardCharsets.UTF_8));
            }

            int status = conn.getResponseCode();
            InputStream is = (status < HttpURLConnection.HTTP_BAD_REQUEST)
                    ? conn.getInputStream()
                    : conn.getErrorStream();

            BufferedReader in = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                response.append(line).append("\n");
            }
            in.close();

            System.out.println(STR."Response Code: \{status}");

            saveToFile(templateCode, pageLinkName, response.toString());

            conn.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void saveToFile(String templateCode, String pageLinkName, String content) {
        String folderPath = STR."\{JsonToHTMLGenerator.folderPath}\{templateCode}/html";
        try {
            File folder = new File(folderPath);
            if (!folder.exists() && !folder.mkdirs()) {
                System.err.println(STR."Failed to create folder: \{folderPath}");
                return;
            }

            File htmlFile = new File(folder, STR."\{pageLinkName}.html");
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(htmlFile, false))) {
                writer.write(content);
            }

            System.out.println(STR."File saved: \{htmlFile.getAbsolutePath()}");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
