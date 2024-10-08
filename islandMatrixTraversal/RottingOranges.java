package islandMatrixTraversal;

/*Problem Statement:
In a grid of oranges, each cell can be empty, have a fresh orange (1), or a rotten orange (2).
Every minute, any fresh orange adjacent to a rotten one becomes rotten. Find the minimum time needed to rot all oranges,
 or return -1 if impossible.

Approach:
Technique: BFS (multi-source).
Steps:
Add all initially rotten oranges to a queue.
Perform BFS, rotting adjacent fresh oranges minute by minute.
Keep track of time elapsed and check if all fresh oranges are rotten at the end.
 */
import java.util.*;

public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        int fresh = 0, minutes = 0;
        int rows = grid.length, cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();

        // Step 1: Initialize queue with all rotten oranges and count fresh ones
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        // Directions for adjacent cells
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // Step 2: BFS to rot adjacent oranges
        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();
            minutes++;
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                for (int[] dir : directions) {
                    int x = cell[0] + dir[0];
                    int y = cell[1] + dir[1];
                    if (x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] == 1) {
                        grid[x][y] = 2; // Rot the orange
                        fresh--;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
        }

        return fresh == 0 ? minutes : -1;
    }
}
