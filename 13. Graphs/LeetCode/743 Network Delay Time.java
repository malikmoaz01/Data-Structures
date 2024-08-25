import java.util.*;

class Solution {

    // Edge Class
    static class Edge {
        int dest, wt;

        public Edge(int d, int w) {
            this.dest = d;
            this.wt = w;
        }
    }

    // Pair Data Structure
    static class Pair implements Comparable<Pair> {
        int node;
        int path;

        Pair(int node, int path) {
            this.node = node;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p2) {
            return Integer.compare(this.path, p2.path);
        }
    }
    
    // Dijkstra Code 
    public static int[] dijkstra(ArrayList<Edge>[] graph, int src) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[] dist = new int[graph.length];
        boolean[] visited = new boolean[graph.length];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int u = current.node;

            if (!visited[u]) {
                visited[u] = true;

                for (Edge e : graph[u]) {
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

    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<Edge>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] flight : times) {
            int u = flight[0];
            int v = flight[1];
            int w = flight[2];
            graph[u].add(new Edge(v, w));
        }

        int[] dist = dijkstra(graph, k);

        int maxDist = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
            maxDist = Math.max(maxDist, dist[i]);
        }

        return maxDist;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[][] times1 = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        System.out.println(sol.networkDelayTime(times1, 4, 2));  // Output: 2
        
        int[][] times2 = {{1, 2, 1}};
        System.out.println(sol.networkDelayTime(times2, 2, 1));  // Output: 1
        
        int[][] times3 = {{1, 2, 1}};
        System.out.println(sol.networkDelayTime(times3, 2, 2));  // Output: -1
    }
}
