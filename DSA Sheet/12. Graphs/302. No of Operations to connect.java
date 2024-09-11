import java.util.ArrayList;

class Solution {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }

        ArrayList<Edge>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] conn : connections) {
            int u = conn[0];
            int v = conn[1];
            graph[u].add(new Edge(v));
            graph[v].add(new Edge(u));
        }

        boolean[] visited = new boolean[n];
        int components = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                DFS(graph, i, visited);
                components++;
            }
        }

        return components - 1;
    }

    private void DFS(ArrayList<Edge> graph[], int current, boolean visited[]) {
        if (visited[current]) {
            return;
        }
        visited[current] = true;
        for (Edge e : graph[current]) {
            DFS(graph, e.dest, visited);
        }
    }

    private static class Edge {
        int dest;

        Edge(int dest) {
            this.dest = dest;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int n1 = 4;
        int[][] connections1 = { {0, 1}, {0, 2}, {1, 2} };
        System.out.println("Test Case 1: " + solution.makeConnected(n1, connections1));

        int n2 = 6;
        int[][] connections2 = { {0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3} };
        System.out.println("Test Case 2: " + solution.makeConnected(n2, connections2));

        int n3 = 6;
        int[][] connections3 = { {0, 1}, {0, 2}, {0, 3}, {1, 2} };
        System.out.println("Test Case 3: " + solution.makeConnected(n3, connections3));
    }
}
