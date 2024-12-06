package doordash.dfs;

public class MaxAreaOfIslands {
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int maxArea = 0;

        // Helper function to perform DFS
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
                }
            }
        }

        return maxArea;
    }

    private int dfs(int[][] grid, int row, int col) {
        // Check if the current cell is out of bounds or not land
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0) {
            return 0;
        }

        // Mark the cell as visited
        grid[row][col] = 0;

        // Calculate the area including the current cell and its neighbors
        int area = 1; // Current cell
        area += dfs(grid, row + 1, col); // Down
        area += dfs(grid, row - 1, col); // Up
        area += dfs(grid, row, col + 1); // Right
        area += dfs(grid, row, col - 1); // Left

        return area;
    }
}
