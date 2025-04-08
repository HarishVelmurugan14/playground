package OnlinePlatforms.Scaler.DSA.Advanced.Part3;

@SuppressWarnings({"ExtractMethodRecommender", "DataFlowIssue", "SpellCheckingInspection", "AccessStaticViaInstance"})
public class Advanced_DSA_Part3 {
    public void implementations() {
        Searching();
        BackTracking();
    }

    private void Searching() {
        /* ------------------------- Day 33 - DSA : Combinatorics Basics & Prime Number ------------------------------*/
        d33_Maths_CombinatoricsAndPrimeNumber d33_maths_combinatoricsAndPrimeNumber = new d33_Maths_CombinatoricsAndPrimeNumber();

        d33_maths_combinatoricsAndPrimeNumber.allPrimes(40); // Q2

        /* ------------------------- Day 39 - DSA : Linked List Sorting & Problems ------------------------------*/
        d39_LinkedList_SortingAndProblems d39_linkedList_sortingAndProblems = new d39_LinkedList_SortingAndProblems();

        d39_linkedList_sortingAndProblems.mergeSortLinkedList(null); // Q1 //LC148
        d39_linkedList_sortingAndProblems.mergeTwoSortedLinkedList(null, null); //Q2 // LC21
        d39_linkedList_sortingAndProblems.isPalindromeLinkedList(null); //Q3 //LC234
        d39_linkedList_sortingAndProblems.middleNodeOfALinkedList(null); //Q4 //LC876

        //AQ1
        d39_linkedList_sortingAndProblems.addTwoNumbersInReverseOrderAndReturnAsLinkedList(null, null); //AQ2 //LC02
        //AQ3

    }

    private void BackTracking() {
        d36_Backtracking d36_backtracking = new d36_Backtracking();
        d36_backtracking.generateParenthesis(3); // LC 22
        d36_backtracking.generateSubsets(new int[]{1, 2, 3}); // LC 78
        d36_backtracking.generateSubSequence("", "abc");
        d36_backtracking.generatePermutations(new int[]{1, 2, 3}); // LC 46
    }
}
