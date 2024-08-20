public class Solution {

    public void printPrimaryDiagonal(int[][] matrix) {
        int n = matrix.length;

        System.out.println("Primary Diagonal:");
        for (int i = 0; i < n; i++) {
            System.out.print(matrix[i][i] + " ");
        }
        System.out.println();
    }

    private void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("Matrix:");
        solution.printMatrix(matrix);

        solution.printPrimaryDiagonal(matrix);
    }
}
