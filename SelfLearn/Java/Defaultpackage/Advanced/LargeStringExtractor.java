package SelfLearn.Java.Defaultpackage.Advanced;

import java.util.regex.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@SuppressWarnings("CallToPrintStackTrace")
public class LargeStringExtractor {

    public static void extractJsonTemplateBlocks(String filePath, String name) {

        Pattern pattern = Pattern.compile(currentPattern(name), Pattern.DOTALL);
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder buffer = new StringBuilder();
            String line;
//            int count=0;
            while ((line = reader.readLine()) != null) {
                buffer.append(line).append("\n");

                Matcher matcher = pattern.matcher(buffer);
                while (matcher.find()) {
//                    count++;
//                    System.out.println(count);
//                    System.out.println(replacer(matcher.group(0)));
                    System.out.println(matcher.group(0));
                    buffer = new StringBuilder();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String currentPattern(String name) {
        return  "<jsontemplate[^>]*name=\"" + name + "[^>]*>(.*?)\"[^>]*>(.*?)</jsontemplate>"; // jsonTemplateBlockPattern
//        return  "<jsontemplate name=\"" + name + "[^>]*>"; // typeFetcher
    }

    private static String replacer(String str){
        return str.replaceAll("<jsontemplate name=\"", "").replaceAll("\">","").replaceAll("v1ElementTypeJson.","");
    }

    public static void main(String[] args) {
        String filePath = "/Users/harish-10327/Workspace/ZohoDesignStudio/repository/creator_repo/zohocreator/product_package/webapps/zohocreator/WEB-INF/security-authorization.xml";
        String nameToSearch = "elementSpacingTemplate" ;
        extractJsonTemplateBlocks(filePath, nameToSearch);
    }
}
