package OnlinePlatforms.Scaler.DSA.Advanced.Part4;

import Resources.Utilities.PrintHelper;

import java.util.Arrays;

/**
 * @author Harish Velmurugan
 * @last-modified 26-05-2025
 * @since 26-05-2025
 */
public class d45_Heaps_SortAndGreedy {


    private final PrintHelper printHelper = new PrintHelper();

    public static void main(String[] args) {

        // Inputs


        // Call Stack
        d45_Heaps_SortAndGreedy d45HeapsSortAndGreedy = new d45_Heaps_SortAndGreedy();
        d45HeapsSortAndGreedy.maxJobs(new int[]{1, 5, 7, 1}, new int[]{7, 8, 8, 8});

    }

    /* Section : ----------------------------------- [ Approaches ] ------------------------------------ */

    public int maxJobs(int[] A, int[] B) {
        int n = A.length;
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(A[i], B[i]);
        }
        Arrays.sort(jobs, (a, b) -> Integer.compare(a.endTime, b.endTime));
//        for (Job j : jobs) {
//            System.out.println(j.startTime + " -> " + j.endTime);
//        }
        int prev = 0;
        int jobsCount = 0;
        for (Job j : jobs) {
            int start = j.startTime;
            int end = j.endTime;
            if(start >= prev){
                prev = end;
                jobsCount++;
            }
        }
        System.out.println(jobsCount);
        return jobsCount;
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

class Job {
    int startTime;
    int endTime;

    public Job(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
