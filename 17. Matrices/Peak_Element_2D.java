public class Solution {

    public static void main(String[] args) {
        int[][] matrix1 = {
            {10, 20, 15},
            {21, 30, 14},
            {7, 16, 32}
        };
        int[][] matrix2 = {
            {10, 7},
            {11, 17}
        };

        int[] result1 = findPeak(matrix1);
        int[] result2 = findPeak(matrix2);

        System.out.println(result1[0] + ", " + result1[1]);
        System.out.println(result2[0] + ", " + result2[1]);
    }

    public static int[] findPeak(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (isPeak(matrix, i, j)) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {-1, -1}; 
    }

    private static boolean isPeak(int[][] matrix, int row, int col) {
        int value = matrix[row][col];
        if (row > 0 && matrix[row - 1][col] > value) return false; // check top
        if (row < matrix.length - 1 && matrix[row + 1][col] > value) return false; // check bottom
        if (col > 0 && matrix[row][col - 1] > value) return false; // check left
        if (col < matrix[0].length - 1 && matrix[row][col + 1] > value) return false; // check right
        return true;
    }
}
