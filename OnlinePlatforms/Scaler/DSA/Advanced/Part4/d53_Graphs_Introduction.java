package OnlinePlatforms.Scaler.DSA.Advanced.Part4;

import Resources.Utilities.PrintHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Harish Velmurugan
 * @last-modified 20-05-2025
 * @since 20-05-2025
 */
public class d53_Graphs_Introduction {


    public static int InputWithCycleNodes = 4;
    public static int[][] InputWithCycle = {{1, 2}, {2, 3}, {3, 4}, {4, 2}};
    public static int InputWithoutCycleNodes = 4;
    public static int[][] InputWithoutCycle = {{1, 2}, {2, 3}, {3, 4}};
    private final PrintHelper printHelper = new PrintHelper();

    public static void main(String[] args) {

        // Inputs


        // Call Stack
        d53_Graphs_Introduction d53GraphsIntroduction = new d53_Graphs_Introduction();

        System.out.println(d53GraphsIntroduction.cycleDetectionInAGraph(InputWithCycleNodes, InputWithCycle));
        System.out.println(d53GraphsIntroduction.cycleDetectionInAGraph(InputWithoutCycleNodes, InputWithoutCycle));
    }

    /* Section : ----------------------------------- [ Approaches ] ------------------------------------ */

    public List<List<Integer>> buildAdjacencyListForDirectedGraph(int numberOfNodes, int[][] connections) {
        // Complexity : Time : [ O(A) ]
        // Complexity : Space : [ O() ]
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= numberOfNodes; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < connections.length; i++) {
            int u = connections[i][0]; // source
            int v = connections[i][1]; // dest
            adj.get(u).add(v);
        }
        return adj;
    }

    public int cycleDetectionInAGraph(int A, int[][] B) {
//        Time Complexity: O(A + M) — for building the adjacency list and DFS traversal. M : Number of edges
//        Space Complexity: O(A + M) — for the adjacency list, visited arrays, and recursion stack.
//        in General O(V+E)

        List<List<Integer>> adj = buildAdjacencyListForDirectedGraph(A, B);

        // 1 based indexing; so added A+1
        boolean[] visited = new boolean[A + 1];
        boolean[] recStack = new boolean[A + 1];

        for (int i = 0; i <= A; i++) {
            if (!visited[i]) {
                if (dfsForCycleDetection(i, adj, visited, recStack)) {
                    return 1;
                }
            }
        }
        return 0;
    }

    public boolean dfsForCycleDetection(int node, List<List<Integer>> adj, boolean[] visited, boolean[] recStack) {
        visited[node] = true;
        recStack[node] = true;

        for (int neighbour : adj.get(node)) {
            if (!visited[neighbour]) {
                if (dfsForCycleDetection(neighbour, adj, visited, recStack)) {
                    return true;
                }
            } else if (recStack[neighbour]) {
                return true; // parent node of the same stack is called again
            }
        }
        recStack[node] = false;
        return false;
    }

    public void optimal() {
        // Complexity : Time : [  ]
        // Complexity : Space : [  ]


    }

    /* Section : ------------------------------- [ Specific Utilities ] ------------------------------- */



    /* Section : ------------------------------- [ Generic Utilities ] ------------------------------- */

    private void print(String message) {
        printHelper.print(message, "");
    }

    /* Section : ------------------------------- [ Definition Resources ] ---------------------------- */

    private void definitions() {
        /**/
    }

    private void links() {
        /**/
    }

    /* Section : --------------------------------------- [ End ] ------------------------------------ */


}
