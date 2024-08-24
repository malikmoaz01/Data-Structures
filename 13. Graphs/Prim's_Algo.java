import java.util.*;

public class PrimsAlgorithm {

    static class Edge {
        int src;
        int dest;
        int wt;

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
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));
        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));
        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));
        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));
    }

    static class Pair implements Comparable<Pair> {
        int node;
        int wt;

        public Pair(int node, int wt) {
            this.node = node;
            this.wt = wt;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.wt - p2.wt;
        }
    }

    public static void primAlgo(ArrayList<Edge> graph[]) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[graph.length];
        pq.add(new Pair(0, 0));
        int cost = 0;
        while(!pq.isEmpty())
        {
            Pair current = pq.poll();
            if(!visited[current.node])
            {
                visited[current.node] = true;
                cost += current.wt;
                for(Edge e : graph[current.node].length)
                {
                    if(!visited[e.dest])
                    {
                        pq.add(new Pair(e.dest , e.wt));
                    }
                }
            }
        }
        System.out.println(cost);
    }

    public static void main(String args[]) {
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        primAlgo(graph);
    }
}
