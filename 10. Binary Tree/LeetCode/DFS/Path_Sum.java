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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.val == targetSum && root.left == null && root.right == null) {
            return true;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5, 
            new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null), 
            new TreeNode(8, new TreeNode(13), new TreeNode(4, null, new TreeNode(1)))
        );

        Solution solution = new Solution();
        int targetSum = 22; // For example, checking if there is a path sum of 22
        boolean result = solution.hasPathSum(root, targetSum);
        System.out.println("Path with sum " + targetSum + " exists: " + result);
    }
}
