package treeBFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Problem Statement: Given a binary tree, imagine yourself standing on the right side of it,
return the values of the nodes you can see ordered from top to bottom.
 /*
This program returns the **right-side view** of a binary tree, where we imagine looking at the tree from the right side.
The goal is to return the values of the nodes that are visible from the right side, ordered from top to bottom.

### Problem Statement:
- Given a binary tree, return a list of node values visible from the right side of the tree.
- The rightmost node at each level is what will be visible when viewed from the right.

### Explanation of the Code:

1. **Base Case:**
   - If the root is null (i.e., the tree is empty), return an empty list.
   - This handles the case where there is no tree to traverse.

     Code:
     if (root == null) return result;

2. **BFS Initialization:**
   - We use a queue to perform a **Breadth-First Search (BFS)**, which allows us to traverse the tree level by level.
   - Start by adding the root node to the queue and initializing a list `result` to store the right-side view nodes.

     Code:
     Queue<TreeNode> queue = new LinkedList<>();
     queue.offer(root);

3. **BFS Traversal:**
   - While the queue is not empty, we process each level of the tree.
   - The size of the queue (`levelSize`) gives us the number of nodes at the current level.
   - For each level, traverse through all the nodes, but only add the rightmost node (the last node of each level) to the result list.

     Code:
     int levelSize = queue.size();
     for (int i = 0; i < levelSize; i++) {
         TreeNode currentNode = queue.poll();

         // Add the last node in the level to the result list
         if (i == levelSize - 1) {
             result.add(currentNode.val);
         }

4. **Processing Children:**
   - After processing the current node, add its children to the queue to be processed at the next level.
   - Always process the left child first and the right child second, but only add the last node in each level to the result (i.e., the rightmost node).

     Code:
     if (currentNode.left != null) queue.offer(currentNode.left);
     if (currentNode.right != null) queue.offer(currentNode.right);

5. **Storing the Rightmost Node:**
   - If it's the last node in the current level (i.e., `i == levelSize - 1`), add it to the result list.
   - This ensures that only the rightmost nodes are included in the final output.

     Code:
     result.add(currentNode.val);

6. **Returning the Result:**
   - After all levels have been processed, the `result` list contains the rightmost nodes from top to bottom.
   - Return the result list as the right-side view of the tree.

### Time Complexity:
- Each node in the tree is processed once, so the time complexity is **O(N)**, where N is the total number of nodes in the tree.

### Space Complexity:
- The space complexity is **O(N)** because, in the worst case, the queue will contain all nodes at the largest level of the tree.

*/

public class RightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();

                // If it's the last node in the level, add to result
                if (i == levelSize - 1) {
                    result.add(currentNode.val);
                }

                if (currentNode.left != null) queue.offer(currentNode.left);
                if (currentNode.right != null) queue.offer(currentNode.right);
            }
        }
        return result;
    }
}

