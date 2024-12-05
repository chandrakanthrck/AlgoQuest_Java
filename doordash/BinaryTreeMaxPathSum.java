package doordash;

/*
124. Binary Tree Maximum Path Sum
A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge
connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
The path sum of a path is the sum of the node's values in the path.

Given the root of a binary tree, return the maximum path sum of any non-empty path.
Example 1:
Input: root = [1,2,3]
Output: 6
Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
Example 2:
Input: root = [-10,9,20,null,null,15,7]
Output: 42
Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
Constraints:

The number of nodes in the tree is in the range [1, 3 * 104].
-1000 <= Node.val <= 1000

Explanation:
To solve the Binary Tree Maximum Path Sum problem, we use a recursive approach to explore all possible paths in the tree and calculate the maximum path sum.

Key Idea
A path can start and end at any node in the binary tree.
For each node:
You can include the node's value, and optionally include one or both of its child subtrees.
The maximum path sum involving the current node can be:
The node's value alone.
The node's value plus the left subtree's path sum.
The node's value plus the right subtree's path sum.
The node's value plus both left and right subtree path sums.
We keep track of the global maximum path sum as we recurse through the tree.
 */
public class BinaryTreeMaxPathSum {
    private int maxSum = Integer.MIN_VALUE; // Global variable to store the maximum path sum

    public int maxPathSum(TreeNode root) {
        maxGain(root); // Start the recursion from the root
        return maxSum; // Return the global maximum path sum
    }

    private int maxGain(TreeNode node) {
        if (node == null) return 0; // Base case: null nodes contribute 0 to the path

        // Recursively calculate the maximum gain from the left and right subtrees
        int leftGain = Math.max(maxGain(node.left), 0); // Ignore negative gains
        int rightGain = Math.max(maxGain(node.right), 0); // Ignore negative gains

        // Calculate the path sum through the current node
        int currentPathSum = node.val + leftGain + rightGain;

        // Update the global maximum path sum
        maxSum = Math.max(maxSum, currentPathSum);

        // Return the maximum gain that this node can contribute to its parent
        return node.val + Math.max(leftGain, rightGain);
    }
}
