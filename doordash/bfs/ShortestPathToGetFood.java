package doordash.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathToGetFood {
    public int getFood(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Directions array for moving up, down, left, right
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        // Find the starting position ('*')
        int startRow = 0, startCol = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '*') {
                    startRow = i;
                    startCol = j;
                    break;
                }
            }
        }

        // BFS queue
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startRow, startCol});
        grid[startRow][startCol] = 'X'; // Mark the starting cell as visited

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            //run through the queue
            for (int i = 0; i < size; i++) {
                //remove the value from the queue and check its adjacent values
                int[] current = queue.poll();
                //setting current row and col
                int currRow = current[0];
                int currCol = current[1];

                // Check all 4 directions
                for (int[] dir : directions) {
                    int newRow = currRow + dir[0];
                    int newCol = currCol + dir[1];

                    // Check boundaries and if the cell is not an obstacle
                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                        if (grid[newRow][newCol] == '#') {
                            // Food found, return steps + 1
                            return steps + 1;
                        }
                        if (grid[newRow][newCol] == 'O') {
                            // Mark the cell as visited and add it to the queue
                            grid[newRow][newCol] = 'X';
                            queue.add(new int[]{newRow, newCol});
                        }
                    }
                }
            }
            steps++;
        }

        // If no path to food is found
        return -1;
    }

    public static void main(String[] args) {
        char[][] grid1 = {
                {'X', 'X', 'X', 'X', 'X', 'X'},
                {'X', '*', 'O', 'O', 'O', 'X'},
                {'X', 'O', 'O', '#', 'O', 'X'},
                {'X', 'X', 'X', 'X', 'X', 'X'}
        };

        char[][] grid2 = {
                {'X', 'X', 'X', 'X', 'X'},
                {'X', '*', 'X', 'O', 'X'},
                {'X', 'O', 'X', '#', 'X'},
                {'X', 'X', 'X', 'X', 'X'}
        };

        ShortestPathToGetFood obj = new ShortestPathToGetFood();

        System.out.println("Example 1 Output: " + obj.getFood(grid1)); // Output: 3
        System.out.println("Example 2 Output: " + obj.getFood(grid2)); // Output: -1
    }
}

