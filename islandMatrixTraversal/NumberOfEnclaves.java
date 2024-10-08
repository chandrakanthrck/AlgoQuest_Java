package islandMatrixTraversal;

/*
Problem Statement:
Given a binary grid of size m x n, where 0 represents water and 1 represents land,
an enclave is a piece of land that is completely surrounded by water and cannot reach the boundary of the grid.
Your task is to count the number of land cells in all enclaves.

Approach:
Technique: Similar to the "Surrounded Regions" problem.
Steps:
Mark border-connected land cells: Traverse the borders of the grid and perform DFS/BFS
to mark all land cells connected to the boundary.
Count enclaves: After marking, traverse the grid and count the land cells (1s) that are not marked—these are the enclaves.
 */
public class NumberOfEnclaves {
    public int numEnclaves(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Step 1: Mark all land cells connected to the boundary
        for (int i = 0; i < rows; i++) {
            if (grid[i][0] == 1) {
                dfs(grid, i, 0);
            }
            if (grid[i][cols - 1] == 1) {
                dfs(grid, i, cols - 1);
            }
        }
        for (int j = 0; j < cols; j++) {
            if (grid[0][j] == 1) {
                dfs(grid, 0, j);
            }
            if (grid[rows - 1][j] == 1) {
                dfs(grid, rows - 1, j);
            }
        }

        // Step 2: Count the remaining land cells
        int enclaveCount = 0;
        for (int i = 1; i < rows - 1; i++) {
            for (int j = 1; j < cols - 1; j++) {
                if (grid[i][j] == 1) {
                    enclaveCount++;
                }
            }
        }
        return enclaveCount;
    }

    private void dfs(int[][] grid, int i, int j) {
        int rows = grid.length;
        int cols = grid[0].length;
        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] != 1) {
            return;
        }
        grid[i][j] = 0; // Mark as visited by setting it to water
        dfs(grid, i + 1, j); // Down
        dfs(grid, i - 1, j); // Up
        dfs(grid, i, j + 1); // Right
        dfs(grid, i, j - 1); // Left
    }
}

