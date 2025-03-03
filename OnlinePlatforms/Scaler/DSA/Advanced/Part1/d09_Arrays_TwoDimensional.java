package OnlinePlatforms.Scaler.DSA.Advanced.Part1;

import Resources.Utilities.PrintHelper;

/**
 * @author Harish Velmurugan
 * @last-modified 06-02-2025
 * @since 06-02-2025
 */

public class d09_Arrays_TwoDimensional {


    private final PrintHelper printHelper = new PrintHelper();

    public static void main(String[] args) {

        // Inputs


        // Call Stack
        d09_Arrays_TwoDimensional twoDimensionalArray1 = new d09_Arrays_TwoDimensional();
        twoDimensionalArray1.searchInARowWiseAndColumnWiseSortedMatrix();
        int[][] A = twoDimensionalArray1.generateSquareMatrixInSpiralOrder(2);
        int x = twoDimensionalArray1.sumOfAllPossibleSubMatrices(A);
        System.out.println(x);
    }

    /* Section : ----------------------------------- [ Problems ] ------------------------------------ */

    public int sumOfAllPossibleSubMatrices(int[][] A) {
        // Contribution Technique
        int N = A.length;
        int M = A[0].length;
        int sum = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int elementContribution = (i + 1) * (N - i) * (j + 1) * (M - j);
                sum += elementContribution * A[i][j];
            }
        }
        return sum;
    }

    public int[][] generateSquareMatrixInSpiralOrder(int A) {
        int[][] returnMatrix = new int[A][A];
        int i = 0;
        int j = 0;
        int count = 1;

        while (A > 1) {
            for (int k = 0; k < A - 1; k++) {
                returnMatrix[i][j] = count;
                j++;
                count++;
            }

            for (int k = 0; k < A - 1; k++) {
                returnMatrix[i][j] = count;
                i++;
                count++;
            }

            for (int k = 0; k < A - 1; k++) {
                returnMatrix[i][j] = count;
                j--;
                count++;
            }

            for (int k = 0; k < A - 1; k++) {
                returnMatrix[i][j] = count;
                i--;
                count++;
            }

            i++;
            j++;
            A = A - 2;

        }

        if (A == 1) {
            returnMatrix[i][j] = count;
        }


        print("", returnMatrix);

        return returnMatrix;
    }


    public void searchInARowWiseAndColumnWiseSortedMatrix() {
        // Complexity : Time : [  ]
        // Complexity : Space : [  ]
        int[][] A = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int B = 2;
        int N = A.length;
        int M = A[0].length;
        int ans = Integer.MAX_VALUE;
        boolean isPresent = false;
        int row = 0;
        int col = M - 1;
        while (row < N && col >= 0) {
            int target = A[row][col];
            if (target == B) {
                int currentAns = ((row + 1) * 1009) + col + 1;
                System.out.println(currentAns);
                if (currentAns < ans) {
                    isPresent = true;
                    ans = currentAns;
                }
                col--;
            } else if (target > B) {
                col--;
            } else {
                row++;
            }
        }
        System.out.println();
        System.out.println(ans);
    }

    /* Section : ------------------------------- [ Specific Utilities ] ------------------------------- */



    /* Section : ------------------------------- [ Generic Utilities ] ------------------------------- */

    private void print(String message) {
        printHelper.print(message, "");
    }

    private void print(String message, int[][] matrix) {
        printHelper.print(message, matrix);
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
