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
    public void flatten(TreeNode root) {
        TreeNode current = root;
        while (current != null) {
            if (current.left != null) {
                TreeNode temp = current.left;
                while (temp.right != null) {
                    temp = temp.right;
                }

                temp.right = current.right;
                current.right = current.left;
                current.left = null;
            }
            current = current.right;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, 
            new TreeNode(2, new TreeNode(3), new TreeNode(4)), 
            new TreeNode(5, null, new TreeNode(6))
        );

        Solution solution = new Solution();
        solution.flatten(root);
        
        // Print the flattened tree to verify
        printFlattenedTree(root);
    }

    private static void printFlattenedTree(TreeNode root) {
        while (root != null) {
            System.out.print(root.val + " ");
            root = root.right;
        }
    }
}
