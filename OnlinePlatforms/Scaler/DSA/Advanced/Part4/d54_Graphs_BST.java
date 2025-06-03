package OnlinePlatforms.Scaler.DSA.Advanced.Part4;

import Resources.Utilities.PrintHelper;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Harish Velmurugan
 * @last-modified 03-06-2025
 * @since 03-06-2025
 */
public class d54_Graphs_BST {

    private final PrintHelper printHelper = new PrintHelper();

    public static void main(String[] args) {

        // Inputs


        // Call Stack
        d54_Graphs_BST d54GraphsBst = new d54_Graphs_BST();


    }

    public int connectingBridges(int islands, int[][] bridges) {
        HashMap<Integer, ArrayList<Bridge>> adjacencyList = buildAdj(bridges);
        PriorityQueue<Bridge> minHeap = new PriorityQueue<>(Comparator.comparingInt(x -> x.cost));
        minHeap.add(new Bridge(1, 0));
        boolean[] visited = new boolean[islands + 1];
        int totalCost = 0;
        int islandVisitedSoFar = 0;

        while (!minHeap.isEmpty()) {
            Bridge current = minHeap.poll();
            int node = current.end;
            int cost = current.cost;
            if (visited[node]) {
                continue;
            }
            visited[node] = true;
            islandVisitedSoFar++;
            totalCost += cost;
            for (Bridge neighbour : adjacencyList.get(node)) {
                if (!visited[neighbour.end]) {
                    minHeap.add(new Bridge(neighbour.end, neighbour.cost)); // create fresh bridge
                }
            }
        }
        return islandVisitedSoFar == islands ? totalCost : -1;
    }

    public HashMap<Integer, ArrayList<Bridge>> buildAdj(int[][] bridges) {
        HashMap<Integer, ArrayList<Bridge>> map = new HashMap<>();
        for (int[] bridge : bridges) {
            int source = bridge[0];
            int dest = bridge[1];
            int cost = bridge[2];
            map.computeIfAbsent(source, k -> new ArrayList<>()).add(new Bridge(dest, cost));
            map.computeIfAbsent(dest, k -> new ArrayList<>()).add(new Bridge(source, cost));
        }
        return map;
    }

    public int rottenOranges(int[][] oranges) {
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<Position> queue = new LinkedList<>();
        int m = oranges.length;
        int n = oranges[0].length;
        int freshOranges = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (oranges[i][j] == 2) {
                    queue.add(new Position(i, j));
                } else if (oranges[i][j] == 1) {
                    freshOranges++;
                }
            }
        }
        int minutes = 0;
        if (freshOranges == 0) {
            return minutes;
        }

        while (!queue.isEmpty() && freshOranges > 0) {
            int currentLevelSize = queue.size();
            for (int i = 0; i < currentLevelSize; i++) {
                Position cell = queue.poll();
                for (int[] direction : directions) {
                    int row = cell.row + direction[0];
                    int col = cell.col + direction[1];
                    if (isValidCell(row, col, m, n) && oranges[row][col] == 1) {
                        oranges[row][col] = 2;
                        freshOranges--;
                        queue.add(new Position(row, col));
                    }
                }
            }
            minutes++;
        }
        return freshOranges == 0 ? minutes : -1;
    }

    public boolean isValidCell(int x, int y, int m, int n) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }

    /* Section : ----------------------------------- [ Approaches ] ------------------------------------ */

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

    static class Position {
        int row, col;

        Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static class Bridge {
        int end, cost;

        Bridge(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }

    /* Section : --------------------------------------- [ End ] ------------------------------------ */


}
