import java.util.*;

public class Solution {
    public List<Integer> middleSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int levelSize = q.size();
            int midIndex = (levelSize - 1) / 2;

            List<TreeNode> levelNodes = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = q.poll();
                levelNodes.add(current);

                if (current.left != null) {
                    q.offer(current.left);
                }
                if (current.right != null) {
                    q.offer(current.right);
                }
            }

            if (!levelNodes.isEmpty()) {
                result.add(levelNodes.get(midIndex).val);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        Solution sol = new Solution();
        List<Integer> middleSide = sol.middleSideView(root);
        System.out.println(middleSide); 
    }
}

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
