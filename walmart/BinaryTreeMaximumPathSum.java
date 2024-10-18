package walmart;

import treeBFS.TreeNode;

public class BinaryTreeMaximumPathSum {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxSum;
    }

    private int helper(TreeNode node) {
        if (node == null) return 0;

        int left = Math.max(helper(node.left), 0);
        int right = Math.max(helper(node.right), 0);

        int priceNewPath = node.val + left + right;
        maxSum = Math.max(maxSum, priceNewPath);

        return node.val + Math.max(left, right);
    }
}

