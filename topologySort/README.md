
# Topological Sort

## Overview
**Topological Sort** is a linear ordering of vertices in a Directed Acyclic Graph (DAG) where for every directed edge `u -> v`, vertex `u` comes before vertex `v`. It is commonly used in scenarios involving dependencies between tasks or jobs. Topological sorting can be done using **DFS** or **Kahn's Algorithm (BFS)**.

## When to Use:
- **Dependency resolution**: When you need to order tasks based on dependencies (e.g., course prerequisites or job scheduling).
- **DAG traversal**: When you need to explore nodes in a DAG in a manner that respects directed edges.

## Effective Scenarios:
- **Task Scheduling**: When a task cannot be completed until some other task(s) is completed first, topological sort can provide the correct order.
- **Course Prerequisites**: Course scheduling problems, where a course requires certain prerequisites before being taken.

## How to Recognize Problems that Use Topological Sort:
- **Dependency Constraints**: If the problem talks about dependencies between tasks or jobs.
- **Directed Acyclic Graph (DAG)**: If the input is a directed graph with no cycles, topological sort might be relevant.

## Example Problem Types:
- **Course Schedule**: Determine if you can finish all courses given the prerequisites.
- **Course Schedule II**: Return the correct order in which to take the courses.
- **Alien Dictionary**: Find the character order in an alien language given a sorted dictionary.

## Smart Hacks to Recognize Topological Sort Problems:
- **Dependency Chains**: If tasks or actions have dependencies that determine their execution order.
- **Directed Graph**: If the problem deals with ordering or processing nodes in a DAG.

## Key Code Components:
- **DFS-based Topological Sort**: Use DFS to traverse the graph and process each node after all its dependencies.
- **Kahn’s Algorithm (BFS-based)**: Use BFS by tracking the in-degrees of nodes to process them in the correct order.
