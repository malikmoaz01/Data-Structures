import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static int[] drows = {0, 1, 0, -1};
    public static int[] dcols = {1, 0, -1, 0};
    
    public int[][] floodFill(int[][] grid, int startrow, int startcol, int color) {
        int rows = grid.length;
        int cols = grid[0].length;
        int startColor = grid[startrow][startcol];
        
        if (startColor == color) {
            return grid;
        }
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startrow, startcol});
        grid[startrow][startcol] = color; 

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int row = current[0];
            int col = current[1];

            for (int i = 0; i < 4; i++) {
                int r = drows[i] + row;
                int c = dcols[i] + col;
                
                if (r >= 0 && r < rows && c >= 0 && c < cols && grid[r][c] == startColor) {
                    q.add(new int[]{r, c});
                    grid[r][c] = color; 
                }
            }
        }
        return grid;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[][] image = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };
        int sr = 1; 
        int sc = 1; 
        int newColor = 2;
        
        int[][] result = solution.floodFill(image, sr, sc, newColor);
        for (int[] row : result) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
    }
}
