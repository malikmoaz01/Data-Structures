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
    private int count = 0; // For tracking & matching 

    public int kthSmallest(TreeNode root, int k) {
        return Helper(root, k).val;
    }

    private TreeNode Helper(TreeNode root, int k) {
        if (root == null) {
            return null;
        }

        TreeNode left = Helper(root.left, k);
        if (left != null) {
            return left;
        }
        
        count++;
        if (count == k) {
            return root;
        }
        
        return Helper(root.right, k);
    }
}

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, 
            new TreeNode(1, null, new TreeNode(2)), 
            new TreeNode(4)
        );

        Solution solution = new Solution();
        int k = 2; // For example, finding the 2nd smallest element
        TreeNode kthNode = solution.kthSmallest(root, k);
        System.out.println("The " + k + "-th smallest element is: " + (kthNode != null ? kthNode.val : "null"));
    }
}
