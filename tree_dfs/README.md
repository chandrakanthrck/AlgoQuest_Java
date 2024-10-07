
# Tree Depth-First Search (DFS)

## Overview
The **Depth-First Search (DFS)** is a tree traversal technique that explores as far as possible along each branch before backtracking. DFS can be implemented in three main ways: **inorder**, **preorder**, and **postorder**. DFS uses a recursive or stack-based approach.

## When to Use:
- **Exploring tree depths**: Useful when you need to explore all children of a node before moving to the next sibling.
- **Tree Traversals**: Inorder, Preorder, Postorder traversals are types of DFS used for binary trees.
- **Solving recursion-heavy problems**: DFS is naturally implemented using recursion.

## Effective Scenarios:
- **Binary Trees**: When performing tree traversals like Preorder, Inorder, or Postorder.
- **Graph Exploration**: Useful for exploring all paths or all nodes in a graph or tree structure.

## How to Recognize Problems that Use Tree DFS:
- **Recursion-based traversals**: If the problem requires visiting nodes recursively or visiting nodes in a specific order (Inorder, Preorder, or Postorder).
- **Tree Depth Exploration**: If you need to visit all nodes in a branch before backtracking.

## Example Problem Types:
- **Inorder, Preorder, Postorder Traversal**: Perform various tree traversals using DFS.
- **Maximum Depth of a Binary Tree**: Find the maximum depth of a binary tree.
- **Path Sum in Binary Tree**: Find a path in a tree that sums to a target value.

## Smart Hacks to Recognize DFS Problems:
- **Tree Depths**: If you need to explore an entire subtree before backtracking, DFS is effective.
- **Tree Traversals**: If the problem explicitly asks for traversal types (Inorder, Preorder, Postorder), DFS is the way to go.
- **Recursion-based Problems**: DFS is a natural fit for recursive solutions in tree and graph problems.

## Key Code Components:
- **Recursion**: DFS uses recursive function calls to explore tree nodes.
- **Stack**: If implemented iteratively, a stack is used to backtrack to previous nodes.
