class Print_Hollow_Matrix {
    public static void main(String args[]) {
        int[][] matrix = {
            {2,7,6},
            {9,5,1},
            {4,3,8}
        };
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        int rowsum = 0;
        int colsum = 0;
        int mainsum = 0;
        int antisum = 0;
        // row sum
        for(int j = 0; j < matrix[0].length; j++) {
            rowsum += matrix[0][j];
        }
        // col sum
        for(int j = 0; j < matrix[0].length; j++) {
            colsum += matrix[j][0];
        }
        // Main diagnol sum 
        for(int i=0; i<rows; i++)
        {
                mainsum += matrix[i][i];
        }
        // Anti dignol sum 
        for(int i=0; i<rows; i++)
        {
            antisum += matrix[i][cols-1-i];
        }
        // System.out.println(rowsum);
        // System.out.println(colsum);
        // System.out.println(mainsum);
        // System.out.println(antisum);
        if(rowsum == colsum && colsum == mainsum && mainsum ==antisum)
        {
            System.out.println("Matrix is Magic\n");
        }else{
            System.out.println("Matrix is not Magic\n");
        }
    }
}
