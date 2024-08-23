import java.util.*;

public class Topological_Sorting {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    public static void Topological_Sorting(ArrayList<Edge> graph[], int current, boolean visited[], Stack<Integer> s) {
        visited[current] = true;

        for(int i = 0; i < graph[current].size(); i++) {
            Edge e = graph[current].get(i);
            if(!visited[e.dest]) {
                Topological_Sorting(graph, e.dest, visited, s);
            }
        }
        s.push(current);
    }

    public static void main(String args[]) {
        int V = 6; 
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>(); 

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                Topological_Sorting(graph, i, visited, stack);
            }
        }

        System.out.println("Topological Sort:");
        while(!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
