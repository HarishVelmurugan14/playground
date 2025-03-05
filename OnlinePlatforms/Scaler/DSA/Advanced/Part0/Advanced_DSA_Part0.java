package OnlinePlatforms.Scaler.DSA.Advanced.Part0;

@SuppressWarnings("DataFlowIssue")
public class Advanced_DSA_Part0 {
    public void implementations() {
        PrefixSum();
    }

    private void PrefixSum() {

        /* ------------------------- Day 03 - DSA: Arrays : Prefix Sum  ----------------------------------------------*/
        d03_Arrays_PrefixSum d03_Arrays_PrefixSum = new d03_Arrays_PrefixSum();

        // Q1, Q2, Q5, Q6, AQ1 : Pick One
        d03_Arrays_PrefixSum.rangeSumQuery(null, null); // Q3
        d03_Arrays_PrefixSum.specialIndices(); // Q4
        d03_Arrays_PrefixSum.inPlacePrefixSum(); // Q7

        d03_Arrays_PrefixSum.equilibriumIndex(); // AQ2
        d03_Arrays_PrefixSum.inPlacePrefixSum(); // AQ3

    }
}
