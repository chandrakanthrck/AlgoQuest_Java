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

explanation : the dfs function is going to hold each value starting from 0,0, and it will check all the 4 directions
to check if it is within the bounds, if it is not within the bounds, for that particular direction it will return 0.
when it finds the number which is greater than it according to the problem statement, it is going to shift to that
valid number for the problem statement and do a recursive call on that which is dfs call again.
Compute the max for all the directions of the greatest number and then add +1 to it. We do it because the current position
alone is a size of 1.
Memoization : Cache previous recursive calls that we have already made.
Steps for Memoization : Take another matrix with identical rows and cols initialize it to 0.
So now go to the matrix position where we have already computed the value and increment it by 1
keep updating this cache with the incremented value. We can verify if the path is already visited or not
by looking at the cache matrix. Revisit the matrix and see if there is any value not visited, if so
start the recursive call again on that position
 */
public class LongestIncPathMatrix {
    public int longestIncreasingPath(int [][] matrix){
        //check if valid matrix
        if(matrix == null || matrix.length == 0) return 0;
        int rows = matrix.length;;
        int cols = matrix[0].length;
        //for memoization
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
            //checking if the neighbouring indices are wiuthin bounds and if the value is greater, its in
            //the following lines
            int newRow = i + dir[0];
            int newCol = j + dir[1];
            // Check if the new cell is within bounds and its value is greater
            if(newRow>=0 && newRow<rows && newCol>=0 && newCol>cols
            && matrix[newRow][newCol]>matrix[i][j]){
                // Recursively find the path length from the neighboring cell
                //we start from 1 as we want the maximum length -> 1 + dfs
                maxLength = Math.max(maxLength, 1 + dfs(matrix, newRow, newCol, cache));
            }
        }
        // Store the result for this cell in the cache
        cache[i][j] = maxLength;

        // Return the maximum path length for this cell
        return maxLength;
    }
}
