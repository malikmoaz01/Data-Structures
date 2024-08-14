public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // Yani ke hume koi answer mil gya left ya right mese 
        if (left != null && right != null) {
            return root;
        }
        // Agr left null hai yani left me answer nahi mila to right side hoga 
        // Agr right side null hai to left me answer hoga 
        return left == null ? right : left;
    }
}

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node0 = new TreeNode(0);
        TreeNode node8 = new TreeNode(8);
        TreeNode node7 = new TreeNode(7);
        TreeNode node4 = new TreeNode(4);

        root.left = node5;
        root.right = node1;
        node5.left = node6;
        node5.right = node2;
        node1.left = node0;
        node1.right = node8;
        node2.left = node7;
        node2.right = node4;

        Solution solution = new Solution();
        TreeNode lca = solution.lowestCommonAncestor(root, node5, node1);
        System.out.println("The lowest common ancestor is: " + (lca != null ? lca.val : "null"));
    }
}
