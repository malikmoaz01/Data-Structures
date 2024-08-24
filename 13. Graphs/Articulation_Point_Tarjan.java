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

    public static void dfs(ArrayList<Edge> graph[], int current, int parent, boolean visited[], int dt[], int low[], int time, boolean isArticulation[]) {
        visited[current] = true;
        dt[current] = low[current] = ++time;
        int child = 0;

        for (Edge e : graph[current]) {
            if (e.dest == parent) {
                continue;
            }
            if (visited[e.dest]) {
                low[current] = Math.min(low[current], dt[e.dest]);
            } else {
                dfs(graph, e.dest, current, visited, dt, low, time, isArticulation);
                low[current] = Math.min(low[current], low[e.dest]);

                if (parent != -1 && dt[current] < low[e.dest]) {
                    isArticulation[current] = true;
                }
                child++;
            }
        }

        if (parent == -1 && child > 1) {
            isArticulation[current] = true;
        }
    }

    public static void getArticulation(ArrayList<Edge> graph[], int V) {
        int dt[] = new int[V];
        int low[] = new int[V];
        int time = 0;
        boolean vis[] = new boolean[V];
        boolean isArticulation[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(graph, i, -1, vis, dt, low, time, isArticulation);
            }
        }

        for (int i = 0; i < V; i++) {
            if (isArticulation[i]) {
                System.out.println(i);
            }
        }
    }

    public static void main(String args[]) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        getArticulation(graph, V);
    }
}
