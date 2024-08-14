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
    public int sumNumbers(TreeNode root) {
        return sumNumbersHelper(root, 0);
    }

    private int sumNumbersHelper(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        sum = sum * 10 + root.val;
        
        if (root.left == null && root.right == null) {
            return sum;
        }

        return sumNumbersHelper(root.left, sum) + sumNumbersHelper(root.right, sum);
    }
}

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, 
            new TreeNode(2), 
            new TreeNode(3)
        );

        Solution solution = new Solution();
        int totalSum = solution.sumNumbers(root);
        System.out.println("The sum of all numbers from root to leaf is: " + totalSum);
    }
}
