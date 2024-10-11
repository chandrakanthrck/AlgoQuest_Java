package islandMatrixTraversal;

/*
Problem Statement:
Given a binary grid, your task is to find the number of distinct islands.
Two islands are considered distinct if one island is not equal to another (not the same shape),
even if they are rotated or flipped.

Approach:
Technique: DFS with path signature.
Steps:
Traverse the grid and perform DFS when you find a land cell.
During DFS, record the sequence of moves (e.g., "U", "D", "L", "R") to create a unique signature for each island's shape.
Use a Set to store unique signatures.
 */
import java.util.*;

public class NumberOfDistinctIslands {
    public int numDistinctIslands(int[][] grid) {
        Set<String> shapes = new HashSet<>();
        int row = grid.length;
        int col = grid[0].length;
        for(int i = 0; i < row; i++){
            for(int j = 0; j< col; j++){
                if(grid[i][j] == 1){
                    StringBuilder shape = new StringBuilder();
                    dfs(grid, i, j, shape, "S");
                    shapes.add(shape.toString());
                }
            }
        }
        return shapes.size();
    }

    private void dfs(int[][] grid, int i, int j, StringBuilder shape, String dir) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] != 1) {
            return;
        }

        grid[i][j] = 0; // Mark as visited
        shape.append(dir);

        dfs(grid, i + 1, j, shape, "D"); // Down
        dfs(grid, i - 1, j, shape, "U"); // Up
        dfs(grid, i, j + 1, shape, "R"); // Right
        dfs(grid, i, j - 1, shape, "L"); // Left

        shape.append("B"); // Backtracking
    }
}

