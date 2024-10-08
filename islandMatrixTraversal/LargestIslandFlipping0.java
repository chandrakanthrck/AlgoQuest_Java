package islandMatrixTraversal;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
Problem Statement:
Given a binary grid, you can flip at most one 0 to 1. Return the size of the largest island possible after the flip.

Approach:
Technique: Union-Find or DFS with memoization.

Steps:
Assign each island a unique index and record its area.
For each 0, check its neighboring islands and calculate the potential island size by summing up unique
neighboring island areas plus one (for the flipped cell).
Keep track of the maximum island size found.
 */
public class LargestIslandFlipping0 {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int index = 2; // Start indexing from 2 to differentiate from 0 and 1
        Map<Integer, Integer> areaMap = new HashMap<>();
        int maxArea = 0;

        // Step 1: DFS to label islands with unique index and calculate areas
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j, index);
                    areaMap.put(index, area);
                    maxArea = Math.max(maxArea, area);
                    index++;
                }
            }
        }

        // Step 2: Try flipping each zero and calculate potential island size
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> neighborIslands = new HashSet<>();
                    if (i > 0 && grid[i - 1][j] > 1) neighborIslands.add(grid[i - 1][j]);
                    if (i < n - 1 && grid[i + 1][j] > 1) neighborIslands.add(grid[i + 1][j]);
                    if (j > 0 && grid[i][j - 1] > 1) neighborIslands.add(grid[i][j - 1]);
                    if (j < n - 1 && grid[i][j + 1] > 1) neighborIslands.add(grid[i][j + 1]);

                    int newArea = 1; // The flipped cell
                    for (int idx : neighborIslands) {
                        newArea += areaMap.get(idx);
                    }
                    maxArea = Math.max(maxArea, newArea);
                }
            }
        }

        return maxArea == 0 ? n * n : maxArea; // Handle the case where all cells are 1
    }

    private int dfs(int[][] grid, int i, int j, int index) {
        int n = grid.length;
        if (i < 0 || i >= n || j < 0 || j >= n || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = index;
        int area = 1;
        area += dfs(grid, i + 1, j, index);
        area += dfs(grid, i - 1, j, index);
        area += dfs(grid, i, j + 1, index);
        area += dfs(grid, i, j - 1, index);
        return area;
    }
}

