import java.util.*;

public class Dijkstra_Algo {

    static class Edge {
        int src, dest, wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));
        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));
        graph[2].add(new Edge(2, 4, 3));
        graph[3].add(new Edge(3, 5, 1));
        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }

    static class Pair implements Comparable<Pair> {
        int n;
        int path;

        Pair(int n, int path) {
            this.n = n;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.path - p2.path;
        }
    }

    public static int[] dijkstra(ArrayList<Edge> graph[], int src) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[] dist = new int[graph.length];
        boolean[] visited = new boolean[graph.length];
        int[] pred = new int[graph.length];  

        Arrays.fill(dist, Integer.MAX_VALUE); 
        Arrays.fill(pred, -1);

        dist[src] = 0;
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            if (!visited[current.n]) {
                visited[current.n] = true;

                for (Edge e : graph[current.n]) {
                    int u = e.src;
                    int v = e.dest;
                    if (!visited[v] && dist[u] + e.wt < dist[v]) {
                        dist[v] = dist[u] + e.wt;
                        pred[v] = u;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }
        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                System.out.print("Shortest path to node " + i + " (Distance: " + dist[i] + "): ");
                printPath(i, pred);
                System.out.println();
            }
        }

        return dist;  
    }

    private static void printPath(int current, int[] pred) {
        if (current == -1) return;
        printPath(pred[current], pred);
        System.out.print(current + " ");
    }

    public static void main(String args[]) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        int src = 0;
        int dist[] = dijkstra(graph, src);

        for (int i = 0; i < dist.length; i++) {
            System.out.println(dist[i] + " ");
        }
    }
}


// Distances (dist): [0, ∞, ∞, ∞, ∞, ∞]
// Distances (dist): [0, 2, 4, ∞, ∞, ∞]
// Distances (dist): [0, 2, 3, 9, ∞, ∞]
// Distances (dist): [0, 2, 3, 9, 6, ∞]
// Distances (dist): [0, 2, 3, 8, 6, 11]
// Distances (dist): [0, 2, 3, 8, 6, 9]
// Distances (dist): [0, 2, 3, 8, 6, 9]