public class RotateMatrix {

    public static void rotateClockwise(int[][] matrix) {
        int n = matrix.length;
        
        
        for (int j=0; j<n/2; j++)
        {
        {
            int first = j;
            int last = n - 1 - j;
            int temp = matrix[first][first];
            
            // top to left
            for(int i=first; i<last; i++)
            {
                matrix[first][i] = matrix[first][i+1]; 
            }
            // Now top to bottom 
            for(int i=first; i<last; i++)
            {
                matrix[i][last] = matrix[i+1][last];
            }
            // bottom to right side ;
            for(int i=last; i>first; i--)
            {
                matrix[last][i] = matrix[last][i-1];
            }
            // bottom to top
            for(int i=last; i>first; i--)
            {
                matrix[i][first] = matrix[i-1][first];
            }
            matrix[first+1][first] = matrix[first][first];


        }
    }
}
    public static void printMatrix(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        rotateClockwise(matrix1);
        printMatrix(matrix1);

        int[][] matrix2 = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };

        rotateClockwise(matrix2);
        printMatrix(matrix2);
    }
}
