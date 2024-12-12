package doordash.dp;

/*
An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
Given an integer n, return the nth ugly number.
Example 1:
Input: n = 10
Output: 12
Explanation: [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10 ugly numbers.
Example 2:
Input: n = 1
Output: 1
Explanation: 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.

Constraints:
1 <= n <= 1690
 */
public class UglyNumberII {
    public int nthUglyNumber(int n) {
        // DP array to store the first n ugly numbers
        int[] dp = new int[n];
        dp[0] = 1; // First ugly number is 1

        int p2 = 0, p3 = 0, p5 = 0; // Pointers for multiples of 2, 3, and 5

        for (int i = 1; i < n; i++) {
            // Compute the next ugly number
            int nextUgly = Math.min(dp[p2] * 2, Math.min(dp[p3] * 3, dp[p5] * 5));

            dp[i] = nextUgly;

            // Move pointers forward for the chosen factors
            if (nextUgly == dp[p2] * 2) p2++;
            if (nextUgly == dp[p3] * 3) p3++;
            if (nextUgly == dp[p5] * 5) p5++;
        }

        return dp[n - 1]; // Return the nth ugly number
    }

    public static void main(String[] args) {
        UglyNumberII solver = new UglyNumberII();

        System.out.println("10th Ugly Number: " + solver.nthUglyNumber(10)); // Output: 12
        System.out.println("1st Ugly Number: " + solver.nthUglyNumber(1));  // Output: 1
    }
}
