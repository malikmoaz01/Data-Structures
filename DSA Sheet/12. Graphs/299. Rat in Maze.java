import java.util.ArrayList;
import java.util.List;

public class RatInMaze {
    // Direction arrays for 'D', 'L', 'R', 'U'
    public static int[] drow = {1, 0, 0, -1};
    public static int[] dcol = {0, -1, 1, 0};
    public static char[] dir = {'D', 'L', 'R', 'U'};

    public static void findPaths(int[][] mat, int row, int col, int n, String path, List<String> paths, boolean[][] visited) {
        if (row == n - 1 && col == n - 1) {
            paths.add(path);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nextRow = row + drow[i];
            int nextCol = col + dcol[i];

            if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < n && mat[nextRow][nextCol] == 1 && !visited[nextRow][nextCol]) {
                visited[row][col] = true;
                findPaths(mat, nextRow, nextCol, n, path + dir[i], paths, visited);
                visited[row][col] = false;  // Backtrack
            }
        }
    }

    public static List<String> solveMaze(int[][] mat) {
        List<String> paths = new ArrayList<>();
        int n = mat.length;

        if (mat[0][0] == 0 || mat[n - 1][n - 1] == 0) {
            return paths; // No paths possible
        }

        boolean[][] visited = new boolean[n][n];
        findPaths(mat, 0, 0, n, "", paths, visited);

        return paths;
    }

    public static void main(String[] args) {
        int[][] mat = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {1, 1, 0, 0},
            {0, 1, 1, 1}
        };

        List<String> result = solveMaze(mat);
        if (result.isEmpty()) {
            System.out.println("-1");
        } else {
            for (String path : result) {
                System.out.println(path);
            }
        }
    }
}
