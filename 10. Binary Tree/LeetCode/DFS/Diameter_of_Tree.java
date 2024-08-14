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
    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        diameter = Math.max(diameter, leftHeight + rightHeight);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, 
            new TreeNode(2, new TreeNode(4), new TreeNode(5)), 
            new TreeNode(3)
        );

        Solution solution = new Solution();
        int diameter = solution.diameterOfBinaryTree(root);
        System.out.println("Diameter of the binary tree is: " + diameter);
    }
}
