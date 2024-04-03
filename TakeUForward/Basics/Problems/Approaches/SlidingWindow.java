package TakeUForward.Basics.Problems.Approaches;

import Utilities.PrintHelper;

public class SlidingWindow {

    PrintHelper printHelper = new PrintHelper();

    public static void main(String[] args) {
        SlidingWindow slidingWindow = new SlidingWindow();
        slidingWindow.definitions();
        slidingWindow.execute();
    }

    public void execute() {
        int m = flexibleSlidingWindow(new int[]{5, 6, 3, 1, 4, 2, 1, 1, 1}, 10);
        printHelper.print("Max possible books : ", m);
    }

    public void definitions() {
        /*
         * Constant Window : If the window size to be considered is given
         *                   possible traversal for 0 -> N-1 elements in K window is 0 -> N-K
         *                   Select the first window and calculate
         *                   move window by 1 index subtract previous and add new element
         *
         * Flexible Window : Remember sub array identification 0->n-1 ; 1->n-1; 2->n-1 .. n-1 -> n-1
         *                   traversal should go for O(N) for once 0 -> N-1 (some use case can have less
         *                                which is identified during runtime)
         *                   start = end for all traversal
         *                   keep start same move last until possible. repeat cycle
         * */
    }


    public int flexibleSlidingWindow(int[] arr, int k) {
        int n = arr.length;
        int maxCount = 0;
//        for (int left = 0; left < n - maxCount + 1; left++) { // Current use case
        for (int left = 0; left < n ; left++) {
            int currentCount = 0;
            int currentSum = 0;
            int right = left;
            while (right < n) {
                currentSum = currentSum + arr[right];
                if (currentSum <= k) {
                    currentCount++;
                } else {
                    break;
                }
                right++;
            }
            maxCount = Math.max(maxCount, currentCount);
        }
        return maxCount;
    }

}
