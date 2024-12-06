package doordash.dfs;

import java.util.HashMap;
import java.util.HashSet;

public class MakingALargeIsland {
    public int largestIsland(int[][] grid) {
        int n = grid.length;

        // Map to store area of each island with its unique id
        HashMap<Integer, Integer> islandAreaMap = new HashMap<>();
        int islandId = 2; // Start island IDs from 2 (since 0 and 1 are already used)

        // Step 1: Mark each island with a unique ID and calculate its area
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j, islandId);
                    islandAreaMap.put(islandId, area);
                    islandId++;
                }
            }
        }

        // Step 2: Check for maximum area after flipping one 0 to 1
        int maxArea = islandAreaMap.values().stream().max(Integer::compareTo).orElse(0); // Handle case of all 1s
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    // Use a set to track unique neighboring island IDs
                    HashSet<Integer> uniqueIslands = new HashSet<>();
                    for (int[] dir : directions) {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] > 1) {
                            uniqueIslands.add(grid[x][y]);
                        }
                    }

                    // Calculate the new potential area
                    int newArea = 1; // Include the flipped cell
                    for (int id : uniqueIslands) {
                        newArea += islandAreaMap.get(id);
                    }
                    maxArea = Math.max(maxArea, newArea);
                }
            }
        }

        return maxArea;
    }

    // DFS to calculate island area and label it with a unique ID
    private int dfs(int[][] grid, int row, int col, int islandId) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != 1) {
            return 0;
        }

        grid[row][col] = islandId; // Mark the cell with the island ID
        int area = 1; // Current cell
        for (int[] dir : directions) {
            area += dfs(grid, row + dir[0], col + dir[1], islandId);
        }
        return area;
    }

    // Directions array for moving in 4 possible directions
    private final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
}

