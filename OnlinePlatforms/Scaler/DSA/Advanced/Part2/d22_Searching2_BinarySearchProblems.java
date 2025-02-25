package OnlinePlatforms.Scaler.DSA.Advanced.Part2;

import Resources.Utilities.PrintHelper;

/**
 * @author Harish Velmurugan
 * @last-modified 25-02-2025
 * @since 25-02-2025
 */
@SuppressWarnings("UnusedReturnValue")
public class d22_Searching2_BinarySearchProblems {

    private final PrintHelper printHelper = new PrintHelper();

    public static void main(String[] args) {

        // Inputs


        // Call Stack
        d22_Searching2_BinarySearchProblems d22Searching2BinarySearchProblems = new d22_Searching2_BinarySearchProblems();
//        d22Searching2BinarySearchProblems.squareRootOfANumber(4); // Q1
        d22Searching2BinarySearchProblems.rotatedSortedArraySearch();

    }

    /* Section : ----------------------------------- [ Problems ] ------------------------------------ */

    public int squareRootOfANumber(int A) {
        // Complexity : Time : [ O(logN) ]
        // Complexity : Space : [ O(1) ]
        /* QUESTION:
        Given an integer A. Compute and return the square root of A.
        If A is not a perfect square, return floor(sqrt(A)).
        The value of A*A can cross the range of Integer.
        Do not use the sqrt function from the standard library.
        Users are expected to solve this in O(log(A)) time.
        */

        long low = 1;
        long high = A / 2;
        long sqrt = 1;

        if (A == 0) {
            return 0;
        }

        while (low <= high) {
            long mid = low + ((high - low) / 2);
            long numPos = mid * mid;
            if (numPos <= A) {
                sqrt = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return (int) sqrt;
    }

    public int rotatedSortedArraySearch() {
        // Complexity : Time : [  ]
        // Complexity : Space : [  ]
        /* QUESTION :
        Given a sorted array of integers A of size N and an integer B,
        where array A is rotated at some pivot unknown beforehand.
        For example, the array [0, 1, 2, 4, 5, 6, 7] might become [4, 5, 6, 7, 0, 1, 2].
        Your task is to search for the target value B in the array. If found, return its index; otherwise, return -1.
        You can assume that no duplicates exist in the array.
        You are expected to solve this problem with a time complexity of O(log(N)).
        */

        int[] A = {9, 10, 3, 5, 6, 8};
        int B = 5;

        int N = A.length;
        int low = 0;
        int high = N - 1;
        int k = rotationFactor(A);

        if (B == A[0]) {
            return 0;
        } else if (B > A[0]) {
            high = k > 0 ? k - 1 : N - 1; // Case where rotation factor is 0
        } else {
            low = k;
        }

        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (B < A[mid]) {
                high = mid - 1;
            } else if (B > A[mid]) {
                low = mid + 1;
            } else {
                System.out.println(mid);
                return mid;
            }
        }
        return -1;

    }

    public int rotationFactor(int[] A) {
        int N = A.length;
        int low = 0;
        int high = N - 1;
        int rotationFactor = 0;
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (A[mid] >= A[0]) {
                low = mid + 1;
            } else {
                rotationFactor = mid;
                high = mid - 1;
            }
        }
        System.out.println(rotationFactor);
        return rotationFactor;
    }

    /* Section : ------------------------------- [Additional Problems ] ------------------------------------ */

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
