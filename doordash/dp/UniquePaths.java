package doordash.dp;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        // Create a 2D array to store the number of paths to each cell
        int[][] dp = new int[m][n];

        // Fill the first row with 1 since there is only one way to move horizontally
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        // Fill the first column with 1 since there is only one way to move vertically
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        // Iterate through the grid starting from cell (1,1)
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // The number of ways to reach this cell is the sum of the ways
                // from the cell above and the cell to the left
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        // The bottom-right corner contains the total number of unique paths
        return dp[m - 1][n - 1];
    }

    // Main method for testing
    public static void main(String[] args) {
        UniquePaths solution = new UniquePaths();
        int m = 3, n = 7;
        System.out.println("Number of unique paths: " + solution.uniquePaths(m, n)); // Output: 28
    }
}
