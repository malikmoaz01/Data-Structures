import java.util.*;

public class BFS {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    static void createGraphWithCycle(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1));
        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 0)); // Cycle: 0 -> 1 -> 2 -> 0
        graph[1].add(new Edge(1, 3));
    }

    static void createGraphWithoutCycle(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1));
        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 3)); // No cycle in this path: 0 -> 1 -> 2 -> 3
    }

    public static boolean isCyclicUtil(ArrayList<Edge>[] graph, boolean[] vis, int curr, int par) {
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                if (isCyclicUtil(graph, vis, e.dest, curr)) {
                    return true;
                }
            } else if (e.dest != par) {
                return true; 
            }
        }
        return false;
    }

    public static boolean isCyclic(ArrayList<Edge>[] graph, boolean[] vis) {
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (isCyclicUtil(graph, vis, i, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void bfs(ArrayList<Edge>[] graph, int V) {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                visited[i] = true;
                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    System.out.print(node + " ");
                    for (int j = 0; j < graph[node].size(); j++) {
                        Edge e = graph[node].get(j);
                        if (!visited[e.dest]) {
                            queue.add(e.dest);
                            visited[e.dest] = true;
                        }
                    }
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int V1 = 4;
        ArrayList<Edge> graph1[] = new ArrayList[V1];
        createGraphWithCycle(graph1);
        System.out.println("BFS traversal of graph with a cycle:");
        bfs(graph1, V1);
        boolean[] vis1 = new boolean[V1];
        boolean hasCycle1 = isCyclic(graph1, vis1);
        System.out.println("Graph with a cycle contains cycle: " + hasCycle1);

        int V2 = 4;
        ArrayList<Edge> graph2[] = new ArrayList[V2];
        createGraphWithoutCycle(graph2);
        System.out.println("BFS traversal of graph without a cycle:");
        bfs(graph2, V2);
        boolean[] vis2 = new boolean[V2];
        boolean hasCycle2 = isCyclic(graph2, vis2);
        System.out.println("Graph without a cycle contains cycle: " + hasCycle2);
    }
}
