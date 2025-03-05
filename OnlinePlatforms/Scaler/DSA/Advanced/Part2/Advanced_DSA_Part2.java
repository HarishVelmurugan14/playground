package OnlinePlatforms.Scaler.DSA.Advanced.Part2;

@SuppressWarnings({"ExtractMethodRecommender", "DataFlowIssue", "SpellCheckingInspection"})
public class Advanced_DSA_Part2 {
    public void implementations() {
        Searching();
        LinkedList();
        Stacks();
    }

    private void Searching() {
        /* ------------------------- Day 21 - DSA : Searching 1: Binary Search on Array ------------------------------*/
        d21_Searching_BinarySearchOnArray d21SearchingBinarySearchOnArray = new d21_Searching_BinarySearchOnArray();

        d21SearchingBinarySearchOnArray.searchForStartAndEndIndexOfAnElementInAnArray(); // Q1
        d21SearchingBinarySearchOnArray.positionWhereTargetIsPresentOrShouldBeInserted(); // Q2
        d21SearchingBinarySearchOnArray.singleElementInASortedArray(); // Q3
        d21SearchingBinarySearchOnArray.peakElement(); // Q4

        d21SearchingBinarySearchOnArray.searhAMatrix(); // AQ1
        // AQ2
        d21SearchingBinarySearchOnArray.maximumHeightOfAStaircase(20); // AQ3


        /* ------------------------- Day 22 - DSA: Searching 2: Binary Search Problems ------------------------------*/
        d22_Searching2_BinarySearchProblems d22Searching2BinarySearchProblems = new d22_Searching2_BinarySearchProblems();

        d22Searching2BinarySearchProblems.squareRootOfANumber(4); // Q1
        d22Searching2BinarySearchProblems.rotatedSortedArraySearch(); // Q2
        d22Searching2BinarySearchProblems.findMedianInSortedArrays(new int[]{}, new int[]{}); // Q3

        // AQ1
        // AQ2
        // AQ3
        // AQ4

        d22Searching2BinarySearchProblems.rotationFactor(new int[]{});

        /* ------------------------- Day 23 - DSA: Searching 3: Binary Search on Answer ------------------------------*/

        d23_Searching_BinarySearchOnAnswerSpace d23SearchingBinarySearchOnAnswerSpace = new d23_Searching_BinarySearchOnAnswerSpace();

        d23SearchingBinarySearchOnAnswerSpace.paintersPartitionMinimumTimeToPaint(3, 2, null); //Q1
        d23SearchingBinarySearchOnAnswerSpace.aggressiveCowsLargestMinDistance(null, 4); //Q2

        // AQ1
        // AQ2
    }

    private void LinkedList() {
        /* ------------------------- Day 24 - DSA: Classes, Objects & Linked Lists -----------------------------------*/
        /* ------------------------- Day 25 - DSA: Linked List Problems ----------------------------------------------*/
    }

    private void Stacks() {
        /* ------------------------- Day 26 - DSA: Stacks 1 : Implementations & Basic Problems -----------------------*/

        d26_Stacks1_BasicProblems d26_Stacks1_BasicProblems = new d26_Stacks1_BasicProblems();

        d26_Stacks1_BasicProblems.postFixExpression(null); // Q1
        d26_Stacks1_BasicProblems.balancedParenthesis("{()()()}({"); // Q2
        d26_Stacks1_BasicProblems.doubleCharacterTrouble("abccbc"); // Q3
        d26_Stacks1_BasicProblems.passingGameOfBall(10, 48, new int[]{4, 0, 30, 0, 41, 28, 50, 2, 47, 39}); // Q4

        // AQ1
        // AQ2
        // AQ3
        // AQ4

        d27_Stack2_NearestSmallGreatElements d27_Stack2_NearestSmallGreatElements = new d27_Stack2_NearestSmallGreatElements();

        d27_Stack2_NearestSmallGreatElements.largestRectangleInAHistogram(null); // Q1 // LC84
    }
}
