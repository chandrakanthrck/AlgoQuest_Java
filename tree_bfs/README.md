
# Tree Breadth-First Search (BFS)

## Overview
The **Breadth-First Search (BFS)** is a tree traversal technique that explores nodes level by level, starting from the root and moving across each level. This technique is implemented using a **queue** to process nodes at each level before moving deeper into the tree.

## When to Use:
- **Level-by-level exploration**: When you need to process or retrieve nodes in a tree by levels, such as level order traversal.
- **Shortest path in unweighted graphs**: BFS is commonly used to find the shortest path in unweighted graphs.
- **Balanced trees**: Checking for a balanced binary tree, or solving problems that require level-wise processing.

## Effective Scenarios:
- **Tree traversal**: Especially effective when you want to traverse a tree level-by-level.
- **Binary Trees**: Problems that involve checking completeness or depth of a binary tree.

## How to Recognize Problems that Use Tree BFS:
- **Level Order Traversal**: If the problem asks for node values by levels, BFS is the most efficient approach.
- **Shortest Path in Trees**: If you need to find the shortest path between nodes in an unweighted tree.
- **Tree Width**: BFS can be used to measure the width of a tree at each level.

## Example Problem Types:
- **Level Order Traversal**: Return nodes in level-order from a binary tree.
- **Minimum Depth of a Binary Tree**: Find the minimum depth from root to a leaf.
- **Right Side View of a Binary Tree**: Return the nodes visible from the right side of a binary tree.

## Smart Hacks to Recognize BFS Problems:
- **Level-Wise Requirement**: If the problem involves traversing or processing nodes at each level, think BFS.
- **Shortest Path in Trees**: If you’re tasked with finding the shortest path, especially in unweighted trees, BFS is ideal.
- **Balanced Trees**: BFS can be used to determine whether the tree is balanced.

## Key Code Components:
- **Queue**: Used to process nodes level by level.
- **Tracking Level Size**: Useful for processing nodes at each level before moving to the next level.
