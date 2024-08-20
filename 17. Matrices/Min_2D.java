class Print_Hollow_Matrix {
    public static void main(String args[]) {
        int[][] matrix = {
            {2, 7, 6},
            {9, 5, 1},
            {4, 3, 8}
        };
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        int min = matrix[0][0];
        int min2 = Integer.MAX_VALUE; 
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] < min) {
                    min2 = min; 
                    min = matrix[i][j]; 
                } else if (matrix[i][j] < min2 && matrix[i][j] > min) {
                    min2 = matrix[i][j]; 
                }
            }
        }
        
        System.out.println("Minimum element: " + min);
        System.out.println("Second minimum element: " + (min2 == Integer.MAX_VALUE ? "Not found" : min2));
    }
}
