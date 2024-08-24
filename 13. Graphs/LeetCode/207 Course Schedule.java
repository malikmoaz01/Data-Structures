import java.util.*;

class Solution {

    class Edge {
        int dest;
        
        Edge(int dest) {
            this.dest = dest;
        }
    }

    boolean isCycle(ArrayList<Edge>[] graph, boolean[] visited, int current, boolean[] s) {
        visited[current] = true;
        s[current] = true;
        for(Edge e : graph[current]) {
            if(s[e.dest]) {
                return true;
            } else if (!visited[e.dest] && isCycle(graph, visited, e.dest, s)) {
                return true;
            }
        }
        s[current] = false;
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Edge>[] list = new ArrayList[numCourses];
        boolean[] visited = new boolean[numCourses];
        boolean[] s = new boolean[numCourses];

        for(int i = 0; i < numCourses; i++) {
            list[i] = new ArrayList<>();
        }
        for (int[] prerequisite : prerequisites) {
            int src = prerequisite[1];
            int dest = prerequisite[0];
            list[src].add(new Edge(dest));
        }

        for(int i = 0; i < numCourses; i++) {
            if(!visited[i] && isCycle(list, visited, i, s)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 1}, {3, 2}};
        boolean result = solution.canFinish(numCourses, prerequisites);
        System.out.println(result);
    }
}
