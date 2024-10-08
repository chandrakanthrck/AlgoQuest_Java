package islandMatrixTraversal;

/*
Problem 1: Number of Islands
This is a foundational problem where you need to count the number of islands in a
binary matrix (0 represents water, and 1 represents land).

Problem Statement
Given a 2D grid, each cell is either '1' (land) or '0' (water). An island is a group of adjacent '1's
connected horizontally or vertically. You may assume all four edges of the grid are surrounded by water.
 */
public class IslandCounter {
    public int numsIsIsland(char[] [] grid){
        if(grid == null || grid.length == 0){
            return 0;
        }
        int numOfIslands = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == '1'){
                    numOfIslands++;
                    dfs(grid, i, j);
                }
            }

        }
        return numOfIslands;
    }
    private void dfs(char[][] grid, int i, int j){
        int rows = grid.length;
        int cols = grid[0].length;
        if(i<0 || i>=rows || j<0 || j>=cols || grid[i][j] == '0'){
            return;
        }
        grid[i][j] = '0';
        // Traverse in all 4 directions
        dfs(grid, i + 1, j); // down
        dfs(grid, i - 1, j); // up
        dfs(grid, i, j + 1); // right
        dfs(grid, i, j - 1); // left
    }
}
