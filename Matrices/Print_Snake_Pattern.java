public class Solution {
    public void printSnakePattern(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        
        int n = matrix.length;
        boolean leftToRight = true;
        
        for (int i = 0; i < n; i++) {
            if (leftToRight) {
                for (int j = 0; j < n; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    System.out.print(matrix[i][j] + " ");
                }
            }
            leftToRight = !leftToRight;
        }
    }
}
