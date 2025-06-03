package OnlinePlatforms.LeetCode.Topics;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Graphs {
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

    static class Edge {
        int point;
        int cost;
        Edge(int point, int cost) {
            this.point = point;
            this.cost = cost;
        }
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] visited = new boolean[n];
        PriorityQueue<Edge> minHeap = new PriorityQueue<>(Comparator.comparingInt(e -> e.cost));

        int totalCost = 0;
        int nodesVisited = 0;

        // Start from point 0 with cost 0
        minHeap.add(new Edge(0, 0));

        while (!minHeap.isEmpty() && nodesVisited < n) {
            Edge current = minHeap.poll();
            int currPoint = current.point;
            int currCost = current.cost;

            if (visited[currPoint]) continue;

            visited[currPoint] = true;
            totalCost += currCost;
            nodesVisited++;

            // Add edges from current point to all unvisited points
            for (int nextPoint = 0; nextPoint < n; nextPoint++) {
                if (!visited[nextPoint]) {
                    int dist = manhattanDistance(points[currPoint], points[nextPoint]);
                    minHeap.add(new Edge(nextPoint, dist));
                }
            }
        }

        return totalCost;
    }

    private int manhattanDistance(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }

    static class Bridge {
        int end, cost;

        Bridge(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
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


}
class Position {
    int row, col;

    Position(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
