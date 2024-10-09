package treeBFS;

/*
This program performs a **Breadth-First Search (BFS)** traversal on a binary tree.
BFS visits nodes level by level, starting from the root, then its children, and then the next level, and so on.

### Problem:
- Perform BFS on a binary tree and print the values of the nodes in level order.

### Explanation of the Code:

1. **Base Case:**
   - If the root is null (i.e., the tree is empty), print "Tree is empty" and exit the function.
   - This handles the case where there is no tree to traverse.

     Code:
     if (root == null) {
         System.out.println("Tree is empty");
         return;
     }

2. **BFS Initialization:**
   - We use a queue to implement BFS. The queue holds the nodes that need to be processed.
   - Initially, enqueue the root node because the BFS traversal starts from the root.

     Code:
     Queue<TreeNode> queue = new LinkedList<>();
     queue.add(root);  // Start with the root node

3. **BFS Traversal:**
   - While the queue is not empty, the traversal continues.
   - In each iteration:
     - Dequeue the front node from the queue (this node is currently being processed).
     - Print the value of the current node, which represents visiting the node.
     - If the current node has a left child, enqueue the left child.
     - If the current node has a right child, enqueue the right child.

     Code:
     TreeNode current = queue.poll();  // Dequeue the front node
     System.out.print(current.val + " ");  // Process the current node

     if (current.left != null) queue.add(current.left);  // Enqueue left child
     if (current.right != null) queue.add(current.right);  // Enqueue right child

4. **Main Method (Driver Code):**
   - In the `main` method, we construct a binary tree with the following structure:
        1
       / \
      2   3
     / \   \
    4   5   6
   - This tree has 6 nodes, and BFS will visit them level by level.
   - After creating the tree, the `bfs` method is called to traverse and print the nodes.

     Code:
     TreeNode root = new TreeNode(1);
     root.left = new TreeNode(2);
     root.right = new TreeNode(3);
     root.left.left = new TreeNode(4);
     root.left.right = new TreeNode(5);
     root.right.right = new TreeNode(6);

     TreeBFS tree = new TreeBFS();
     tree.bfs(root);  // BFS traversal of the tree

### Output:
For the given example tree, the output will be:
1 2 3 4 5 6
- The nodes are printed in level order, starting from the root.

### Time Complexity:
- Each node is processed exactly once, so the time complexity is **O(N)**, where N is the number of nodes in the tree.

### Space Complexity:
- The space complexity is **O(N)** because, in the worst case, the queue will contain nodes from the largest level of the tree.

*/

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
