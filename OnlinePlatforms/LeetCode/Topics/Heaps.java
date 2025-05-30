package OnlinePlatforms.LeetCode.Topics;

import java.util.ArrayList;
import java.util.Arrays;
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

    public void kThLargestElement(){
        KthLargest kthLargest = new KthLargest(1, null);
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
class KthLargest {
    private PriorityQueue<Integer> minHeap;
    private int k;

    // Constructor to initialize k and the initial stream
    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>(); // Min-heap stores top k largest elements

        for (int num : nums) {
            add(num); // Use add to build the heap respecting size limit
        }
    }

    // Adds a new score and returns the kth largest
    public int add(int val) {
        minHeap.offer(val);

        // If size exceeds k, remove smallest to keep only top k elements
        if (minHeap.size() > k) {
            minHeap.poll();
        }

        // Top of the heap is the kth largest
        return minHeap.peek();
    }
}

