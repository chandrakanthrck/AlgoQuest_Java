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
        if (grid == null || grid.length == 0){
            return 0;
        }
        int numberOfIslands = 0;
        int row = grid.length;
        int col = grid[0].length;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == '1'){
                    numberOfIslands++;
                    dfs(grid, i, j);
                }
            }
        }
        return  numberOfIslands;
    }
    private void dfs(char[][] grid, int i, int j) {
        int rows = grid.length;
        int cols = grid[0].length;
        if (i < 0 || i >= rows || j < 0 || j >= cols) {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j + 1);
        dfs(grid, i, j - 1);
    }
}
