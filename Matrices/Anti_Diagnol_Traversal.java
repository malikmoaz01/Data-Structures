public class Main_Diagnol_Traversal {

    public static void diagonalTraversal(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        for(int i=0; i<cols; i++)
        {
            int a=0;
            int b=i;
            while( a <cols && b >= 0)
            {
                System.out.println(matrix[a][b]);
                a++;
                b--;
            }
        }
        for(int i=1; i<cols; i++)
        {
            int a = i;
            int b = rows - 1;
            while(b >= 0 && a < rows)
            {
                System.out.println(matrix[a][b]);
                a++;
                b--;
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
