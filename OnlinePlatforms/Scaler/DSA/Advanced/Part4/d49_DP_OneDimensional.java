package OnlinePlatforms.Scaler.DSA.Advanced.Part4;

import Resources.Utilities.PrintHelper;

import java.util.Arrays;

/**
 * @author Harish Velmurugan
 * @since 21-05-2025
 * @last-modified 21-05-2025
 */
public class d49_DP_OneDimensional {

    private final PrintHelper printHelper = new PrintHelper();


    public static void main(String[] args) {

        // Inputs


//        You are climbing a staircase and it takes A steps to reach the top.
//        Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
//                Return the number of distinct ways modulo 1000000007

        // Call Stack
        d49_DP_OneDimensional d49_DP_OneDimensional = new d49_DP_OneDimensional();
    }

    /* Section : ----------------------------------- [ Approaches ] ------------------------------------ */

    public int MOD = 1_000_000_007;
    public int climbStairs_bottomUp(int A) {
        //NOTE : HK1001
        if (A == 1 || A == 2) return A;

        long prev2 = 1; // f(1)
        long prev1 = 2; // f(2)

        for (int i = 3; i <= A; i++) {
            long current = (prev1 + prev2) % MOD;
            prev2 = prev1;
            prev1 = current;
        }

        return (int) prev1;
    }


    public int climbStairs_topDown(int A) {
        int MOD = 1000000007;
        int[] memory = new int[A+1];
        Arrays.fill(memory, -1);
        return climbStairs(A, MOD, memory);
    }

    public int climbStairs(int A, int MOD, int[] memory) {
        if(A == 1 || A==2){
            return A;
        }
        if(memory[A] != -1){
            return memory[A];
        }
        memory[A] = (int)(((long)climbStairs(A - 1, MOD, memory) + (long)climbStairs(A - 2, MOD, memory)) % MOD);
        return memory[A];
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
