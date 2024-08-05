import java.util.*;

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result; // Edge case: empty tree

        boolean reverse = false;
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int levelSize = q.size();
            List<Integer> currentList = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode current;
                if (!reverse) {
                    current = q.pollFirst();
                    currentList.add(current.val);
                    if (current.left != null) q.offerLast(current.left);
                    if (current.right != null) q.offerLast(current.right);
                } else {
                    current = q.pollLast();
                    currentList.add(current.val);
                    if (current.right != null) q.offerFirst(current.right);
                    if (current.left != null) q.offerFirst(current.left);
                }
            }

            result.add(currentList);
            reverse = !reverse;
        }

        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a sample tree: 
        //       1
        //      / \
        //     2   3
        //    / \   \
        //   4   5   6

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        Solution solution = new Solution();
        List<List<Integer>> result = solution.zigzagLevelOrder(root);
        for (List<Integer> level : result) {
            System.out.println(level);
        }
    }
}
