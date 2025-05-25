package OnlinePlatforms.Scaler.DSA.Advanced.Part4;

import Resources.Utilities.PrintHelper;

import java.util.HashMap;

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
        System.out.println(d51DpKnapsack.unboundedKnapsack(10, new int[]{6, 7}, new int[]{5, 5}));
        System.out.println(d51DpKnapsack.unboundedKnapsackMapApproach(10, new int[]{6, 7}, new int[]{5, 5}));
    }

    /* Section : ----------------------------------- [ Approaches ] ------------------------------------ */
    public int unboundedKnapsackMapApproach(int A, int[] B, int[] C) {
        HashMap<String, Integer> memory = new HashMap<>();
        return unboundedKnapsackMapApproach(A, B.length - 1, B, C, memory);
    }

    public String getKey(int index, int capacity) {
        return index + "," + capacity;
    }

    public int unboundedKnapsackMapApproach(int capacity, int index, int[] values, int[] weights, HashMap<String, Integer> memory) {
        if (index == 0) {
            if (capacity >= weights[0]) {
                return values[0];
            } else {
                return 0;
            }
        }
        if (memory.containsKey(getKey(index, capacity))) {
            return memory.get(getKey(index, capacity));
        }

        // Option 1 : Not Select
        int ans = unboundedKnapsackMapApproach(capacity, index - 1, values, weights, memory);
        // Option 2 : Select
        if (capacity >= weights[index]) {
            ans = Math.max(ans, values[index] + unboundedKnapsackMapApproach(capacity - weights[index], index, values, weights, memory));
        }
        memory.put(getKey(index, capacity), ans);
        return memory.get(getKey(index, capacity));
    }

    public int unboundedKnapsack(int A, int[] B, int[] C) {
        //NOTE: HK1007
        int[][] memory = new int[B.length + 1][A + 1];
        for (int i = 0; i <= B.length; i++) {
            for (int j = 0; j <= A; j++) {
                memory[i][j] = -1;
            }
        }
        return unboundedKnapsack(A, B.length - 1, B, C, memory);
    }


    public int unboundedKnapsack(int capacity, int index, int[] values, int[] weights, int[][] memory) {
        if (index == 0) {
            if (capacity >= weights[0]) {
                return values[0];
            } else {
                return 0;
            }
        }
        if (memory[index][capacity] != -1) {
            return memory[index][capacity];
        }

        // Option 1 : Not Select
        int ans = unboundedKnapsack(capacity, index - 1, values, weights, memory);
        // Option 2 : Select
        if (capacity >= weights[index]) {
            ans = Math.max(ans, values[index] + unboundedKnapsack(capacity - weights[index], index, values, weights, memory));
        }
        memory[index][capacity] = ans;
        return memory[index][capacity];
    }


    public int maxValueForKnapsack(int[] A, int[] B, int C) {
        //NOTE: HK1006
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
