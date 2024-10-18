package treeBFS;

import java.util.LinkedList;
import java.util.Queue;

/*Problem Statement: Find the minimum depth of a binary tree. The minimum depth is the number of nodes along the
shortest path from the root node down to the nearest leaf node.
/*
This program calculates the minimum depth of a binary tree using the Breadth-First Search (BFS) technique.

### Problem Statement:
- The minimum depth is the shortest distance from the root node to the nearest leaf node (a node with no children).
- The task is to find the minimum depth, meaning the shortest path from the root to a leaf.

### Explanation of the Code:

1. **Base Case:**
   - If the root is null (i.e., the tree is empty), return a depth of 0.
     This handles the case where there is no tree to traverse.

     Code:
     if (root == null) return 0;

2. **BFS Initialization:**
   - We use a queue to implement BFS, starting with the root node.
   - BFS explores the tree level by level, which makes it suitable for finding the minimum depth.
   - Initialize a variable `depth` to track the current depth as we traverse each level.

     Code:
     Queue<TreeNode> queue = new LinkedList<>();
     queue.offer(root);
     int depth = 0;

3. **BFS Traversal:**
   - While the queue is not empty, we process each level of the tree.
   - For each level, increment the depth since we are moving one level deeper.
   - The size of the queue tells us how many nodes are in the current level.

     Code:
     while (!queue.isEmpty()) {
         int levelSize = queue.size();
         depth++;
         // process nodes in the current level
     }

4. **Processing Nodes in Each Level:**
   - For each node in the current level:
     - We remove (poll) the node from the queue.
     - We check if it is a leaf node (both left and right children are null).
       If it is a leaf node, we return the current depth because it's the shortest path to a leaf.

     Code:
     if (currentNode.left == null && currentNode.right == null) {
         return depth; // Found the nearest leaf node, return current depth
     }

   - If the node has a left child, we add it to the queue for processing in the next level.
   - If the node has a right child, we add it to the queue similarly.

     Code:
     if (currentNode.left != null) queue.offer(currentNode.left);
     if (currentNode.right != null) queue.offer(currentNode.right);

5. **Returning the Depth:**
   - The BFS ensures that the first time we encounter a leaf node, we return its depth because BFS explores the shallowest nodes first.
   - This guarantees the minimum depth of the tree.

### Time Complexity:
- Each node in the tree is processed once, so the time complexity is **O(N)**, where N is the number of nodes in the tree.

### Space Complexity:
- In the worst case (if the tree is completely unbalanced), the queue could hold all the nodes at a given level.
  So the space complexity is **O(N)** in the worst case, but typically it's **O(W)**, where W is the width of the tree at its largest level.

*/
public class MinDepthBinaryTree {
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;
        while(!queue.isEmpty()){
            int levelSize  = queue.size();
            for(int i= 0 ; i< levelSize; i++){
                TreeNode currentNode = queue.poll();
                if(currentNode.left==null && currentNode.right == null){
                    return depth;
                }
                if(currentNode.left!=null) queue.offer(currentNode.left);
                if(currentNode.right!=null) queue.offer(currentNode.right);
            }
            depth++;
        }
        return depth;
    }
}
