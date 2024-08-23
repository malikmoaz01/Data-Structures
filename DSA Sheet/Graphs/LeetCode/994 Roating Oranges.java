import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int freshCount = 0;

        // Pehle sabhi rotten oranges ko queue me daalenge aur fresh oranges ko count karenge.
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        if (freshCount == 0) {
            return 0; 
        }

        int minutes = 0;
        int[] drows = {0, 1, 0, -1};
        int[] dcols = {1, 0, -1, 0};

        while (!q.isEmpty()) {
            int size = q.size();
            boolean rotten = false;

            for (int i = 0; i < size; i++) {
                int[] current = q.poll();
                int row = current[0];
                int col = current[1];

                for (int j = 0; j < 4; j++) {
                    int r = row + drows[j];
                    int c = col + dcols[j];

                    if (r >= 0 && r < rows && c >= 0 && c < cols && grid[r][c] == 1) {
                        grid[r][c] = 2;
                        q.add(new int[]{r, c});
                        freshCount--;
                        rotten = true;
                    }
                }
            }

            if (rotten) {
                minutes++;
            }
        }

        return freshCount == 0 ? minutes : -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[][] grid = {
            {2 , 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };
        
        int result = solution.orangesRotting(grid);
        System.out.println("Time taken: " + result + " minutes");
    }
}
