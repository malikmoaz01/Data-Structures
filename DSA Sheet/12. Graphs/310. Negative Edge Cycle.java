import java.util.ArrayList;

public class BellmanFord {

    static class Edge {
        int src, dest, wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void bellmanFord(ArrayList<Edge>[] graph, int src) {
        int dist[] = new int[graph.length];
        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;

        for (int i = 0; i < graph.length - 1; i++) {
            for (int j = 0; j < graph.length; j++) {
                for (Edge e : graph[j]) {
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                    }
                }
            }
        }

        // Check for negative weight cycles
        for (int j = 0; j < graph.length; j++) {
            for (Edge e : graph[j]) {
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                    System.out.println("Graph contains a negative weight cycle");
                    return;
                }
            }
        }

        // If no negative weight cycle was found
        System.out.println("No negative weight cycle detected");
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, -1));
        graph[0].add(new Edge(0, 2, 4));
        graph[1].add(new Edge(1, 2, 3));
        graph[1].add(new Edge(1, 3, 2));
        graph[1].add(new Edge(1, 4, 2));
        graph[3].add(new Edge(3, 2, 5));
        graph[3].add(new Edge(3, 1, 1));
        graph[4].add(new Edge(4, 3, -3));

        bellmanFord(graph, 0);
    }
}
