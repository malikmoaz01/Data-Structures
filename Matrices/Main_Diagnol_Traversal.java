public class Main_Diagnol_Traversal {

    public static void diagonalTraversal(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        for(int i=0; i<rows; i++)
        {
            int a = i;
            int b = 0 ;
            while( a >= 0 && b < cols)
            {
                System.out.println(matrix[a][b]);
                a--;
                b++;
            }
        }
        for(int i=1; i<cols; i++)
        {
            int a = rows-1;
            int b = i;
            while( a >= 0 && b < cols)
            {
                    System.out.println(matrix[a][b]);
                    a--;
                    b++;
                
            }
        }
        
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        diagonalTraversal(matrix);
    }
}
