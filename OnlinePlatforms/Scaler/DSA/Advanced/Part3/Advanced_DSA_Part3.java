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

        //Q1
        //Q2
        //Q3

        //AQ1
        //AQ2
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
