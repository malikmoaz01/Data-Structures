import java.util.*;

public class Tarjan_Algo_SCC {

    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 1));
        graph[3].add(new Edge(3, 4));
    }

    public static void dfs(ArrayList<Edge> graph[], int current, int parent, boolean visited[], int dt[], int low[], int time) {
        visited[current] = true;
        dt[current] = low[current] = time++;
        
        for (Edge e : graph[current]) {
            if (e.dest == parent) {
                continue;
            }
            if (!visited[e.dest]) {
                dfs(graph, e.dest, current, visited, dt, low, time);
                low[current] = Math.min(low[current], low[e.dest]);
                if (low[e.dest] > dt[current]) {
                    System.out.println("BRIDGE : " + current + "---" + e.dest);
                }
            } else {
                low[current] = Math.min(low[current], dt[e.dest]);
            }
        }
    }

    public static void getBridge(ArrayList<Edge> graph[], int V) {
        int dt[] = new int[V];
        int low[] = new int[V];
        boolean visited[] = new boolean[V];
        Arrays.fill(dt, -1);
        Arrays.fill(low, -1);
        
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(graph, i, -1, visited, dt, low, 0);
            }
        }
    }

    public static void main(String args[]) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        getBridge(graph, V);
    }
}
