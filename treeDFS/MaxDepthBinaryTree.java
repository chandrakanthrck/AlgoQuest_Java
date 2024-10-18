package treeDFS;

import treeBFS.TreeNode;

/*
This program calculates the **maximum depth** of a binary tree using a Depth-First Search (DFS) approach.
The maximum depth is the longest path from the root node to a leaf node in the tree.

### Problem Statement:
- Given a binary tree, find the maximum depth (i.e., the number of nodes along the longest path from the root to the farthest leaf node).

### Explanation of the Code:

1. **Base Case:**
   - If the root is null (i.e., the tree is empty), return 0, because the depth of an empty tree is 0.

     Code:
     if (root == null) return 0;

2. **Recursive Case (DFS Traversal):**
   - For a non-null node, the function recursively calculates the depth of the left and right subtrees.
   - The depth of the current node is 1 plus the maximum of the depths of the left and right subtrees.
   - This recursion works by breaking down the tree into smaller subtrees until leaf nodes are reached.

     Code:
     int leftDepth = maxDepth(root.left);
     int rightDepth = maxDepth(root.right);

3. **Combining Depths:**
   - Once the depths of both the left and right subtrees are known, the function returns the larger depth (because we are interested in the maximum depth).
   - We add 1 to account for the current node itself.

     Code:
     return Math.max(leftDepth, rightDepth) + 1;

4. **How It Works:**
   - The recursion starts from the root and goes down to the leaf nodes, calculating the depth for each node.
   - When a null node (leaf node's child) is reached, the recursion returns 0. This is the base case for recursion.
   - As the recursion unwinds, each node's depth is calculated by taking the maximum depth of its two children (left and right).

### Example:
For the following binary tree:
        1
       / \
      2   3
     / \
    4   5

- The maximum depth is 3, as the longest path from the root to a leaf node is: 1 → 2 → 4 or 1 → 2 → 5.

### Time Complexity:
- Each node is visited exactly once, so the time complexity is **O(N)**, where N is the total number of nodes in the tree.

### Space Complexity:
- The space complexity is **O(N)** in the worst case due to the recursion stack, where N is the number of nodes.

### Key Points:
- The function uses depth-first search (DFS) to explore the tree and calculate the depth.
- The recursion ensures that the maximum depth of the tree is computed by comparing the depths of the left and right subtrees at each node.
*/

public class MaxDepthBinaryTree {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }
}

