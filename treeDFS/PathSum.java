package treeDFS;

import treeBFS.TreeNode;

/*
This program checks if there is a root-to-leaf path in a binary tree where the sum of the node values equals a given `targetSum`.
The problem is solved using Depth-First Search (DFS).

### Problem Statement:
- Given the root of a binary tree and a `targetSum`, determine if there is a root-to-leaf path such that the sum of the values along the path equals the `targetSum`.
- A leaf node is a node with no children.

### Explanation of the Code:

1. **Base Case:**
   - If the root is null (i.e., the tree is empty), return `false` because no path exists in an empty tree.

     Code:
     if (root == null) return false;

2. **Leaf Node Check:**
   - If the current node is a leaf (i.e., it has no left or right children), check if the current node's value equals the remaining `targetSum`.
   - If the value of the leaf node matches the remaining target sum, return `true`. Otherwise, return `false`.

     Code:
     if (root.left == null && root.right == null) {
         return targetSum == root.val;
     }

3. **Recursive Case (DFS Traversal):**
   - For non-leaf nodes, recursively check the left and right subtrees.
   - Subtract the current node's value from the `targetSum` and pass the updated `targetSum` to the child nodes.
   - If any subtree (left or right) returns `true`, return `true` because a valid path has been found.

     Code:
     return hasPathSum(root.left, targetSum - root.val) ||
            hasPathSum(root.right, targetSum - root.val);

4. **How It Works:**
   - The function starts at the root and explores all possible paths down to the leaves using DFS.
   - It subtracts the current node's value from `targetSum` at each step, updating the required sum for the remaining path.
   - Once a leaf is reached, the function checks if the remaining sum equals the leaf node’s value, which confirms whether the path is valid.

### Example:
For the following binary tree and `targetSum = 22`:

          5
         / \
        4   8
       /   / \
      11  13  4
     /  \      \
    7    2      1

- There exists a path with sum 22: 5 → 4 → 11 → 2.
- The function will return `true` for this tree.

### Time Complexity:
- Each node is visited once, so the time complexity is **O(N)**, where N is the total number of nodes in the tree.

### Space Complexity:
- The space complexity is **O(N)** in the worst case due to the recursion stack, where N is the number of nodes.

### Key Points:
- The function uses DFS to explore all paths from the root to the leaves.
- At each node, the remaining `targetSum` is updated by subtracting the current node’s value.
- The base case checks if a leaf node completes the sum.
*/

public class PathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        // If it's a leaf node, check if it completes the sum
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        // Recursively check left and right subtrees
        return hasPathSum(root.left, targetSum - root.val) ||
                hasPathSum(root.right, targetSum - root.val);
    }
}
