package OnlinePlatforms.Scaler.DSA.Jan.Lectures.Week4;

import Resources.Utilities.PrintHelper;

import java.util.HashMap;

/**
 * @author Harish Velmurugan
 * @last-modified 27-01-2025
 * @since 27-01-2025
 */
public class BitManipulationTwo_1 {


    private final PrintHelper printHelper = new PrintHelper();

    public static void main(String[] args) {

        // Inputs


        // Call Stack
        BitManipulationTwo_1 bitManipulationTwo1 = new BitManipulationTwo_1();
        bitManipulationTwo1.tripleTrouble();
        bitManipulationTwo1.twoUniqueElements();
        int[] A = {1, 0, 0, 0, 1, 0, 1};
        bitManipulationTwo1.numberOfSubArraysWithOr0(A);
        bitManipulationTwo1.numberOfSubArraysWithOr1(A);


    }

    /* Section : ----------------------------------- [ Approaches ] ------------------------------------ */

    public void bruteForce() {
        // Complexity : Time : [  ]
        // Complexity : Space : [  ]


    }

    public void optimal() {
        // Complexity : Time : [  ]
        // Complexity : Space : [  ]


    }

    private int tripleTrouble_approach3() {
        // Complexity : Time : [ O(N) ]
        // Complexity : Space : [ O(N) ]

        int[] A = {4, 4, 4, 2, 2, 2, 5, 7, 7, 7};

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i : A) {
            if (hashMap.containsKey(i)) {
                hashMap.put(i, hashMap.get(i) + 1);
            } else {
                hashMap.put(i, 1);
            }
        }

        for (int i : hashMap.keySet()) {
            if (hashMap.get(i) == 1) {
                return i;
            }
        }
        return -1;
    }

    private void tripleTrouble_approach4() {
        // Complexity : Time : [ O(N) ]
        // Complexity : Space : [ O(1) ]
        int[] A = {4, 4, 4, 2, 7, 7, 7};
        int n = A.length;

        int result = 0;
        /*
         * instead of 32 we can find max of array and iterate up to  the bit which the max number has
         *
         * */


        for (int i = 0; i < 32; i++) {
            int currentBitSetCount = 0;
            for (int j = 0; j < n; j++) {
                if (checkIfIthBitIsSet(A[j], i)) {
                    currentBitSetCount++;
                }
            }
            if (currentBitSetCount % 3 == 1) {
                result = setIthBit(result, i);
            }
        }
        System.out.println("AP 4 :" + result);
    }

    /* Section : ------------------------------- [ Problems ] ------------------------------- */

    private void tripleTrouble() {
        // Int array where every element is occurring 3 times except 1 number. Identify that. Without extra space

        int x = tripleTrouble_approach3();
        System.out.println(x);
        tripleTrouble_approach4();
    }

    private void twoUniqueElements() {
        // Complexity : Time : [ O(N) ]
        // Complexity : Space : [ O(1) ]

        // all element occurs twice except 2
        int[] A = {4, 4, 5, 5, 6, 6, 3, 1, 7, 7};

        int xorAll = 0;
        for (int i : A) {
            xorAll ^= i;
        }
        System.out.println(xorAll);

        int num1 = 0;
        int num2 = 0;
        int magicIndex = 0;
        for (int i = 0; i < 32; i++) {
            if (checkIfIthBitIsSet(xorAll, i)) {
                magicIndex = i;
            }
        }
        System.out.println("Magic " + magicIndex);

        for (int i = 0; i < A.length; i++) {
            if (checkIfIthBitIsSet(A[i], magicIndex)) {
                num1 ^= A[i];
            } else {
                num2 ^= A[i];
            }
        }
        System.out.println(num1 + " - " + num2);
    }

    private int numberOfSubArraysWithOr0(int[] A) {
        // Complexity : Time : [ O(N) ]
        // Complexity : Space : [ O(1) ]


        int result = 0;
        int countZero = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                countZero++;
            } else {
                result = result + (countZero * (countZero + 1)) / 2;
                countZero = 0;
            }
        }
        result = result + (countZero * (countZero + 1)) / 2;

        System.out.println(result);
        return result;
    }

    private int numberOfSubArraysWithOr1(int[] A) {
        int n = A.length;
        int totalSubArrayCount = (n * (n + 1)) / 2;
        int subArrayWithNo1 = numberOfSubArraysWithOr0(A);
        return totalSubArrayCount - subArrayWithNo1;
    }

    /* Section : ------------------------------- [ Specific Utilities ] ------------------------------- */


    private boolean checkIfIthBitIsSet(int num, int pos) {
        return (num & (1 << pos)) == 1 << pos;
    }

    private int setIthBit(int num, int pos) {
        return num | (1 << pos);
    }



    /* Section : ------------------------------- [ Generic Utilities ] ------------------------------- */

    private void print(String message, int a) {
        printHelper.print(message, a);
    }

    private void print(String message, int[] array) {
        printHelper.print(message, array);
    }

    private void print(String message, int[][] matrix) {
        printHelper.print(message, matrix);
    }

    /* Section : ------------------------------- [ Definition Resources ] ---------------------------- */

    private void definitions() {
        /*
        * Notebook_06012025
        * */
    }

    private void links() {
        /*
        * /academy/mentee-dashboard/class/345231/session?navref=cl_dd
        * */
    }

    /* Section : --------------------------------------- [ End ] ------------------------------------ */


}
