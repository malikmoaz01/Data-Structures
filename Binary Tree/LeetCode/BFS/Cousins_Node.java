// Explanation:

// if (node.left != null):

// Yeh condition check karti hai ke current node ka left child hai ya nahi. 
// Agar left child null nahi hai, to iska matlab current node ka left child exist karta hai.
// queue.add(node.left):

// Agar left child exist karta hai, to isse queue mein add kar dete hain. 
// Yeh BFS traversal ke liye zaroori hai taake agle level par left child bhi process ho.
// if (node.left.val == x):

// Yeh condition check karti hai ke left child ka value x ke barabar hai ya nahi. 
// Agar barabar hai, to iska matlab x node ka left child mil gaya hai.
// parentX = node;:

// Agar left child ka value x ke barabar hai, to parentX ko current node set kar dete hain. 
// Yeh record karne ke liye ke x node ka parent kaun hai.
// levelX = level;:

// levelX ko current level set kar dete hain, jahan x node mil gaya. 
// Yeh zaroori hai taake level comparison ke liye use ho sake.
// if (node.left.val == y):

// Yeh condition check karti hai ke left child ka value y ke barabar hai ya nahi. 
// Agar barabar hai, to iska matlab y node ka left child mil gaya hai.
// parentY = node;:

// Agar left child ka value y ke barabar hai, to parentY ko current node set kar dete hain. 
// Yeh record karne ke liye ke y node ka parent kaun hai.
// levelY = level;:

// levelY ko current level set kar dete hain, jahan y node mil gaya.


import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }
        
        // Initialize BFS queue
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        int levelX = -1, levelY = -1;
        TreeNode parentX = null, parentY = null;
        int level = 0;
        
        while (!q.isEmpty()) {
            int size = q.size();
            parentX = parentY = null; // Reset parents for this level
            levelX = levelY = -1; // Reset levels for this level
            
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                
                // Check left child
                if (node.left != null) {
                    q.add(node.left);
                    if (node.left.val == x) {
                        parentX = node;
                        levelX = level;
                    }
                    if (node.left.val == y) {
                        parentY = node;
                        levelY = level;
                    }
                }
                
                // Check right child
                if (node.right != null) {
                    q.add(node.right);
                    if (node.right.val == x) {
                        parentX = node;
                        levelX = level;
                    }
                    if (node.right.val == y) {
                        parentY = node;
                        levelY = level;
                    }
                }
            }
            
            if (parentX != null && parentY != null) {
                return (levelX == levelY) && (parentX != parentY);
            }
            
            level++;
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        // Create the tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        
        // Create solution instance
        Solution solution = new Solution();
        
        // Test isCousins method
        boolean result1 = solution.isCousins(root, 4, 5); // Expected output: true
        boolean result2 = solution.isCousins(root, 4, 6); // Expected output: false
        
        // Print results
        System.out.println("Are 4 and 5 cousins? " + result1);
        System.out.println("Are 4 and 6 cousins? " + result2);
    }
}
