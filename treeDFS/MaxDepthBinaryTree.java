package treeDFS;

import treeBFS.TreeNode;

public class MaxDepthBinaryTree {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;  // Add 1 for the current node
    }
}

