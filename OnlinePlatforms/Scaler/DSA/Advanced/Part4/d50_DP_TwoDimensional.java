package OnlinePlatforms.Scaler.DSA.Advanced.Part4;

import Resources.Utilities.PrintHelper;

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


    }

    /* Section : ----------------------------------- [ Approaches ] ------------------------------------ */

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
