import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
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
    public Integer Find_Next_Element_Successor(TreeNode root, int element) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode current = q.poll();

            if (current.left != null) {
                q.offer(current.left);
            }
            if (current.right != null) {
                q.offer(current.right);
            }
            if (current.val == element) {
                break;
            }
        }

        if (!q.isEmpty()) {
            return q.peek().val;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Solution solution = new Solution();
        Integer result = solution.Find_Next_Element_Successor(root, 20);

        if (result != null) {
            System.out.println("Next element successor: " + result);
        } else {
            System.out.println("No successor found.");
        }
    }
}
