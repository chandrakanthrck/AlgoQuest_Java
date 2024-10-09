package treeBFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Problem Statement: Given a binary tree, return the level order traversal of its nodes' values.
(i.e., from left to right, level by level).
/*
This program performs a **level-order traversal** of a binary tree, also known as a Breadth-First Search (BFS) traversal.
In this traversal, nodes are visited level by level from left to right.

### Problem Statement:
- Given a binary tree, return a list of lists, where each list contains the values of nodes at the same level.
- We will visit all nodes at depth 1 first, followed by nodes at depth 2, and so on, level by level.

### Explanation of the Code:

1. **Base Case:**
   - If the `root` is null (i.e., the tree is empty), return an empty list.
   - This handles the case where there is no tree to traverse.

     Code:
     if (root == null) return result;

2. **BFS Initialization:**
   - Use a queue to perform BFS, starting by adding the `root` node to the queue.
   - The queue helps process nodes level by level.
   - We also initialize a list `result` that will store the lists of node values at each level.

     Code:
     Queue<TreeNode> queue = new LinkedList<>();
     queue.offer(root);

3. **BFS Traversal:**
   - While the queue is not empty, we process each level of the tree.
   - The size of the queue (`levelSize`) tells us how many nodes are present at the current level.
   - Initialize a temporary list `currentLevel` to store the values of nodes at this level.

     Code:
     int levelSize = queue.size();
     List<Integer> currentLevel = new ArrayList<>();

4. **Processing Nodes in Each Level:**
   - For each node at the current level:
     - Remove the node from the queue.
     - Add the node's value to `currentLevel`.
     - Add its left and right children (if they exist) to the queue for processing in the next level.

     Code:
     TreeNode currentNode = queue.poll();
     currentLevel.add(currentNode.val);

     if (currentNode.left != null) queue.offer(currentNode.left);
     if (currentNode.right != null) queue.offer(currentNode.right);

5. **Storing the Level:**
   - After processing all nodes at the current level, add `currentLevel` to the `result` list.
   - Repeat this process until the queue is empty, meaning all levels have been processed.

     Code:
     result.add(currentLevel);

6. **Returning the Result:**
   - Once all nodes have been processed, the `result` list contains the node values organized by levels.
   - Return the `result` as the final output.

### Time Complexity:
- Each node in the tree is processed once, so the time complexity is **O(N)**, where N is the total number of nodes in the tree.

### Space Complexity:
- The space complexity is **O(N)** because, in the worst case, we need to store nodes at the largest level of the tree in the queue.

*/

public class LevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val);

                if (currentNode.left != null) queue.offer(currentNode.left);
                if (currentNode.right != null) queue.offer(currentNode.right);
            }

            result.add(currentLevel);
        }
        return result;
    }
}
