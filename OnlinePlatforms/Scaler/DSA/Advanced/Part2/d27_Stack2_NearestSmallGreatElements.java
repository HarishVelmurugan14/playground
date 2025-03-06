package OnlinePlatforms.Scaler.DSA.Advanced.Part2;

import Resources.Utilities.PrintHelper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * @author Harish Velmurugan
 * @last-modified 05-03-2025
 * @since 05-03-2025
 */
@SuppressWarnings("UnusedReturnValue")
public class d27_Stack2_NearestSmallGreatElements {


    private final PrintHelper printHelper = new PrintHelper();

    public static void main(String[] args) {

        // Inputs


        // Call Stack
        d27_Stack2_NearestSmallGreatElements d27_Stack2_NearestSmallGreatElements = new d27_Stack2_NearestSmallGreatElements();

        int[] A = {8, 2, 4, 9, 7, 5, 3, 10};
        d27_Stack2_NearestSmallGreatElements.print("", A);
        d27_Stack2_NearestSmallGreatElements.nearestSmallerElementsToTheLeft(A);
        d27_Stack2_NearestSmallGreatElements.nearestGreaterElementsToTheRight(A);
        d27_Stack2_NearestSmallGreatElements.nearestSmallerElementsToTheRight(A);
        d27_Stack2_NearestSmallGreatElements.nearestGreaterElementsToTheRight(A);

        d27_Stack2_NearestSmallGreatElements.largestRectangleInAHistogram(new int[]{2, 1, 5, 6, 2, 3}); // Q1
        d27_Stack2_NearestSmallGreatElements.prevSmallerValuesInAnArray(new int[]{4, 5, 2, 10, 8}); // Q2
        d27_Stack2_NearestSmallGreatElements.identifyMaximumMinusMinimumInAllPossibleSubArrays(new int[]{4, 7, 3, 8}); // Q3

        d27_Stack2_NearestSmallGreatElements.nextGreaterValues(new int[]{4, 5, 2, 10, 8}); // AQ2

        d27_Stack2_NearestSmallGreatElements.nextGreaterElementForSubsetQueriesInADistinctArrays
                (new int[]{4, 1, 2}, new int[]{1, 3, 4, 2}); // LC496
    }

    /* Section : ----------------------------------- [ Problems ] ------------------------------------ */

    public int identifyMaximumMinusMinimumInAllPossibleSubArrays(int[] A) {
        int MOD = 1_000_000_007;
        int N = A.length;

        int[] prevSmaller = new int[N];
        int[] nextSmaller = new int[N];
        int[] prevGreater = new int[N];
        int[] nextGreater = new int[N];

        Stack<Integer> stack = new Stack<>();

        // Calculate Previous Smaller Elements
        Arrays.fill(prevSmaller, -1);
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && A[stack.peek()] >= A[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) prevSmaller[i] = stack.peek();
            stack.push(i);
        }

        stack.clear();

        // Calculate Next Smaller Elements
        Arrays.fill(nextSmaller, N);
        for (int i = N - 1; i >= 0; i--) {
            while (!stack.isEmpty() && A[stack.peek()] > A[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) nextSmaller[i] = stack.peek();
            stack.push(i);
        }

        stack.clear();

        // Calculate Previous Greater Elements
        Arrays.fill(prevGreater, -1);
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && A[stack.peek()] <= A[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) prevGreater[i] = stack.peek();
            stack.push(i);
        }

        stack.clear();

