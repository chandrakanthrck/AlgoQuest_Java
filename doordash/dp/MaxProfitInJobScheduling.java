package doordash.dp;

import java.util.Arrays;
/*
Maximum Profit in Job Scheduling
Approach
Sort Jobs:

Sort the jobs by their endTime to process them in the order they finish.
Binary Search for Non-Overlapping Jobs:

as we do not want over lapping what we are going to do is whenever there is an overlap with the 2 compared values
we will only record the one which has the maximum value
whenever there is no overlap, we are going to add the current value to the previous recorded maximum value
and update the maximum value by the current total
 */
public class MaxProfitInJobScheduling {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;

        // Combine startTime, endTime, and profit into a single array of jobs
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }

        // Sort jobs by their endTime
        Arrays.sort(jobs, (a, b) -> Integer.compare(a[1], b[1]));

        // DP array to store maximum profit at each step
        int[] dp = new int[n];
        dp[0] = jobs[0][2]; // The profit of the first job

        // Array of end times for binary search
        int[] endTimes = new int[n];
        for (int i = 0; i < n; i++) {
            endTimes[i] = jobs[i][1];
        }

        // Process each job
        for (int i = 1; i < n; i++) {
            // Profit if we include the current job
            int includeProfit = jobs[i][2];

            // Find the most recent non-overlapping job using binary search
            int index = binarySearch(endTimes, jobs[i][0]);
            if (index != -1) {
                includeProfit += dp[index];
            }

            // Maximum profit at this step
            dp[i] = Math.max(dp[i - 1], includeProfit);
        }

        // Return the maximum profit
        return dp[n - 1];
    }

    // Binary search to find the most recent non-overlapping job
    private int binarySearch(int[] endTimes, int target) {
        int low = 0, high = endTimes.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (endTimes[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high; // Return the index of the most recent non-overlapping job
    }
}
