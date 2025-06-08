package OnlinePlatforms.Scaler.DSA.Advanced.Part4;

import Resources.Utilities.PrintHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Harish Velmurugan
 * @last-modified 07-06-2025
 * @since 07-06-2025
 */
public class d55_Graphs_Dijkstra_TopSort {


    private final PrintHelper printHelper = new PrintHelper();

    public static void main(String[] args) {

        // Inputs


        // Call Stack
        d55_Graphs_Dijkstra_TopSort d55GraphsDijkstraTopSort = new d55_Graphs_Dijkstra_TopSort();


    }

    /* Section : ----------------------------------- [ Approaches ] ------------------------------------ */


    public int[] minimumDistanceForEachNodeUsingDijkstra(int A, int[][] B, int C) {
        HashMap<Integer, ArrayList<State>> adj = build(A, B);
        int[] distance = new int[A];
        boolean[] visited = new boolean[A];
        Arrays.fill(distance, -1);
        PriorityQueue<State> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));
        distance[C] = 0;
        minHeap.add(new State(C, 0));

        while (!minHeap.isEmpty()) {
            State current = minHeap.poll();
            int node = current.node;
            int dist = current.weight;
            if (visited[node]) {
                continue;
            }
            visited[node] = true;

            for (State neighbour : adj.getOrDefault(node, new ArrayList<>())) {
                int child = neighbour.node;
                if (visited[child]) {
                    continue;
                }
                int weight = neighbour.weight;
                if (distance[child] == -1 || dist + weight < distance[child]) {
                    distance[child] = dist + weight;
                    minHeap.add(new State(child, dist + weight));
                }
            }
        }

        return distance;
    }

    public HashMap<Integer, ArrayList<State>> build(int A, int[][] B) {
        HashMap<Integer, ArrayList<State>> map = new HashMap<>();
        for (int[] s : B) {
            int u = s[0];
            int v = s[1];
            int w = s[2];
            map.computeIfAbsent(u, x -> new ArrayList<>()).add(new State(v, w));
            map.computeIfAbsent(v, x -> new ArrayList<>()).add(new State(u, w));
        }
        return map;
    }

    public int courseScheduler(int A, int[] B, int[] C) {
        int[] dependencies = new int[A];
        boolean[] visited = new boolean[A];
        int visitedNodes = 0;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < B.length; i++) {
            int u = B[i];
            int v = C[i];
            map.computeIfAbsent(u, x -> new ArrayList<>()).add(v);
            dependencies[v - 1]++;
        }
        Queue<Integer> queue = new LinkedList<>();

        for (int j = 1; j <= A; j++) {
            if (dependencies[j - 1] == 0) {
                queue.add(j);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (visited[node - 1]) {
                continue;
            }
            visited[node - 1] = true;
            visitedNodes++;
            for (int neighbour : map.getOrDefault(node, new ArrayList<>())) {
                dependencies[neighbour - 1]--;
                if (dependencies[neighbour - 1] == 0) {
                    queue.add(neighbour);
                }
            }
        }

        if (visitedNodes != A) {
            return 0;
        }
        return 1;
    }

    public void bruteForce() {
        // Complexity : Time : [  ]
        // Complexity : Space : [  ]


    }

    public void optimal() {
        // Complexity : Time : [  ]
        // Complexity : Space : [  ]


    }

    private void print(String message) {
        printHelper.print(message, "");
    }

    /* Section : ------------------------------- [ Specific Utilities ] ------------------------------- */



    /* Section : ------------------------------- [ Generic Utilities ] ------------------------------- */

    private void definitions() {
        /**/
    }

    /* Section : ------------------------------- [ Definition Resources ] ---------------------------- */

    private void links() {
        /**/
    }

    class State {
        int node;
        int weight;

        State(int n, int w) {
            this.node = n;
            this.weight = w;
        }
    }

    /* Section : --------------------------------------- [ End ] ------------------------------------ */


}
