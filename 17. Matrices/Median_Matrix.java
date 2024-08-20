import java.util.Arrays;

public class MatrixMedian {

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 3, 5},
            {2, 6, 9},
            {3, 6, 9}
        };
        System.out.println("Median: " + findMedian(matrix));
    }

    public static double findMedian(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] flatArray = new int[rows * cols];
        int index = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                flatArray[index++] = matrix[i][j];
            }
        }

        Arrays.sort(flatArray);

        int mid = flatArray.length / 2;
        if (flatArray.length % 2 == 1) {
            return flatArray[mid];
        } else {
            return (flatArray[mid - 1] + flatArray[mid]) / 2.0;
        }
    }
}
