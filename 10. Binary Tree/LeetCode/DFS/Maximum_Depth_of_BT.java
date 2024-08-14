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
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        if (root.left == null) {
            return maxDepth(root.right) + 1;
        }

        if (root.right == null) {
            return maxDepth(root.left) + 1;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return 1 + Math.max(leftDepth, rightDepth);
    }
}

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, 
            new TreeNode(2, new TreeNode(4), null), 
            new TreeNode(3)
        );

        Solution solution = new Solution();
        int depth = solution.maxDepth(root);
        System.out.println("Maximum depth of the binary tree is: " + depth);
    }
}
