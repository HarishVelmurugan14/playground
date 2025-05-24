package OnlinePlatforms.Scaler.DSA.Advanced.Part4;

import Resources.Utilities.PrintHelper;

/**
 * @author Harish Velmurugan
 * @last-modified 24-05-2025
 * @since 24-05-2025
 */
public class d51_DP_Knapsack {

    private final PrintHelper printHelper = new PrintHelper();

    public static void main(String[] args) {

        // Inputs


        // Call Stack
        d51_DP_Knapsack d51DpKnapsack = new d51_DP_Knapsack();
        System.out.println(d51DpKnapsack.maxValueForKnapsack(new int[]{60, 100, 120}, new int[]{10, 20, 30}, 50));


    }

    /* Section : ----------------------------------- [ Approaches ] ------------------------------------ */

    public int maxValueForKnapsack(int[] A, int[] B, int C) {
        int[][] memory = new int[A.length + 1][C + 1];
        for (int i = 0; i <= A.length; i++) {
            for (int j = 0; j <= C; j++) {
                memory[i][j] = -1;
            }
        }
        return maxValueForKnapsack(A, B, C, A.length - 1, memory);
    }

    public int maxValueForKnapsack(int[] values, int[] weights, int capacity, int index, int[][] memory) {
        if (index == 0) {
            if (weights[0] <= capacity) {
                return values[0];
            } else {
                return 0;
            }
        }
        if (memory[index][capacity] != -1) {
            return memory[index][capacity];
        }

        int ans = Integer.MIN_VALUE;
        //Option 1 : Select
        if (capacity >= weights[index]) {
            ans = values[index] + maxValueForKnapsack(values, weights, capacity - weights[index], index - 1, memory);
        }
        //Option 2 : NS
        ans = Math.max(ans, maxValueForKnapsack(values, weights, capacity, index - 1, memory));
        memory[index][capacity] = ans;
        return memory[index][capacity];
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
