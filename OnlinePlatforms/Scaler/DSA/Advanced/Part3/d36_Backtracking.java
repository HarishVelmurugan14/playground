package OnlinePlatforms.Scaler.DSA.Advanced.Part3;

import Resources.Utilities.PrintHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Harish Velmurugan
 * @since 02-04-2025
 * @last-modified 02-04-2025
 */
public class d36_Backtracking {



    private final PrintHelper printHelper = new PrintHelper();

    public static void main(String[] args) {

        // Inputs


        // Call Stack
        d36_Backtracking d36_backtracking = new d36_Backtracking();
        d36_backtracking.generateParenthesis(3); // LC22


    }

    /* Section : ----------------------------------- [ Approaches ] ------------------------------------ */

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



    public void optimal() {
        // Complexity : Time : [  ]
        // Complexity : Space : [  ]


    }

    /* Section : ------------------------------- [ Specific Utilities ] ------------------------------- */



    /* Section : ------------------------------- [ Generic Utilities ] ------------------------------- */

    private void print(String message) {
        printHelper.print(message, "");
    }

    /* Section : ------------------------------- [ Definition Resources ] ---------------------------- */

    private void definitions() {
        /**/
    }

    private void links() {
        /**/
    }

    /* Section : --------------------------------------- [ End ] ------------------------------------ */


}
