import java.util.ArrayList;
import java.util.List;

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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root != null) {
            findPaths(root, "", paths);
        }
        return paths;
    }

    private void findPaths(TreeNode node, String path, List<String> paths) {
        if (node != null) {
            path += Integer.toString(node.val);
            if (node.left == null && node.right == null) { 
                paths.add(path);
            } else {
                path += "->"; 
                findPaths(node.left, path, paths);
                findPaths(node.right, path, paths);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, 
            new TreeNode(2, null, new TreeNode(5)), 
            new TreeNode(3)
        );

        Solution solution = new Solution();
        List<String> paths = solution.binaryTreePaths(root);
        System.out.println("All root-to-leaf paths: " + paths);
    }
}
