import java.util.*;

class Solution {
    static class Edge {
        int dest, cost;
        Edge(int d, int c) {
            this.dest = d;
            this.cost = c;
        }
    }

    static class Pair implements Comparable<Pair> {
        int node, cost, stops;
        Pair(int node, int cost, int stops) {
            this.node = node;
            this.cost = cost;
            this.stops = stops;
        }
        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.cost, other.cost);
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<Edge>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Build the graph from the flight information
        for (int[] flight : flights) {
            int u = flight[0];
            int v = flight[1];
            int w = flight[2];
            graph[u].add(new Edge(v, w));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[][] dist = new int[n][k + 2];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        pq.add(new Pair(src, 0, 0));
        dist[src][0] = 0;

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int u = current.node;
            int cost = current.cost;
            int stops = current.stops;

            if (u == dst) {
                return cost;
            }

            if (stops > k) continue;

            for (Edge e : graph[u]) {
                int v = e.dest;
                int newCost = cost + e.cost;
                if (stops + 1 <= k && newCost < dist[v][stops + 1]) {
                    dist[v][stops + 1] = newCost;
                    pq.add(new Pair(v, newCost, stops + 1));
                }
            }
        }

        return -1; 
    }
    
    public static void createGraph(ArrayList<Edge> graph[]) {
        // Example function to build graph if needed
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 4;
        int[][] flights = {
            {0, 1, 100},
            {1, 2, 100},
            {2, 0, 100},
            {1, 3, 600},
            {2, 3, 200}
        };
        int src = 0;
        int dst = 3;
        int k = 1;

        int result = sol.findCheapestPrice(n, flights, src, dst, k);
        System.out.println("Cheapest price from " + src + " to " + dst + " with at most " + k + " stops is: " + result);
    }
}
