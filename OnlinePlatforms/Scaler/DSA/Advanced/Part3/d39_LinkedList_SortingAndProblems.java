package OnlinePlatforms.Scaler.DSA.Advanced.Part3;

import Resources.Utilities.PrintHelper;

/**
 * @author Harish Velmurugan
 * @last-modified 07-04-2025
 * @since 07-04-2025
 */
@SuppressWarnings("ClassEscapesDefinedScope")
public class d39_LinkedList_SortingAndProblems {


    private final PrintHelper printHelper = new PrintHelper();

    public static void main(String[] args) {

        // Inputs


        // Call Stack
        d39_LinkedList_SortingAndProblems d39_linkedList_sortingAndProblems = new d39_LinkedList_SortingAndProblems();
        ListNode head = d39_linkedList_sortingAndProblems.insertAtHead(null, 8);
        head = d39_linkedList_sortingAndProblems.insertAtHead(head, 7);
        head = d39_linkedList_sortingAndProblems.insertAtHead(head, 6);
        head = d39_linkedList_sortingAndProblems.insertAtHead(head, 5);
        head = d39_linkedList_sortingAndProblems.insertAtHead(head, 4);
        head = d39_linkedList_sortingAndProblems.insertAtHead(head, 3);
        head = d39_linkedList_sortingAndProblems.insertAtHead(head, 2);
        head = d39_linkedList_sortingAndProblems.insertAtHead(head, 1);
        head = d39_linkedList_sortingAndProblems.insertAtHead(head, 0);

        ListNode middle = d39_linkedList_sortingAndProblems.middleNodeOfALinkedList(head);
        System.out.println(middle.val + " - " + middle.next.val);
        middle = d39_linkedList_sortingAndProblems.middleNodeOfALinkedListIfEvenConsiderFirst(head);
        System.out.println(middle.val + " - " + middle.next.val);

    }

    /* Section : ----------------------------------- [ Approaches ] ------------------------------------ */

    public ListNode middleNodeOfALinkedList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode middleNodeOfALinkedListIfEvenConsiderFirst(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast.next != null && fast.next.next == null) {
                return slow;
            }
        }
        return slow;
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

    public ListNode insertAtHead(ListNode A, int B) {
        ListNode x = new ListNode(B);
        x.next = A;
        return x;
    }

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


    static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
