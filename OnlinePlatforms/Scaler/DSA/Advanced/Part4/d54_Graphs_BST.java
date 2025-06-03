package OnlinePlatforms.Scaler.DSA.Advanced.Part4;

import Resources.Utilities.PrintHelper;

import java.util.LinkedList;
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

    /* Section : --------------------------------------- [ End ] ------------------------------------ */


}
