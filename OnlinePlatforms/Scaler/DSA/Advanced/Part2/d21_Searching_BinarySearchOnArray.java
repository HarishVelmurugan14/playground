package OnlinePlatforms.Scaler.DSA.Advanced.Part2;

import Resources.Utilities.PrintHelper;

/**
 * @author Harish Velmurugan
 * @last-modified 22-02-2025
 * @since 22-02-2025
 */
@SuppressWarnings({"AutoRefact", "ConstantValue"})
public class d21_Searching_BinarySearchOnArray {


    private final PrintHelper printHelper = new PrintHelper();

    public static void main(String[] args) {

        // Inputs


        // Call Stack
        d21_Searching_BinarySearchOnArray d21SearchingBinarySearchOnArray = new d21_Searching_BinarySearchOnArray();
        d21SearchingBinarySearchOnArray.searchForStartAndEndIndexOfAnElementInAnArray();
        d21SearchingBinarySearchOnArray.positionWhereTargetIsPresentOrShouldBeInserted();
        d21SearchingBinarySearchOnArray.singleElementInASortedArray();


    }

    /* Section : ----------------------------------- [ Approaches ] ------------------------------------ */

    public int singleElementInASortedArray() {
        // Complexity : Time : [ O(logN) ]
        // Complexity : Space : [ O(1) ]
        /*
        Given a sorted array of integers A where every element appears twice except for one
        element which appears once, find and return this single element that appears only once.
        Elements which are appearing twice are adjacent to each other.
        Users are expected to solve this in O(log(N)) time.
            */

        int[] A = {1, 1, 2, 2, 3, 3, 4, 5, 5};

        int N = A.length;

        if (N == 1) {
            return A[0];
        }
        if (A[0] != A[1]) {
            return A[0];
        }
        if (A[N - 1] != A[N - 2]) {
            return A[N - 1];
        }

        int low = 1;
        int high = N - 2;


        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (A[mid] == A[mid + 1]) {
                if (mid % 2 == 0) {
                    low = mid + 2;
                } else {
                    high = mid - 1;
                }
            } else if (A[mid] == A[mid - 1]) {
                mid = mid - 1;
                if (mid % 2 == 0) {
                    low = mid + 2;
                } else {
                    high = mid - 1;
                }
            } else {

                System.out.println(mid);
                return mid;

            }
        }
        return -1;
    }

    public int[] searchForStartAndEndIndexOfAnElementInAnArray() {
        // Complexity : Time : [ O(logN) ]
        // Complexity : Space : [ O(1) ]
        /* QUESTION :
        Given a sorted array of integers A(0 - indexed) of size N, find the left most and the right most
        index of a given integer B in the array A.
        Return an array of size 2, such that First element = Left most index of B in A
        Second element = Right most index of B in A.
        If B is not found in A,return [-1, -1].
        The time complexity of your algorithm must be O(log n).
        A = {5, 7, 7, 8, 8, 10};
        B = 8;
        output: [3, 4]; */

        int[] A = {5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7, 7, 7, 8, 8, 10};
        int B = 7;
        int N = A.length;
        int[] result = new int[]{-1, -1};

        if (N == 0) {
            return result;
        }

        int low = 0;
        int high = N - 1;
        int first = -1;
        int last = -1;

        // Finding the 1st occurrence
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (A[mid] < B) {
                low = mid + 1;
            } else if (A[mid] > B) {
                high = mid - 1;
            } else {
                first = mid;
                high = mid - 1; // continue searching towards the left
            }
        }

        // Finding the last occurrence
        low = 0;
        high = N - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (A[mid] < B) {
                low = mid + 1;
            } else if (A[mid] > B) {
                high = mid - 1;
            } else {
                last = mid;
                low = mid + 1; // continue searching towards the right
            }
        }

        // Checking if B was found
        if (first != -1 && last != -1) {
            result[0] = first;
            result[1] = last;
        }

        return result;
    }

    public int positionWhereTargetIsPresentOrShouldBeInserted() {
        // Complexity : Time : [ O(logN) ]
        // Complexity : Space : [ O(1) ]
        /* QUESTION
        You are given a sorted array A of size N and a target value B.
        Your task is to find the index (0-based indexing) of the target value in the array.

        If the target value is present, return its index.
        If the target value is not found, return the index of least element greater than equal to B.
        If the target value is not found and least number greater than equal to target is also not present,
        return the length of array (i.e. the position where target can be placed)
        Your solution should have a time complexity of O(log(N)).
        */

        int[] A = {1, 2, 2, 3, 5, 6, 7, 8, 9};
        int B = 11;

        int N = A.length;
        int low = 0;
        int high = N - 1;
        int res = N;

        while (low <= high) {
            int mid = low + ((high - low) / 2);

            if (A[mid] < B) {
                low = mid + 1;
            } else if (A[mid] > B) {
                res = mid;
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return res;
    }

    /* Section : ------------------------------- [ Problems ] ------------------------------- */



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
