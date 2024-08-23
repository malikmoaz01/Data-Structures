import java.util.LinkedList;
import java.util.Queue;

public class BFS_Grid {
    // right down left up
    public static int[] drows = {0, 1, 0, -1};
    public static int[] dcols = {1, 0, -1, 0};

    void BFS(int[][] grid, int startrow, int startcol) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];

        q.add(new int[]{startrow, startcol});
        visited[startrow][startcol] = true;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int row = current[0];
            int col = current[1];
            System.out.println("Visited cell is : " + row + " " + col);

            for (int i = 0; i < 4; i++) {
                int r = drows[i] + row;
                int c = dcols[i] + col;

                if (r >= 0 && r < rows && c >= 0 && c < cols && !visited[r][c] && grid[r][c] == 1) {
                    q.add(new int[]{r, c});
                    visited[r][c] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        BFS_Grid bfsGrid = new BFS_Grid();
        int[][] grid = {
            {1, 1, 0, 0},
            {0, 1, 0, 0},
            {0, 1, 1, 0},
            {0, 0, 1, 0}
        };
        bfsGrid.BFS(grid, 0, 0); 
    }
}
