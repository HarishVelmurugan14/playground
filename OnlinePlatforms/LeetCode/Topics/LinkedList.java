package OnlinePlatforms.LeetCode.Topics;

public class LinkedList {

    public boolean isPalindrome(ListNode head) {
        ListNode temp = head;
        ListNode mid = findMiddle(head);
        ListNode head2 = mid.next;
        mid.next = null;

        ListNode reversedList = reverseALinkedList(head2);

        while (temp != null && reversedList != null) {
            if (temp.val == reversedList.val) {
                temp = temp.next;
                reversedList = reversedList.next;
            } else {
                return false;
            }
        }
        if (reversedList != null) return false;
        return true;

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

    static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
