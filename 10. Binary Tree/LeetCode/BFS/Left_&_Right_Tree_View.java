import java.util.*;

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int levelSize = q.size();
            

            for (int i = 0; i < levelSize; i++) {
                TreeNode current = q.poll();
                // Right View yani last wala 
                if (i == levelSize - 1) {
                    result.add(current.val);
                }
                
                //  If Left View 
                
                // if (i == 0) {
                //     result.add(current.val);
                // }

                

                if (current.left != null) {
                    q.offer(current.left);
                }
                if (current.right != null) {
                    q.offer(current.right);
                }
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
        List<Integer> rightSide = sol.rightSideView(root);
        System.out.println(rightSide);
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
