package OnlinePlatforms.Scaler.DSA.Advanced.Part3;

import Resources.Utilities.PrintHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Harish Velmurugan
 * @last-modified 02-04-2025
 * @since 02-04-2025
 */
public class d36_Backtracking {


    private final PrintHelper printHelper = new PrintHelper();

    public static void main(String[] args) {

        // Inputs


        // Call Stack
        d36_Backtracking d36_backtracking = new d36_Backtracking();
//        d36_backtracking.generateParenthesis(3); // LC22
        d36_backtracking.generateSubsets(new int[]{1, 2, 3}); // LC22


    }

    /* Section : ----------------------------------- [ Approaches ] ------------------------------------ */

    public List<String> generateParenthesis(int n) {
        // Complexity : Time : [ O(2^2N)  ]
        // Complexity : Space : [ O(N) ]
        List<String> res = new ArrayList<>();
        res = backTracking(n, "", 0, 0, res);
        return res;
    }

    public List<String> backTracking(int n, String currentPattern, int openParenthesisCount, int closedParenthesisCount, List<String> result) {
        if (openParenthesisCount == n && closedParenthesisCount == n) {
            result.add(currentPattern);
            return result;
        }

        if (openParenthesisCount < n) {
            backTracking(n, currentPattern + "(", openParenthesisCount + 1, closedParenthesisCount, result);
        }

        if (closedParenthesisCount < openParenthesisCount) {
            backTracking(n, currentPattern + ")", openParenthesisCount, closedParenthesisCount + 1, result);
        }
        return result;
    }

    public List<List<Integer>> generateSubsets(int[] nums) {
        // Complexity : Time : [ O(2^N)  ]
        // Complexity : Space : [ O(N) ]
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums.length, nums, 0, new ArrayList<Integer>(), res);
        System.out.println(res.toString());
        return res;
    }

    private List<List<Integer>> dfs(int N, int[] nums, int index, List<Integer> currentList, List<List<Integer>> all) {
        if (index >= N) {
            System.out.println(currentList.toString());
            all.add(new ArrayList<>(currentList)); // VERY IMPORTANT
            return all;
        }

        currentList.add(nums[index]);
        dfs(N, nums, index + 1, currentList, all);
        currentList.remove(Integer.valueOf(nums[index]));
        dfs(N, nums, index + 1, currentList, all);

        return all;
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
