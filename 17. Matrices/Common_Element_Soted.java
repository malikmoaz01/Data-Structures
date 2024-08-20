import java.util.HashMap;
import java.util.Map;

public class Solution {

    public Integer findCommonElement(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return null;
        }
        
        int numRows = matrix.length;
        int numCols = matrix[0].length;

        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Initialize the map with the first row's elements
        for (int num : matrix[0]) {
            map.put(num, 1);
        }

        // Process each subsequent row
        for (int i = 1; i < numRows; i++) {
            HashMap<Integer, Integer> rowMap = new HashMap<>();
            for (int num : matrix[i]) {
                if (map.containsKey(num)) {
                    rowMap.put(num, rowMap.getOrDefault(num, 0) + 1);
                }
            }
            map = rowMap;
        }

        // Find an element that appears in all rows
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == numRows) {
                return entry.getKey();
            }
        }

        return null; // No common element found
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] matrix = {
            {1, 2, 3, 4},
            {2, 3, 5, 6},
            {2, 3, 7, 8},
            {2, 9, 10, 11}
        };

        Integer commonElement = solution.findCommonElement(matrix);
        if (commonElement != null) {
            System.out.println("Common element in all rows: " + commonElement);
        } else {
            System.out.println("No common element found in all rows.");
        }
    }
}
