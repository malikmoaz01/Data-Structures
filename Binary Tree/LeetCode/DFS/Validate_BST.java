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

public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode node, Integer low, Integer high) {
        if (node == null) {
            return true;
        }
        if ((low != null && node.val <= low) || (high != null && node.val >= high)) {
            return false;
        }
        return isValidBST(node.left, low, node.val) && isValidBST(node.right, node.val, high);
    }
}

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2, 
            new TreeNode(1), 
            new TreeNode(3)
        );

        Solution solution = new Solution();
        boolean isValid = solution.isValidBST(root);
        System.out.println("The tree is a valid BST: " + isValid);
    }
}
