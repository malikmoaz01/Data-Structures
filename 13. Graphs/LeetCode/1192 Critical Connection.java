import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<Edge> graph[] = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (List<Integer> connection : connections) {
            int u = connection.get(0);
            int v = connection.get(1);
            graph[u].add(new Edge(v));
            graph[v].add(new Edge(u));
        }
        
        List<List<Integer>> bridges = new ArrayList<>();
        int dt[] = new int[n];
        int low[] = new int[n];
        boolean visited[] = new boolean[n];
        Arrays.fill(dt, -1);
        Arrays.fill(low, -1);
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(graph, i, -1, visited, dt, low, 0, bridges);
            }
        }
        
        return bridges;
    }

    private void dfs(ArrayList<Edge> graph[], int current, int parent, boolean visited[], int dt[], int low[], int time, List<List<Integer>> bridges) {
        visited[current] = true;
        dt[current] = low[current] = time++;
        
        for (Edge e : graph[current]) {
            if (e.dest == parent) {
                continue;
            }
            if (!visited[e.dest]) {
                dfs(graph, e.dest, current, visited, dt, low, time, bridges);
                low[current] = Math.min(low[current], low[e.dest]);
                if (low[e.dest] > dt[current]) {
                    bridges.add(Arrays.asList(current, e.dest));
                }
            } else {
                low[current] = Math.min(low[current], dt[e.dest]);
            }
        }
    }

    private static class Edge {
        int dest;
        Edge(int dest) {
            this.dest = dest;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        List<List<Integer>> connections = Arrays.asList(
            Arrays.asList(0, 1),
            Arrays.asList(1, 2),
            Arrays.asList(2, 0),
            Arrays.asList(1, 3)
        );
        List<List<Integer>> result = sol.criticalConnections(4, connections);
        System.out.println(result);
    }
}
