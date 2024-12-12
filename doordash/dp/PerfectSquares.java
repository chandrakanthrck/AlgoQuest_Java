package doordash.dp;
import java.util.Arrays;

/*
Given an integer n, return the least number of perfect square numbers that sum to n.
A perfect square is an integer that is the square of an integer; in other words, it is
the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.

Example 1:
Input: n = 12
Output: 3
Explanation: 12 = 4 + 4 + 4.
Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.

Constraints:
1 <= n <= 104
 */
public class PerfectSquares {
    public int numSquares(int n) {
        // Create a DP array and initialize to maximum values
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // Base case

        // Fill DP array
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        PerfectSquares solver = new PerfectSquares();

        System.out.println("Minimum perfect squares for 12: " + solver.numSquares(12)); // Output: 3 (4+4+4)
        System.out.println("Minimum perfect squares for 13: " + solver.numSquares(13)); // Output: 2 (4+9)
    }
}

