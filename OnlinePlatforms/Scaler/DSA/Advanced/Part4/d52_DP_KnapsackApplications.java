package OnlinePlatforms.Scaler.DSA.Advanced.Part4;

import Resources.Utilities.PrintHelper;

import java.util.Arrays;

/**
 * @author Harish Velmurugan
 * @last-modified 25-05-2025
 * @since 25-05-2025
 */
public class d52_DP_KnapsackApplications {


    private final PrintHelper printHelper = new PrintHelper();

    public static void main(String[] args) {

        // Inputs


        // Call Stack
        d52_DP_KnapsackApplications d52DpKnapsackApplications = new d52_DP_KnapsackApplications();
        System.out.println(d52DpKnapsackApplications.maxProfitFromRodCutting(new int[]{3, 4, 1, 6, 2}));

    }

    /* Section : ----------------------------------- [ Approaches ] ------------------------------------ */

    public int maxProfitFromRodCutting(int[] A) {
        //NOTE : HK1009
        // Complexity : Time : [ O(N^2) ]
        int[] memory = new int[A.length];
        Arrays.fill(memory, -1);
        return maxProfitFromRodCutting(A, A.length, memory);
    }

    public int maxProfitFromRodCutting(int[] A, int index, int[] memory) {
        if (index == 0) {
            return 0;
        }
        if (memory[index - 1] != -1) {
            return memory[index - 1];
        }

        int maxProfit = 0;
        for (int i = 1; i <= index; i++) {
            int currentProfit = A[i - 1] + maxProfitFromRodCutting(A, index - i, memory);
            maxProfit = Math.max(maxProfit, currentProfit);
        }
        memory[index - 1] = maxProfit;
        return memory[index - 1];
    }

    public void bruteForce() {
        // Complexity : Time : [  ]
        // Complexity : Space : [  ]


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
