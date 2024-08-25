
class Solution {
    private Node[] clonedNodes; // Array to store cloned nodes

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        // Assuming the maximum node value equals the number of nodes
        clonedNodes = new Node[101]; // Adjust the size according to your graph's constraints

        boolean[] visited = new boolean[101]; // To keep track of visited nodes

        // Start DFS cloning from the initial node
        return DFS(node, visited);
    }

    private Node DFS(Node current, boolean[] visited) {
        if (visited[current.val]) {
            return clonedNodes[current.val];
        }

        // Clone the node
        Node clone = new Node(current.val);
        clonedNodes[current.val] = clone;
        visited[current.val] = true;

        // Recursively clone all the neighbors
        for (Node neighbor : current.neighbors) {
            clone.neighbors.add(DFS(neighbor, visited));
        }

        return clone;
    }
}
