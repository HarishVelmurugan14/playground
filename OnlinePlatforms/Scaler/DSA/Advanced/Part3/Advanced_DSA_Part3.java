package OnlinePlatforms.Scaler.DSA.Advanced.Part3;

@SuppressWarnings({"ExtractMethodRecommender", "DataFlowIssue", "SpellCheckingInspection", "AccessStaticViaInstance"})
public class Advanced_DSA_Part3 {
    public void implementations() {
        Searching();
    }

    private void Searching() {
        /* ------------------------- Day 33 - DSA : Combinatorics Basics & Prime Number ------------------------------*/
        d33_Maths_CombinatoricsAndPrimeNumber d33_maths_combinatoricsAndPrimeNumber = new d33_Maths_CombinatoricsAndPrimeNumber();

        d33_maths_combinatoricsAndPrimeNumber.allPrimes(40); // Q2
    }

    private void BackTracking() {
        d36_Backtracking d36_backtracking = new d36_Backtracking();
        d36_backtracking.generateParenthesis(3); // LC 22
        d36_backtracking.generateSubsets(new int[]{1, 2, 3}); // LC 78
        d36_backtracking.generatePermutations(new int[]{1, 2, 3}); // LC 46
    }
}
