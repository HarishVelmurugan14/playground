package OnlinePlatforms.Scaler.DSA.Feb.Week1;

import Resources.Utilities.PrintHelper;

import java.util.ArrayList;

/**
 * @author Harish Velmurugan
 * @last-modified 03-02-2025
 * @since 03-02-2025
 */
public class RecursionTwo_1 {


    private final PrintHelper printHelper = new PrintHelper();

    public static void main(String[] args) {

        // Inputs

        int[] A = {3, 2, 3, 4, 5, 3};

        // Call Stack
        RecursionTwo_1 recursionTwo3 = new RecursionTwo_1();
        recursionTwo3.powerOfANumberUsingRecursion();
        recursionTwo3.printArray(A, A.length - 1);
        ArrayList<Integer> res = recursionTwo3.printTargetIndex_Harish(A, A.length, 3, new ArrayList<>());
        recursionTwo3.print("", res);
        ArrayList<Integer> res1 = recursionTwo3.printTargetIndex_Yahnit(A, A.length, 3);
        recursionTwo3.print("", res1);
        String s = "malayalam";
        char[] array = s.toCharArray();
        recursionTwo3.checkForPalindrome(array, 0, array.length - 1);

        recursionTwo3.towerOfHanoi(4, 1, 2, 3);
        System.out.println("--------------------");
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        recursionTwo3.towerOfHanoi_list(4, 1, 2, 3, result);

        for (ArrayList<Integer> ar : result) {
            recursionTwo3.print("", ar);
        }


    }

    /* Section : ----------------------------------- [ Problems ] ------------------------------------ */

    private void towerOfHanoi(int n, int source, int helper, int destination) {
        //https://www.youtube.com/watch?v=usOtwunz0oM - CodingNinjas
        // Complexity : Time : [ O(2^N) ]
        // Complexity : Space : [ O(N) ]
        if (n == 0) {
            return;
        }
        towerOfHanoi(n - 1, source, destination, helper);
        // at this state largest element is left element in rod A
        System.out.println(n + " : " + source + " -> " + destination);
        towerOfHanoi(n - 1, helper, source, destination);
    }


    private ArrayList<ArrayList<Integer>> towerOfHanoi_list(int n, int source, int helper, int destination, ArrayList<ArrayList<Integer>> result) {
        if (n == 0) {
            return new ArrayList<>();
        }
        towerOfHanoi_list(n - 1, source, destination, helper, result);
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(n);
        temp.add(source);
        temp.add(destination);
        result.add(temp);
        towerOfHanoi_list(n - 1, helper, source, destination, result);
        return result;
    }

    private void powerOfANumberUsingRecursion() {
        int x = powerOfANumberUsingRecursion_brute(5, 3);
        System.out.println(x);
        x = powerOfANumberUsingRecursion_approach2(5, 3);
        System.out.println(x);
    }


    private int powerOfANumberUsingRecursion_brute(int A, int N) {
        // Complexity : Time : [ O(N) ]
        // Complexity : Space : [ O(N) ]
        if (N == 0) {
            return 1;
        }
        return A * powerOfANumberUsingRecursion_brute(A, N - 1);
    }

    private int powerOfANumberUsingRecursion_approach2(int A, int N) {
        // Technique : Fast Exponentiation | Binary Exponentiation
        // Complexity : Time : [ O(logN) ]
        // Complexity : Space : [ O(logN) ]
        if (N == 0) {
            return 1;
        }
        int halfPower = powerOfANumberUsingRecursion_approach2(A, N / 2);

        if ((N & 1) == 0) { // Even
            return halfPower * halfPower;
        } else {
            return halfPower * halfPower * A;
        }
    }


    private void printArray(int[] A, int n) {
        // Complexity : Time : [ O(N) ]
        // Complexity : Space : [ O(N) ]
        System.out.println(A[n]);
        if (n == 0) {
            return;
        }
        printArray(A, n - 1);
    }


    private ArrayList<Integer> printTargetIndex_Harish(int[] A, int n, int B, ArrayList<Integer> returnList) {
        // Complexity : Time : [ O(N) ]
        // Complexity : Space : [ O(N) ]
        if (n == 0) {
            return returnList;
        }
        printTargetIndex_Harish(A, n - 1, B, returnList);
        if (A[n - 1] == B) {
            returnList.add(n - 1);
        }
        return returnList;
    }

    private ArrayList<Integer> printTargetIndex_Yahnit(int[] A, int n, int B) {
        if (n == 0) {
            return new ArrayList<>();
        }
        ArrayList<Integer> arrayList = printTargetIndex_Yahnit(A, n - 1, B);
        if (A[n - 1] == B) {
            arrayList.add(n - 1);
        }
        return arrayList;
    }

    private boolean checkForPalindrome(char[] array, int start, int end) {
        // Complexity : Time : [ O(N/2) ]
        // Complexity : Space : [ O(N/2) ]
        if (start >= end) {
            return true;
        }
        if ((array[start] == array[end]) && checkForPalindrome(array, start + 1, end - 1)) {
            return true;
        }
        return false;
    }


    /* Section : ------------------------------- [ Specific Utilities ] ------------------------------- */



    /* Section : ------------------------------- [ Generic Utilities ] ------------------------------- */

    private void print(String message) {
        printHelper.print(message, "");
    }

    private void print(String message, ArrayList<Integer> result) {
        printHelper.print(message, result);
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
