package treeBFS;

import java.util.LinkedList;
import java.util.Queue;

public class TreeBFS {

    // Perform Breadth-First Search (BFS) on the tree
    public void bfs(TreeNode root) {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);  // Start with the root node

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();  // Dequeue the front node

            System.out.print(current.val + " ");  // Process the current node

            // Enqueue left child
            if (current.left != null) {
                queue.add(current.left);
            }

            // Enqueue right child
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    public static void main(String[] args) {
        // Example tree structure:
        //        1
        //       / \
        //      2   3
        //     / \   \
        //    4   5   6

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        TreeBFS tree = new TreeBFS();
        System.out.println("BFS traversal of the tree:");
        tree.bfs(root);
    }
}
