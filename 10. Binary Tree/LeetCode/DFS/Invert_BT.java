public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, 
            new TreeNode(2, new TreeNode(4), new TreeNode(5)), 
            new TreeNode(3)
        );

        Solution solution = new Solution();
        TreeNode invertedRoot = solution.invertTree(root);
        
        // A simple function to print the tree in order (for testing purposes)
        printInOrder(invertedRoot);
    }

    private static void printInOrder(TreeNode root) {
        if (root != null) {
            printInOrder(root.left);
            System.out.print(root.val + " ");
            printInOrder(root.right);
        }
    }
}
