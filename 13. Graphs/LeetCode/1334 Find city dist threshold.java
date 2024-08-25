import java.util.*;

public class Solution {

    static class Edge {
        int src, dest, wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
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

    // Function to run Dijkstra and return the distance array
    public static int[] dijkstra(ArrayList<Edge> graph[], int src) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[] dist = new int[graph.length];
        boolean[] visited = new boolean[graph.length];

        Arrays.fill(dist, Integer.MAX_VALUE);

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
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }

        return dist;
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // Create the graph
        ArrayList<Edge> graph[] = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            graph[u].add(new Edge(u, v, w));
            graph[v].add(new Edge(v, u, w));
        }

        // Find the city with the smallest number of reachable cities
        int minReachableCount = Integer.MAX_VALUE;
        int cityWithMinReachableCount = -1;

        for (int i = 0; i < n; i++) {
            int[] dist = dijkstra(graph, i);
            int reachableCount = 0;

            for (int j = 0; j < n; j++) {
                if (i != j && dist[j] <= distanceThreshold) {
                    reachableCount++;
                }
            }

            // Update the result if this city has fewer reachable cities
            // or if it's a tie but has a higher city index
            if (reachableCount < minReachableCount ||
                (reachableCount == minReachableCount && i > cityWithMinReachableCount)) {
                minReachableCount = reachableCount;
                cityWithMinReachableCount = i;
            }
        }

        return cityWithMinReachableCount;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 4;
        int[][] edges = {{0,1,3},{1,2,1},{1,3,4},{2,3,1}};
        int distanceThreshold = 4;
        System.out.println(sol.findTheCity(n, edges, distanceThreshold));  // Output: 3
    }
}
