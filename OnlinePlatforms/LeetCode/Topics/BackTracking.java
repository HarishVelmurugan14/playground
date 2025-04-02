package OnlinePlatforms.LeetCode.Topics;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("StringTemplateMigration")
public class BackTracking {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backTracking(n, "", 0, 0, res);
        return res;
    }

    public List<String> backTracking(int n, String currentPattern, int openParenthesisCount, int closedParenthesisCount, List<String> result){
        if(openParenthesisCount == n && closedParenthesisCount == n){
            result.add(currentPattern);
            return result;
        }

        if(openParenthesisCount < n){
            backTracking(n, currentPattern + "(", openParenthesisCount+1, closedParenthesisCount, result);
        }

        if(closedParenthesisCount < openParenthesisCount){
            backTracking(n, currentPattern + ")", openParenthesisCount, closedParenthesisCount+1, result);
        }
        return result;
    }
}
