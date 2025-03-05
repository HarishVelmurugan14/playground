package OnlinePlatforms.Scaler.DSA.Advanced.Part2;

import Resources.Utilities.PrintHelper;

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

        d27_Stack2_NearestSmallGreatElements.largestRectangleInAHistogram(new int[]{2, 1, 5, 6, 2, 3});
    }

    /* Section : ----------------------------------- [ Problems ] ------------------------------------ */


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

    public void optimal() {
        // Complexity : Time : [  ]
        // Complexity : Space : [  ]


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
