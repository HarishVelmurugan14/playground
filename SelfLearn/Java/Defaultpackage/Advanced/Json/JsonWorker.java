package SelfLearn.Java.Defaultpackage.Advanced.Json;

import org.json.JSONObject;

import java.util.LinkedHashMap;
import java.util.Map;

public class JsonWorker {
    public static void main(String[] args) {
        String jsonString = "{\"logType\":\"AsyncFunction\",\"scopeId\":22829154,\"baseWorkflowName\":\"report_customaction_wf\"," +
                "\"asyncFunctionId\":6936004879410270703,\"logMessage\":\"[\\\"Error at line : 11, Error in performing th" +
                "e Operation /  : Divide by zero error\\\"]\",\"executionStatus\":\"FAILED\",\"debugInfo\":\"-\",\"comp" +
                "onent_ids\":[6936004879410270703],\"recordLinkId\":2000000181061,\"asyncFunctionTagName\":\"report_cust" +
                "omaction\",\"logTimestamp\":1726651929038,\"fqWorkflowName\":\"thisapp.FirstFunction\",\"baseWorkflowType" +
                "\":\"Report Workflow\",\"appId\":2000000000356,\"loginUserId\":-100,\"baseFormName\":\"Form1L\",\"logCate" +
                "gory\":\"user\",\"status\":\"failure\"}";
//        parser(jsonString);
        something(jsonString);
    }

    private static void parser(String jsonString){
        JSONObject jsonObject = new JSONObject(jsonString);
        jsonObject.put("jobId", jsonObject.get("asyncFunctionId"));
        jsonObject.put("jobFunction", jsonObject.get("fqWorkflowName"));
        jsonObject.put("tagName", jsonObject.get("asyncFunctionTagName"));
        jsonObject.put("recordId", jsonObject.get("recordLinkId"));

        jsonObject.remove("asyncFunctionId");
        jsonObject.remove("asyncFunctionTagName");
        jsonObject.remove("fqWorkflowName");
        jsonObject.remove("recordLinkId");

        jsonObject.remove("executionStatus");
        jsonObject.remove("debugInfo");
        jsonObject.remove("component_ids");
        jsonObject.remove("loginUserId");
        jsonObject.remove("logCategory");


        return;
    }


    private static void constructor(String jsonString){
        JSONObject jsonObject = new JSONObject(jsonString);
        JSONObject helperObject = new JSONObject();
        helperObject.put("status", jsonObject.get("status"));
        helperObject.put("scopeId", jsonObject.get("scopeId"));
        helperObject.put("appId", jsonObject.get("appId"));
        helperObject.put("logType", jsonObject.get("logType"));
        helperObject.put("baseFormName", jsonObject.get("baseFormName"));
        helperObject.put("recordId", jsonObject.get("recordLinkId"));
        helperObject.put("baseWorkflowType", jsonObject.get("baseWorkflowType"));
        helperObject.put("baseWorkflowName", jsonObject.get("baseWorkflowName"));

        helperObject.put("tagName", jsonObject.get("asyncFunctionTagName"));
        helperObject.put("jobFunction", jsonObject.get("fqWorkflowName"));
        helperObject.put("jobId", jsonObject.get("asyncFunctionId"));

        helperObject.put("logMessage", jsonObject.get("logMessage"));
        helperObject.put("logTimestamp", jsonObject.get("logTimestamp"));

        String s = helperObject.toString();

        return;
    }


    private static void something(String jsonString) {
        JSONObject jsonObject = new JSONObject(jsonString);
        Map<String, Object> orderedMap = new LinkedHashMap<>();
        orderedMap.put("status", jsonObject.get("status"));
        orderedMap.put("scopeId",jsonObject.get("scopeId"));
        orderedMap.put("logType", jsonObject.get("scopeId"));
        orderedMap.put("jobID", jsonObject.get("asyncFunctionId"));

        JSONObject jsonObject1 = new JSONObject(orderedMap);
        System.out.println(jsonObject1.toString(4));
    }

}
