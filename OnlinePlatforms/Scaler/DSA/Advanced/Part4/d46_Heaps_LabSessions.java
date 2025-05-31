package OnlinePlatforms.Scaler.DSA.Advanced.Part4;

import Resources.Utilities.PrintHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Harish Velmurugan
 * @last-modified 31-05-2025
 * @since 31-05-2025
 */
public class d46_Heaps_LabSessions {


    private final PrintHelper printHelper = new PrintHelper();

    public static void main(String[] args) {

        // Inputs

        // Call Stack
        d46_Heaps_LabSessions d46HeapsLabSessions = new d46_Heaps_LabSessions();

    }

    /* Section : ----------------------------------- [ Approaches ] ------------------------------------ */

    public int distributeCandys(int[] A) {
        int n = A.length;
        int candies = 0;
        int[] candy = new int[A.length];
        Arrays.fill(candy, 1);
        for (int i = 1; i < n; i++) {
            if (A[i] > A[i - 1]) {
                candy[i] = candy[i - 1] + 1;
            }
        }

        for (int i = n-2; i >= 0; i--) {
            if (A[i] > A[i + 1]) {
                candy[i] = Math.max(candy[i + 1] + 1, candy[i]);
            }
        }

        for(int i=0; i<n; i++){
            candies += candy[i];
        }
        return candies;
    }

    public ListNode mergeKLists(ArrayList<ListNode> a) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((c, b) -> c.val - b.val);

        for (ListNode list : a) {
            if (list != null) {
                minHeap.add(list);
            }
        }
        ListNode dummyHead = new ListNode(-1);
        ListNode tail = dummyHead;
        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            if (node.next != null) {
                minHeap.add(node.next);
            }
            node.next = null;
            tail.next = node;
            tail = tail.next;
        }
        return dummyHead.next;
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

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
