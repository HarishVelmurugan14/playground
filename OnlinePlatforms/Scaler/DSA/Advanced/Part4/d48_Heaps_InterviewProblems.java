package OnlinePlatforms.Scaler.DSA.Advanced.Part4;

import Resources.Utilities.PrintHelper;

import java.util.HashMap;

/**
 * @author Harish Velmurugan
 * @last-modified 02-06-2025
 * @since 02-06-2025
 */
public class d48_Heaps_InterviewProblems {


    private final PrintHelper printHelper = new PrintHelper();

    public static void main(String[] args) {

        // Inputs


        // Call Stack
        d48_Heaps_InterviewProblems d48HeapsInterviewProblems = new d48_Heaps_InterviewProblems();


    }

    /* Section : ----------------------------------- [ Approaches ] ------------------------------------ */

    public int shaggySpecialIndexMinimumDistance(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(A[i])) {
                int currentDistance = i - map.get(A[i]);
                minDistance =  Math.min(minDistance, currentDistance);
                map.put(A[i], i);
            } else {
                map.put(A[i], i);
            }
        }
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int currentDistance = i - map.get(nums[i]);
                if(currentDistance <= k){
                    return true;
                }
                map.put(nums[i], i);
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
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
