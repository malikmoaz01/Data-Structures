import java.util.*;

public class Kosaraju_Algo {

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

    public void topo(ArrayList<Edge>[] graph, int current, boolean[] visited, Stack<Integer> s) {
        visited[current] = true;
        for (Edge e : graph[current]) {
            if (!visited[e.dest]) {
                topo(graph, e.dest, visited, s);
            }
        }
        s.push(current);
    }

    public void dfs(ArrayList<Edge>[] graph, int current, boolean[] visited) {
        visited[current] = true;
        System.out.print(current + " ");
        for (Edge e : graph[current]) {
            if (!visited[e.dest]) {
                dfs(graph, e.dest, visited);
            }
        }
    }

    void kosaraju(ArrayList<Edge>[] graph, int v) {
        Stack<Integer> s = new Stack<>();
        boolean[] visited = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                topo(graph, i, visited, s);
            }
        }

        ArrayList<Edge>[] transpose = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            transpose[i] = new ArrayList<Edge>();
        }

        for (int i = 0; i < v; i++) {
            visited[i] = false;  
            for (Edge e : graph[i]) {
                transpose[e.dest].add(new Edge(e.dest, e.src));
            }
        }
        while (!s.isEmpty()) {
            int curr = s.pop();
            if (!visited[curr]) {
                System.out.print("SCC: ");
                dfs(transpose, curr, visited);
                System.out.println();
            }
        }
    }

    public static void main(String args[]) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        Kosaraju_Algo algo = new Kosaraju_Algo();
        algo.kosaraju(graph, V);
    }
}
