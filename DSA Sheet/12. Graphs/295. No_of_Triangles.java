import java.util.*;

class Solution {
    static final int V = 4;

    int countTriangle(int[][] graph, boolean isDirected) {
        int count_Triangle = 0;

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                for (int k = 0; k < V; k++) {
                    if (graph[i][j] != 0 && graph[j][k] != 0 && graph[k][i] != 0) {
                        count_Triangle++;
                    }
                }
            }
        }

        if (isDirected) {
            count_Triangle /= 3;
        } else {
            count_Triangle /= 6;
        }

        return count_Triangle;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] graph = {
            {0, 1, 1, 0},
            {1, 0, 1, 1},
            {1, 1, 0, 1},
            {0, 1, 1, 0}
        };

        int[][] digraph = {
            {0, 0, 1, 0},
            {1, 0, 0, 1},
            {0, 1, 0, 0},
            {0, 0, 1, 0}
        };

        System.out.println("The Number of triangles in undirected graph: " + solution.countTriangle(graph, false));
        System.out.println("The Number of triangles in directed graph: " + solution.countTriangle(digraph, true));
    }
}
