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
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1); // Helper function call
    }
    
    private TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null; // Base case: agar left index right se bada ho gaya, return null
        }
        
        int mid = left + (right - left) / 2; // Middle element nikalna
        TreeNode node = new TreeNode(nums[mid]); // New node create ki middle element ke saath
        
        node.left = helper(nums, left, mid - 1); // Left half se left child banao
        node.right = helper(nums, mid + 1, right); // Right half se right child banao
        
        return node; // Return the node
    }
}

public class Main {
    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};

        Solution solution = new Solution();
        TreeNode root = solution.sortedArrayToBST(nums);
        
        // A simple function to print the tree in order (for testing purposes)
        printInOrder(root);
    }

    private static void printInOrder(TreeNode root) {
        if (root != null) {
            printInOrder(root.left);
            System.out.print(root.val + " ");
            printInOrder(root.right);
        }
    }
}
