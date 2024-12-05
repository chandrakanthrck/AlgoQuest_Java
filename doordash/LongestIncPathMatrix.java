package doordash;
/*
Longest Increasing Path in a Matrix
Hard
Topics
Companies
Given an m x n integers matrix, return the length of the longest increasing path in matrix.
From each cell, you can either move in four directions: left, right, up, or down. You may not move diagonally
or move outside the boundary (i.e., wrap-around is not allowed).
Example 1:
Input: matrix = [[9,9,4],[6,6,8],[2,1,1]]
Output: 4
Explanation: The longest increasing path is [1, 2, 6, 9].
Example 2:
Input: matrix = [[3,4,5],[3,2,6],[2,2,1]]
Output: 4
Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
Example 3:
Input: matrix = [[1]]
Output: 1
Constraints:
m == matrix.length
n == matrix[i].length
1 <= m, n <= 200
0 <= matrix[i][j] <= 231 - 1
 */
public class LongestIncPathMatrix {
    public int longestIncreasingPath(int [][] matrix){
        if(matrix == null || matrix.length == 0) return 0;
        int rows = matrix.length;;
        int cols = matrix[0].length;
        int[][] cache = new int[rows][cols];
        int maxLength = 0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                maxLength = Math.max(maxLength, dfs(matrix, i, j, cache));
            }
        }
        return maxLength;
    }
    private int dfs(int[][] matrix, int i, int j, int[][] cache){
        if(cache[i][j]!=0) return cache[i][j]; //memoization
        int rows = matrix.length;
        int cols = matrix[0].length;
        // Initialize the path length starting from this cell
        int maxLength = 1;
        int[][] directions = {
                {0,1},
                {1,0},
                {0,-1},
                {-1,0}
        };
        for(int[] dir: directions){
            // Calculate the new row and column indices
            int newRow = i + dir[0];
            int newCol = j + dir[1];
            // Check if the new cell is within bounds and its value is greater
            if(newRow>=0 && newRow<rows && newCol>=0 && newCol>cols
            && matrix[newRow][newCol]>matrix[i][j]){
                // Recursively find the path length from the neighboring cell
                maxLength = Math.max(maxLength, 1 + dfs(matrix, newRow, newCol, cache));
            }
        }
        // Store the result for this cell in the cache
        cache[i][j] = maxLength;

        // Return the maximum path length for this cell
        return maxLength;

    }
}
