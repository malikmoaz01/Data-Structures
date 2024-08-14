class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Node leftMost = root;
        while (leftMost.left != null) {
            Node current = leftMost;
            while (current != null) {
                current.left.next = current.right; // Connection between leaf Nodes 4 & 5 
                if (current.next != null) // 2-3-Null
                {
                    current.right.next = current.next.left; // 5 & 6 Connection
                }
                current = current.next; // Traversing the level or linked list 
            }
            leftMost = leftMost.left; // Traversing the tree side 
        }
        return root;
    }
}

public class Main {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        Solution solution = new Solution();
        solution.connect(node1);

        printNextPointers(node1);
    }

    public static void printNextPointers(Node root) {
        Node level = root;
        while (level != null) {
            Node current = level;
            while (current != null) {
                System.out.print(current.val + "->");
                if (current.next != null) {
                    System.out.print(current.next.val + " ");
                } else {
                    System.out.print("null ");
                }
                current = current.next;
            }
            System.out.println();
            level = level.left;
        }
    }
}
