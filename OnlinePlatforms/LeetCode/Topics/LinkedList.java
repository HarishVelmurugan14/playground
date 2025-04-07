package OnlinePlatforms.LeetCode.Topics;

import OnlinePlatforms.Scaler.DSA.Advanced.Part3.d39_LinkedList_SortingAndProblems;

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
}
