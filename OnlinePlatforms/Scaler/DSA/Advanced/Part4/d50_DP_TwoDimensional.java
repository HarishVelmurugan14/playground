package OnlinePlatforms.Scaler.DSA.Advanced.Part4;

import Resources.Utilities.PrintHelper;
import java.util.Arrays;

/**
 * @author Harish Velmurugan
 * @last-modified 21-05-2025
 * @since 21-05-2025
 */
public class d50_DP_TwoDimensional {

    private final PrintHelper printHelper = new PrintHelper();

    public static void main(String[] args) {

        // Inputs


        // Call Stack
        d50_DP_TwoDimensional d50DpTwoDimensional = new d50_DP_TwoDimensional();

        int[][] x = new int[][]{{1, 2, 3, 4}, {2, 3, 4, 5}};
        int[][] y = new int[][]{{28}, {10}};
        d50DpTwoDimensional.maxSum(x);
        d50DpTwoDimensional.maxSum(y);
    }

    /* Section : ----------------------------------- [ Approaches ] ------------------------------------ */

    public int maxSum(int[][] A) {
        // NOTE : HK1003
        // Complexity : Time : [ O(N) ]
        // Complexity : Space : [  ]
        int[] memory = new int[A[0].length];
        Arrays.fill(memory, -1);
        int x = maxSum(A, A[0].length - 1, memory);
        System.out.println(x);
        return x;
    }

    public int maxSum(int[][] A, int col, int[] memory) {
        if (col < 0) return 0;
        if (col == 0) return Math.max(A[0][0], A[1][0]);

        if(memory[col] != -1){
            return memory[col];
        }

        //Option 1 : Consider top element and skip prev column
        int option1Res = A[0][col] + maxSum(A, col - 2, memory);
        //Option 2 : Consider bottom element and skip prev column
        int option2Res = A[1][col] + maxSum(A, col - 2, memory);
        //Option 1 : Skip current column
        int option3Res = maxSum(A, col - 1, memory);

        memory[col] = Math.max(Math.max(option1Res, option2Res), option3Res);

        return memory[col];
    }


    public int uniquePathsWithObstacles(int[][] A) {
        return path(A, A.length - 1, A[0].length - 1);
    }

    public int path(int[][] A, int n, int m) {
        if (A[n][m] == 1) {
            return 0;
        } else if (n == 0 && m == 0) {
            return 1;
        }

        return (n > 0 ? path(A, n - 1, m) : 0) + (m > 0 ? path(A, n, m - 1) : 0);
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
