package treeDFS;

/*
This program performs an **in-order traversal** of a binary tree using Depth-First Search (DFS).
In an in-order traversal, the nodes are visited in the following order:
- Visit the left subtree
- Visit the current node
- Visit the right subtree

### Problem Statement:
- Given a binary tree, perform an in-order traversal and return the values of the nodes as a list.

### Explanation of the Code:

1. **inorderTraversal Method:**
   - This is the main method that initiates the traversal.
   - It creates a result list (`result`) to store the node values in in-order sequence.
   - The method then calls the helper function `inorderHelper` to perform the traversal.

     Code:
     public List<Integer> inorderTraversal(TreeNode root) {
         List<Integer> result = new ArrayList<>();
         inorderHelper(root, result);
         return result;
     }

2. **inorderHelper Method (Recursive Helper):**
   - This helper function is used to traverse the tree recursively in in-order fashion.
   - The function processes the left subtree first, then the current node, and finally the right subtree.
   - The base case is when the node is `null`, meaning we’ve reached a leaf node's child (end of a path).

     Code:
     private void inorderHelper(TreeNode root, List<Integer> result) {
         if (root == null) return;

         // Recursively traverse the left subtree
         inorderHelper(root.left, result);

         // Process the current node (add it to the result list)
         result.add(root.val);

         // Recursively traverse the right subtree
         inorderHelper(root.right, result);
     }

3. **How In-Order Traversal Works:**
   - In-order traversal visits nodes in the "left-root-right" order. It’s useful for binary search trees because it will visit nodes in ascending order.
   - The recursive structure breaks down the tree into smaller subproblems (left and right subtrees), processing the current node in between.

4. **Example:**
   For the following binary tree:
         1
          \
           2
          /
         3
   - The in-order traversal will visit the nodes in this order: 1 → 3 → 2.

5. **Recursive Flow:**
   - For each node, the function recursively calls itself for the left child, then processes the node, and finally calls itself for the right child.
   - When the node is `null` (leaf node reached), the recursion returns without further action.

### Time Complexity:
- Each node is visited exactly once, so the time complexity is **O(N)**, where N is the number of nodes in the tree.

### Space Complexity:
- The space complexity is **O(N)** due to the recursion stack and the result list that stores the node values.

### Key Points:
- In-order traversal is particularly useful for binary search trees (BST) because it returns the node values in ascending order.
- Recursive in-order traversal is simple to implement but has a space overhead due to the function call stack.
*/

import treeBFS.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderHelper(root, result);
        return result;
    }

    private void inorderHelper(TreeNode root, List<Integer> result) {
        if (root == null) return;
        inorderHelper(root.left, result);
        result.add(root.val);
        inorderHelper(root.right, result);
    }
}
