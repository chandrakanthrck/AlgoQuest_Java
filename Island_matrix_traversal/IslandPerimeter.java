package Island_matrix_traversal;

/*
Problem: Island Perimeter
Problem Statement:
You are given a 2D grid where:
1 represents land.
0 represents water.
An island is formed by connecting adjacent lands (horizontally or vertically).
The perimeter of the island is the total number of edges that touch the water or the boundary of the grid.

Approach:
To calculate the perimeter, we need to count the number of edges for each land cell:

If a cell is land (1), it contributes 4 edges to the perimeter initially.
If it has neighboring land cells, we subtract the number of shared edges with those cells
(each shared edge reduces the perimeter by 2).
 */
public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    perimeter += dfs(grid, i, j);
                }
            }
        }

        return perimeter;
    }

    private int dfs(int[][] grid, int i, int j) {
        // If we go out of bounds or encounter water, it contributes to the perimeter
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 1;
        }

        // If we have already visited this cell (set to 2), it doesn't contribute to the perimeter
        if (grid[i][j] == 2) {
            return 0;
        }

        // Mark the cell as visited
        grid[i][j] = 2;

        // DFS in all four directions and calculate perimeter
        int perimeter = dfs(grid, i + 1, j); // down
        perimeter += dfs(grid, i - 1, j); // up
        perimeter += dfs(grid, i, j + 1); // right
        perimeter += dfs(grid, i, j - 1); // left

        return perimeter;
    }
}

