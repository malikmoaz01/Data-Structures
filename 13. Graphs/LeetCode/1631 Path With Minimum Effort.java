import java.util.*;

class Solution {
    static class Edge {
        int dest;
        double wt;

        public Edge(int d, double w) {
            this.dest = d;
            this.wt = w;
        }
    }

    static class Pair implements Comparable<Pair> {
        int node;
        double probability;

        Pair(int n, double p) {
            this.node = n;
            this.probability = p;
        }

        @Override
        public int compareTo(Pair p2) {
            return Double.compare(p2.probability, this.probability);
        }
    }

    public double[] dijkstra(ArrayList<Edge> graph[], int src) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        double[] dist = new double[graph.length];
        boolean[] visited = new boolean[graph.length];
        Arrays.fill(dist, 0);

        dist[src] = 1.0;
        pq.add(new Pair(src, 1.0));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            if (visited[current.node]) continue;
            visited[current.node] = true;

            for (Edge e : graph[current.node]) {
                int v = e.dest;
                double newProb = dist[current.node] * e.wt;
                if (newProb > dist[v]) {
                    dist[v] = newProb;
                    pq.add(new Pair(v, newProb));
                }
            }
        }

        return dist;
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        ArrayList<Edge>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];
            graph[u].add(new Edge(v, prob));
            graph[v].add(new Edge(u, prob)); // since it's undirected
        }

        double[] probabilities = dijkstra(graph, start);
        return probabilities[end];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        int n1 = 3;
        int[][] edges1 = {{0,1},{1,2},{0,2}};
        double[] succProb1 = {0.5,0.5,0.2};
        int start1 = 0;
        int end1 = 2;
        System.out.println("Max Probability (Example 1): " + sol.maxProbability(n1, edges1, succProb1, start1, end1));

        // Example 2
        int n2 = 3;
        int[][] edges2 = {{0,1},{1,2},{0,2}};
        double[] succProb2 = {0.5,0.5,0.3};
        int start2 = 0;
        int end2 = 2;
        System.out.println("Max Probability (Example 2): " + sol.maxProbability(n2, edges2, succProb2, start2, end2));

        // Example 3
        int n3 = 3;
        int[][] edges3 = {{0,1}};
        double[] succProb3 = {0.5};
        int start3 = 0;
        int end3 = 2;
        System.out.println("Max Probability (Example 3): " + sol.maxProbability(n3, edges3, succProb3, start3, end3));
    }
}
