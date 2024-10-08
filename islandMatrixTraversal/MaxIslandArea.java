package islandMatrixTraversal;

/* Problem 2: Max Area of Island
Instead of counting the islands, you need to return the maximum area of any island in the grid.

Problem Statement:
Given a binary matrix grid, return the maximum area of an island (an island is connected 1s).
You may assume all four edges of the grid are surrounded by water.
 */
public class MaxIslandArea {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }

        grid[i][j] = 0; // Mark the cell as visited by setting it to 0
        int area = 1; // Include this cell in the area

        // Visit all four directions
        area += dfs(grid, i + 1, j); // down
        area += dfs(grid, i - 1, j); // up
        area += dfs(grid, i, j + 1); // right
        area += dfs(grid, i, j - 1); // left

        return area;
    }
}

