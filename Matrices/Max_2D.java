class Print_Hollow_Matrix {
    public static void main(String args[]) {
        int[][] matrix = {
            {2,7,6},
            {9,5,1},
            {4,3,8}
        };
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        int max = matrix[0][0];
        int max2 = 0;
        for(int i=0; i<rows; i++)
        {
            for(int j=0; j<cols; j++)
            {
                if(max < matrix[i][j])
                {
                    max2 = max;
                    max = matrix[i][j];
                }else if(max2 < matrix[i][j] && max > matrix[i][j])
                {
                    max2 = matrix[i][j] ;
                }
            }
        }
        System.out.println(max);
        System.out.println(max2);
    }
}