        // Calculate Next Greater Elements
        Arrays.fill(nextGreater, N);
        for (int i = N - 1; i >= 0; i--) {
            while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) nextGreater[i] = stack.peek();
            stack.push(i);
        }

        // Compute final sum
        long sum = 0;
        for (int i = 0; i < N; i++) {
            long maxCount = (long) (i - prevGreater[i]) * (nextGreater[i] - i);
            long minCount = (long) (i - prevSmaller[i]) * (nextSmaller[i] - i);
            long contribution = (maxCount - minCount) * A[i];

            sum = (sum + contribution + MOD) % MOD;
        }

        return (int) sum;
    }

    public int largestRectangleInAHistogram(int[] A) {
        /*
        Given an array of integers A.
        A represents a histogram i.e A[i] denotes the height of the ith histogram's bar. Width of each bar is 1.
        Find the area of the largest rectangle formed by the histogram.
        */
        int N = A.length;
        int maxArea = -1;
        int[] prevSmallerElements = nearestSmallerElementsToTheLeft(A);
        int[] nextSmallerElements = nearestSmallerElementsToTheRight(A);
        for (int i = 0; i < N; i++) {
            int height = A[i];
            int width = nextSmallerElements[i] - prevSmallerElements[i] - 1;
            int area = height * width;
            maxArea = Math.max(area, maxArea);
        }
        System.out.println(maxArea);
        return maxArea;
    }

    public int[] prevSmallerValuesInAnArray(int[] A) {
        /* QUESTION :
        Given an array A, find the nearest smaller element G[i] for every element A[i] in the array such that the
        element has an index smaller than i. More formally,
        G[i] for an element A[i] = an element A[j] such that
        j is maximum possible AND
        j < i AND
        A[j] < A[i]
        Elements for which no smaller element exist, consider the next smaller element as -1.
         */
        int N = A.length;
        int[] res = new int[N];
        Stack<Integer> stack = new Stack<>();
        stack.push(A[0]);
        res[0] = -1;

        for (int i = 1; i < N; i++) {
            while (stack.peek() >= A[i]) {
                stack.pop();
                if (stack.isEmpty()) {
                    res[i] = -1;
                    break;
                }
            }
            if (!stack.isEmpty()) {
                res[i] = stack.peek();
            }
            stack.push(A[i]);
        }
        print("", res);
        return res;
    }

    public int[] nextGreaterElementForSubsetQueriesInADistinctArrays(int[] nums1, int[] nums2) {
        int N = nums2.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(nums2[N - 1]);
        map.put(nums2[N - 1], -1);

        for (int i = N - 2; i >= 0; i--) {
            while (stack.peek() <= nums2[i]) {
                stack.pop();
                if (stack.isEmpty()) {
                    map.put(nums2[i], -1);
                    break;
                }
            }
            if (!stack.isEmpty()) {
                map.put(nums2[i], stack.peek());
            }
            stack.push(nums2[i]);
        }
        int M = nums1.length;
        int[] res = new int[M];

        for (int i = 0; i < M; i++) {
            res[i] = map.get(nums1[i]);
        }

        print("", res);
        return res;
    }

    public int[] nextGreaterValues(int[] A) {
        int N = A.length;
        int[] res = new int[N];
        Stack<Integer> stack = new Stack<>();
        stack.push(A[N - 1]);
        res[N - 1] = -1;

        for (int i = N - 2; i >= 0; i--) {
            while (stack.peek() <= A[i]) {
                stack.pop();
                if (stack.isEmpty()) {
                    res[i] = -1;
                    break;
                }
            }
            if (!stack.isEmpty()) {
                res[i] = stack.peek();
            }
            stack.push(A[i]);
        }
        print("", res);
        return res;
    }

    /* Section : ------------------------------- [ Specific Utilities ] ------------------------------- */

    public int[] nearestSmallerElementsToTheLeft(int[] A) {
        int N = A.length;
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[N];
        res[0] = -1;
        stack.push(0);

        for (int i = 1; i < N; i++) {
            int currentConsideration = A[i];
            int prevElement = A[stack.peek()];
            while (prevElement >= currentConsideration) {
                stack.pop();
                if (!stack.isEmpty()) {
                    prevElement = A[stack.peek()];
                } else {
                    break;
                }
            }
            if (stack.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = stack.peek();
            }
            stack.push(i);
        }

        print("", res);
        return res;
    }

    public int[] nearestSmallerElementsToTheRight(int[] A) {
        Stack<Integer> stack = new Stack<>();
        int N = A.length;
        int[] res = new int[N];
        for (int i = N - 1; i >= 0; i--) {
            while (!stack.isEmpty() && A[stack.peek()] >= A[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? N : stack.peek();
            stack.push(i);
        }
        return res;
    }

    public int[] nearestGreaterElementsToTheRight(int[] A) {
        int N = A.length;
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[N];
        res[N - 1] = N;
        stack.push(N - 1);

        for (int i = N - 2; i >= 0; i--) {
            int currentConsideration = A[i];
            int prevElement = A[stack.peek()];
            while (prevElement <= currentConsideration) {
                stack.pop();
                if (!stack.isEmpty()) {
                    prevElement = A[stack.peek()];
                } else {
                    break;
                }
            }
            if (stack.isEmpty()) {
                res[i] = N;
            } else {
                res[i] = stack.peek();
            }
            stack.push(i);
        }

        print("", res);
        return res;
    }

    /* Section : ------------------------------- [ Generic Utilities ] ------------------------------- */

    private void print(String message, int[] a) {
        printHelper.print(message, a);
    }

    /* Section : ------------------------------- [ Definition Resources ] ---------------------------- */

    private void definitions() {
        /*
         * Notebook_06012025 : Page No - 134
         * */
    }

    private void links() {
        /*
         * academy/mentee-dashboard/class/345267/session?joinSession=1
         * */
    }

    /* Section : --------------------------------------- [ End ] ------------------------------------ */


}
