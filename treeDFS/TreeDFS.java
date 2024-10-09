package treeDFS;

import treeBFS.TreeNode;

/*
This program demonstrates three types of Depth-First Search (DFS) traversals in a binary tree:
1. **Inorder Traversal** (Left, Root, Right)
2. **Preorder Traversal** (Root, Left, Right)
3. **Postorder Traversal** (Left, Right, Root)

### Explanation of the Code:

1. **Inorder Traversal:**
   - The order of visiting nodes is:
     - Traverse the left subtree
     - Visit the root (current node)
     - Traverse the right subtree
   - In a binary search tree (BST), this traversal prints the nodes in ascending order.

     Code:
     public void inorder(TreeNode root) {
         if (root == null) return;
         inorder(root.left);
         System.out.print(root.val + " ");
         inorder(root.right);
     }

2. **Preorder Traversal:**
   - The order of visiting nodes is:
     - Visit the root (current node)
     - Traverse the left subtree
     - Traverse the right subtree
   - Preorder traversal is used to create a copy of the tree or to get prefix notation of an expression tree.

     Code:
     public void preorder(TreeNode root) {
         if (root == null) return;
         System.out.print(root.val + " ");
         preorder(root.left);
         preorder(root.right);
     }

3. **Postorder Traversal:**
   - The order of visiting nodes is:
     - Traverse the left subtree
     - Traverse the right subtree
     - Visit the root (current node)
   - Postorder traversal is used to delete the tree or to get postfix notation of an expression tree.

     Code:
     public void postorder(TreeNode root) {
         if (root == null) return;
         postorder(root.left);
         postorder(root.right);
         System.out.print(root.val + " ");
     }

4. **Example:**
   Given the following binary tree:
         1
        / \
       2   3
      / \   \
     4   5   6

   The output of the different DFS traversals will be:

   - Inorder Traversal (Left, Root, Right): `4 2 5 1 3 6`
   - Preorder Traversal (Root, Left, Right): `1 2 4 5 3 6`
   - Postorder Traversal (Left, Right, Root): `4 5 2 6 3 1`

5. **Main Method:**
   - The `main` method creates a sample binary tree and then calls the traversal methods (`inorder`, `preorder`, and `postorder`) to print the nodes in the specified order.

     Code:
     TreeNode root = new TreeNode(1);
     root.left = new TreeNode(2);
     root.right = new TreeNode(3);
     root.left.left = new TreeNode(4);
     root.left.right = new TreeNode(5);
     root.right.right = new TreeNode(6);

     tree.inorder(root);   // Expected: 4 2 5 1 3 6
     tree.preorder(root);  // Expected: 1 2 4 5 3 6
     tree.postorder(root); // Expected: 4 5 2 6 3 1

### Time Complexity:
- Each traversal visits every node exactly once, so the time complexity is **O(N)**, where N is the number of nodes in the tree.

### Space Complexity:
- The space complexity is **O(N)** in the worst case due to the recursion stack, where N is the total number of nodes.

### Key Points:
- Inorder traversal is commonly used with binary search trees to print values in order.
- Preorder traversal is useful for creating tree copies and tree serialization.
- Postorder traversal is useful for deleting or freeing trees and for postfix evaluation of expression trees.
*/

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

