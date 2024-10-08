package treeBFS;

import java.util.LinkedList;
import java.util.Queue;

/*Problem Statement: Find the minimum depth of a binary tree. The minimum depth is the number of nodes along the
shortest path from the root node down to the nearest leaf node.
 */
public class MinDepthBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            depth++;

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();

                // Check if it's a leaf node
                if (currentNode.left == null && currentNode.right == null) {
                    return depth;
                }

                if (currentNode.left != null) queue.offer(currentNode.left);
                if (currentNode.right != null) queue.offer(currentNode.right);
            }
        }

        return depth;
    }
}
