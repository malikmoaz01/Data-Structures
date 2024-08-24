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
        graph[2].add(new Edge(2, 0)); 
        graph[1].add(new Edge(1, 3));
    }

    static void createGraphWithoutCycle(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1));
        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 3));
    }

    public static boolean isCycle(ArrayList<Edge>[] graph, int curr, boolean vis[], boolean stack[]) {
        vis[curr] = true;
        stack[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (stack[e.dest]) {
                return true;
            } else if (!vis[e.dest] && isCycle(graph, e.dest, vis, stack)) {
                return true;
            }
        }
        stack[curr] = false;
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
                    for (Edge e : graph[node]) {
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

    public static void main(String args[]) {
        int V1 = 4;
        ArrayList<Edge> graph1[] = new ArrayList[V1];
        createGraphWithCycle(graph1);
        System.out.println("BFS traversal of graph with a cycle:");
        bfs(graph1, V1);
        boolean[] vis1 = new boolean[V1];
        boolean[] stack1 = new boolean[V1];
        boolean hasCycle1 = false;
        for (int i = 0; i < V1; i++) {
            if (!vis1[i]) {
                if (isCycle(graph1, i, vis1, stack1)) {
                    hasCycle1 = true;
                    break;
                }
            }
        }
        System.out.println("Graph with a cycle contains cycle: " + hasCycle1);

        int V2 = 4;
        ArrayList<Edge> graph2[] = new ArrayList[V2];
        createGraphWithoutCycle(graph2);
        System.out.println("BFS traversal of graph without a cycle:");
        bfs(graph2, V2);
        boolean[] vis2 = new boolean[V2];
        boolean[] stack2 = new boolean[V2];
        boolean hasCycle2 = false;
        for (int i = 0; i < V2; i++) {
            if (!vis2[i]) {
                if (isCycle(graph2, i, vis2, stack2)) {
                    hasCycle2 = true;
                    break;
                }
            }
        }
        System.out.println("Graph without a cycle contains cycle: " + hasCycle2);
    }
}
