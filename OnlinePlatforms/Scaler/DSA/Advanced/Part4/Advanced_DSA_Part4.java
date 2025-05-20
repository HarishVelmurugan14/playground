package OnlinePlatforms.Scaler.DSA.Advanced.Part4;

@SuppressWarnings("AccessStaticViaInstance")
public class Advanced_DSA_Part4 {
    public void implementations() {
        Graphs();
    }

    private void Graphs() {
        /* ------------------------- Day 53 - DSA : Graphs 1 | Intro & Cycle Detetection ------------------------------*/
        d53_Graphs_Introduction d53GraphsIntroduction = new d53_Graphs_Introduction();

        d53GraphsIntroduction.cycleDetectionInAGraph(d53GraphsIntroduction.InputWithCycleNodes, d53GraphsIntroduction.InputWithCycle); //Q1
        d53GraphsIntroduction.pathInADirectedGraph(0, null); //LC 1971 //Q2

        d53GraphsIntroduction.firstDepthFirstSearch(new int[]{1, 1, 2}, 2, 1); //AQ1
        d53GraphsIntroduction.maximumDepth(5, new int[]{1, 4, 3, 1}, new int[]{5, 2, 4, 4}, new int[]{7, 38, 27, 37, 1}, new int[]{1, 1, 2}, new int[]{32, 18, 26}); //AQ2

        /* ------------------------- Day 38 - DSA : Linked List Sorting & Problems ------------------------------*/


    }
}
