package OnlinePlatforms.Scaler.DSA.Advanced.Part3;

import Resources.Utilities.PrintHelper;

/**
 * @author Harish Velmurugan
 * @last-modified 07-04-2025
 * @since 07-04-2025
 */
@SuppressWarnings({"ClassEscapesDefinedScope", "AutoRefact", "StringTemplateMigration"})
public class d39_LinkedList_SortingAndProblems {


    private final PrintHelper printHelper = new PrintHelper();

    public static void main(String[] args) {

        // Inputs


        // Call Stack
        d39_LinkedList_SortingAndProblems d39_linkedList_sortingAndProblems = new d39_LinkedList_SortingAndProblems();
        ListNode middle = d39_linkedList_sortingAndProblems.middleNodeOfALinkedList(head());
        printALinkedList(middle);
        middle = d39_linkedList_sortingAndProblems.findMiddle(head());
        printALinkedList(middle);
        ListNode merge = d39_linkedList_sortingAndProblems.mergeTwoSortedLinkedList(sortedP1Head(), sortedP2Head());
        printALinkedList(merge);
        System.out.println("--");
        printALinkedList(unSortedHead());
        ListNode afterSort = d39_linkedList_sortingAndProblems.mergeSortLinkedList(unSortedHead());
        printALinkedList(afterSort);

        int isPalindrome = d39_linkedList_sortingAndProblems.isPalindromeLinkedList(palindrome());
        System.out.println(isPalindrome);
        isPalindrome = d39_linkedList_sortingAndProblems.isPalindromeLinkedList(head());
        System.out.println(isPalindrome);

        printALinkedList(d39_linkedList_sortingAndProblems.addTwoNumbersInReverseOrderAndReturnAsLinkedList(head(), head()));
    }

    /* Section : ----------------------------------- [ Inputs ] ------------------------------------ */

    private static ListNode head() {
        ListNode head = insertAtHead(null, 4);
        head = insertAtHead(head, 3);
        head = insertAtHead(head, 2);
        head = insertAtHead(head, 1);
        head = insertAtHead(head, 0);
        return head;
    }

    private static ListNode sortedP1Head() {
        ListNode head = insertAtHead(null, 8);
        head = insertAtHead(head, 7);
        head = insertAtHead(head, 5);
        head = insertAtHead(head, 1);
        head = insertAtHead(head, 0);
        return head;
    }

    private static ListNode sortedP2Head() {
        ListNode head = insertAtHead(null, 9);
        head = insertAtHead(head, 6);
        head = insertAtHead(head, 3);
        head = insertAtHead(head, 2);
        return head;
    }

    private static ListNode unSortedHead() {
        ListNode head = insertAtHead(null, 8);
        head = insertAtHead(head, 1);
        head = insertAtHead(head, 5);
        head = insertAtHead(head, 0);
        head = insertAtHead(head, 7);
        head = insertAtHead(head, 2);
        head = insertAtHead(head, 6);
        head = insertAtHead(head, 3);
        return head;
    }

    private static ListNode palindrome() {
        ListNode head = insertAtHead(null, 1);
        head = insertAtHead(head, 2);
        head = insertAtHead(head, 2);
        head = insertAtHead(head, 1);
        return head;
    }

    /* Section : ------------------------------- [ Specific Utilities ] ------------------------------- */
    public static ListNode insertAtHead(ListNode A, int B) {
        ListNode x = new ListNode(B);
        x.next = A;
        return x;
    }

    public static void printALinkedList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public ListNode reverseALinkedList(ListNode head){
        ListNode prev = null;
        ListNode current = head;

        while (current != null){
            ListNode nextNode = current.next; // step 2
            current.next = prev; // step 1
            prev = current; // move prev forward
            current = nextNode; // continue process
        }
        return prev;
    }

    /* Section : ----------------------------------- [ Problems ] ------------------------------------ */


    public int isPalindromeLinkedList(ListNode A) {
        ListNode temp = A;
        ListNode mid = findMiddle(A);
        ListNode head2 = mid.next;
        mid.next = null;

        ListNode reversedList = reverseALinkedList(head2);

        while (temp != null && reversedList != null) {
            if (temp.val == reversedList.val) {
                temp = temp.next;
                reversedList = reversedList.next;
            } else {
                return 0;
            }
        }
        if (reversedList != null) return 0;
        return 1;
    }

    public ListNode mergeTwoSortedLinkedList(ListNode p1Head, ListNode p2Head) {
        if (p1Head == null) return p2Head;
        if (p2Head == null) return p1Head;
        ListNode head = null;
        ListNode tail = null;
        if (p1Head.val <= p2Head.val) {
            head = p1Head;
            tail = p1Head;
            p1Head = p1Head.next;
        } else {
            head = p2Head;
            tail = p2Head;
            p2Head = p2Head.next;
        }


        while (p1Head != null && p2Head != null) {
            if (p1Head.val <= p2Head.val) {
                tail.next = p1Head;
                p1Head = p1Head.next;
            } else {
                tail.next = p2Head;
                p2Head = p2Head.next;
            }
            tail = tail.next;
        }

        // Attach the remaining part of l1 or l2, if any
        if (p1Head != null) {
            tail.next = p1Head;
        } else {
            tail.next = p2Head;
        }

        return head;
    }

    public ListNode middleNodeOfALinkedList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode findMiddle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode mergeSortLinkedList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = findMiddle(head);
        ListNode head2 = mid.next;
        mid.next = null;

        ListNode left = mergeSortLinkedList(head);
        ListNode right = mergeSortLinkedList(head2);

        return mergeTwoSortedLinkedList(left, right);
    }

    public ListNode addTwoNumbersInReverseOrderAndReturnAsLinkedList(ListNode A, ListNode B) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0;

        while (A != null || B != null) {
            int x = (A != null) ? A.val : 0;
            int y = (B != null) ? B.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            if (A != null) A = A.next;
            if (B != null) B = B.next;
        }

        if (carry > 0) {
            current.next = new ListNode(carry);
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
