package OnlinePlatforms.Scaler.DSA.Advanced.Part4;

import Resources.Utilities.PrintHelper;
/**
 * @author Harish Velmurugan
 * @since 10-06-2025
 * @last-modified 10-06-2025
 */
public class d56_Graph_InterviewProblems {



    private final PrintHelper printHelper = new PrintHelper();

    public static void main(String[] args) {

        // Inputs


        // Call Stack
        d56_Graph_InterviewProblems d56GraphInterviewProblems = new d56_Graph_InterviewProblems();


    }

    /* Section : ----------------------------------- [ Approaches ] ------------------------------------ */

    int[][] directions = new int[][]{{-1,0}, {1, 0}, {0,-1}, {0,1}, {-1,-1}, {1,1}, {-1, 1}, {1, -1}};
    public int numberOfIslandsPresent(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        boolean[][] visited = new boolean[n][m];
        int islands =0;
        for(int i = 0; i<n; i++ ){
            for(int j = 0; j<m ; j++){
                int current = A[i][j];
                if(current == 1 && !visited[i][j]){
                    islands++;
                    visited[i][j] = true;
                    dfs(i, j, A, n, m, visited);
                }
            }
        }
        return islands;
    }

    public void dfs(int x, int y, int[][] A, int n, int m, boolean[][] visited){
        for(int i =0; i<8; i++){
            int xAxis = x + directions[i][0];
            int yAxis = y + directions[i][1];
            if(isValid(n, m, xAxis, yAxis) && !visited[xAxis][yAxis]){
                visited[xAxis][yAxis] = true;
                if(A[xAxis][yAxis] == 1){
                    dfs(xAxis, yAxis, A, n, m, visited);
                }
            }
        }
    }

    public boolean isValid(int n, int m, int x, int y){
        return x >=0 && y>=0 && x<n && y<m;
    }

    public void bruteForce() {
        // Complexity : Time : [  ]
        // Complexity : Space : [  ]


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
