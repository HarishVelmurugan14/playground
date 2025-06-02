package OnlinePlatforms.Scaler.DSA.Advanced.Part4;

import Resources.Utilities.PrintHelper;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

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

    public int[] kPlacesApart(int[] A, int places) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int[] res = new int[A.length];

        for (int i = 0; i <= places && i < A.length; i++) {
            minHeap.add(A[i]);
        }

        int idx = 0;
        for (int i = places + 1; i < A.length; i++) {
            res[idx++] = minHeap.poll();
            minHeap.add(A[i]);
        }

        while (!minHeap.isEmpty()) {
            res[idx++] = minHeap.poll();
        }
        return res;
    }

    public int minimumMeetingRoomsRequired(int numberOfMeetings, int[][] meetingInfo) {
        MeetingTime[] meeting = new MeetingTime[numberOfMeetings];
        for (int i = 0; i < numberOfMeetings; i++) {
            meeting[i] = new MeetingTime(meetingInfo[i][0], meetingInfo[i][1]);
        }

        Arrays.sort(meeting, Comparator.comparingInt(x -> x.start));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int meetingRooms = 0;
        for (int i = 0; i < numberOfMeetings; i++) {
            int currentStart = meeting[i].start;
            int currentEnd = meeting[i].end;
            minHeap.add(currentEnd);

            if (!minHeap.isEmpty() && currentStart >= minHeap.peek()) {
                minHeap.poll();
            } else {
                meetingRooms++;
            }
        }
        return meetingRooms;
    }

    public int shaggySpecialIndexMinimumDistance(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(A[i])) {
                int currentDistance = i - map.get(A[i]);
                minDistance = Math.min(minDistance, currentDistance);
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
                if (currentDistance <= k) {
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

class MeetingTime {
    int start;
    int end;

    public MeetingTime(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
