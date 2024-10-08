package treeDFS;

import treeBFS.TreeNode;

public class TreeDFS {

    // Inorder traversal (Left, Root, Right)
    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    // Preorder traversal (Root, Left, Right)
    public void preorder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Postorder traversal (Left, Right, Root)
    public void postorder(TreeNode root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val + " ");
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

        TreeDFS tree = new TreeDFS();
        System.out.println("Inorder traversal:");
        tree.inorder(root);  // Expected output: 4 2 5 1 3 6

        System.out.println("\nPreorder traversal:");
        tree.preorder(root);  // Expected output: 1 2 4 5 3 6

        System.out.println("\nPostorder traversal:");
        tree.postorder(root);  // Expected output: 4 5 2 6 3 1
    }
}

