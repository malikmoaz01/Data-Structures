public class DFS_Grid {
    
    // right down left up
    public static int[] drows = {0, 1, 0, -1};
    public static int[] dcols = {1, 0, -1, 0};

    void DFS(int[][] grid, int row, int col, boolean[][] visited) {
        int rows = grid.length;
        int cols = grid[0].length;
        if (row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col] || grid[row][col] == 0) {
            return;
        }
        visited[row][col] = true;
        System.out.println("Visited cell is : " + row + " " + col);
        for (int i = 0; i < 4; i++) {
            int r = drows[i] + row;
            int c = dcols[i] + col;
            DFS(grid, r, c, visited);
        }
    }

    public static void main(String[] args) {
        DFS_Grid dfsGrid = new DFS_Grid();
        int[][] grid = {
            {1, 1, 0, 0},
            {0, 1, 0, 0},
            {0, 1, 1, 0},
            {0, 0, 1, 0}
        };
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        dfsGrid.DFS(grid, 0, 0, visited); 
    }
}
