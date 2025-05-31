package OnlinePlatforms.LeetCode.Topics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Heaps {
    public void medianRunningArray() {
        MedianFinder m = new MedianFinder();
        m.addNum(1);
        System.out.println(m.findMedian());
        m.addNum(2);
        System.out.println(m.findMedian());
        m.addNum(5);
        System.out.println(m.findMedian());
        m.addNum(4);
        System.out.println(m.findMedian());
        m.addNum(3);
        System.out.println(m.findMedian());
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
}

class MedianFinder {
    PriorityQueue<Integer> leftMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> rightMinHeap = new PriorityQueue<>();

    public MedianFinder() {
    }

    public void addNum(int num) {
        int n = leftMaxHeap.size() + rightMinHeap.size();
        if (n == 0) {
            leftMaxHeap.add(num);
            return;
        }

        int maxOfLeftHalf = leftMaxHeap.peek();
        if (maxOfLeftHalf > num) {
            leftMaxHeap.add(num);
        } else {
            rightMinHeap.add(num);
        }

        if (leftMaxHeap.size() - rightMinHeap.size() > 1) {
            rightMinHeap.add(leftMaxHeap.poll());
        } else if (rightMinHeap.size() > leftMaxHeap.size()) {
            leftMaxHeap.add(rightMinHeap.poll());
        }
    }

    public double findMedian() {
        int n = leftMaxHeap.size() + rightMinHeap.size();
        if (n % 2 != 0) {
            return leftMaxHeap.peek();
        }
        return ((double) leftMaxHeap.peek() + (double) rightMinHeap.peek()) / 2.0;
    }
}
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
