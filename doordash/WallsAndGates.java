package doordash;

import java.util.LinkedList;
import java.util.Queue;

/*
Walls and Gates
You are given an m x n grid rooms initialized with these three possible values.

-1 A wall or an obstacle.
0 A gate.
INF Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the
distance to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be
filled with INF.

Explanation of the Code
Initialization:
A queue is used to hold the positions of all gates (0) in the grid.
Multi-Source BFS:
Start BFS from all gates simultaneously. This ensures that each room is updated with the shortest distance to any gate.
The neighbors of each cell are explored using a DIRECTIONS array to avoid repetitive code for moving in 4 directions.
Condition for Updating:
Only update cells with value INF (representing an empty room). Walls (-1) and already processed cells are skipped.
Distance Update:
For an empty room, its distance is updated to the distance of the current cell + 1.

 */
public class WallsAndGates {
    private static final int[][] DIRECTIONS = {{0,1},{1,0},{0,-1},{-1,0}};
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) return;
        int rows = rooms.length;
        int cols = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();
        // Add all gates to the queue as starting points
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        //Perform BFS
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentRow = current[0];
            int currentCol = current[1];
            // Check all 4 possible directions
            for (int[] direction : DIRECTIONS) {
                int newRow = currentRow + direction[0];
                int newCol = currentCol + direction[1];
                // Skip invalid cells or walls
                if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols
                        || rooms[newRow][newCol] != Integer.MAX_VALUE) {
                    continue;
                }
                // Update the distance to the nearest gate
                rooms[newRow][newCol] = rooms[currentRow][currentCol] + 1;
                queue.offer(new int[]{newRow, newCol});
            }
        }
    }
}
