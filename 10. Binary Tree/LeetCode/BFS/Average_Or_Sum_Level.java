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

public class Average_Or_Sum_Level {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int levelSize = q.size();
            double sum = 0; 
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = q.poll();
                sum += currentNode.val;

                if (currentNode.left != null) {
                    q.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    q.offer(currentNode.right);
                }
            }
            double avg = sum / levelSize; 
            result.add(avg);
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Average_Or_Sum_Level Average_Or_Sum_Level = new Average_Or_Sum_Level();
        List<Double> result = Average_Or_Sum_Level.averageOfLevels(root);

        for (Double avg : result) {
            System.out.println(avg);
        }
    }
}
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

class Average_Or_Sum_Level {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int levelSize = q.size();
            double sum = 0; 
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = q.poll();
                sum += currentNode.val;

                if (currentNode.left != null) {
                    q.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    q.offer(currentNode.right);
                }
            }
            double avg = sum / levelSize; 
            result.add(avg);
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Average_Or_Sum_Level Average_Or_Sum_Level = new Average_Or_Sum_Level();
        List<Double> result = Average_Or_Sum_Level.averageOfLevels(root);

        for (Double avg : result) {
            System.out.println(avg);
        }
    }
}
