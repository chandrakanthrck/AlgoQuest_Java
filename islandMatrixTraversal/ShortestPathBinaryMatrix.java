package islandMatrixTraversal;

import java.util.*;

/*
Problem Statement:
Given an n x n binary matrix grid, return the length of the shortest path from the top-left corner to the
bottom-right corner. If there is no such path, return -1. You can move in 8 directions
(up, down, left, right, and diagonals).

Approach (BFS):
Use BFS since it is the most effective way to find the shortest path in an unweighted grid.
Start at the top-left and explore all neighboring cells.
 */
public class ShortestPathBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1 || grid[grid.length - 1][grid.length - 1] == 1) {
            return -1; // No path if start or end is blocked
        }

        int n = grid.length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1}); // (row, col, distance)
        grid[0][0] = 1; // Mark the starting cell as visited

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}}; // 8 directions

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0], col = cell[1], distance = cell[2];

            if (row == n - 1 && col == n - 1) {
                return distance; // If we reach the bottom-right corner
            }

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && grid[newRow][newCol] == 0) {
                    queue.offer(new int[]{newRow, newCol, distance + 1});
                    grid[newRow][newCol] = 1; // Mark as visited
                }
            }
        }

        return -1; // No path found
    }
}