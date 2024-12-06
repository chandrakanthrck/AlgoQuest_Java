package doordash.dp;

import java.util.Arrays;
/*
Maximum Profit in Job Scheduling
Approach
Sort Jobs:

Sort the jobs by their endTime to process them in the order they finish.
Binary Search for Non-Overlapping Jobs:

Use binary search to find the most recent job that doesn’t overlap with the current job. This helps quickly determine which jobs can be included in the profit calculation without overlap.
Dynamic Programming:

Use a dp array where dp[i] represents the maximum profit obtainable by considering the first i jobs.
For each job, decide whether to include it:
If included, add its profit to the maximum profit of the last non-overlapping job.
If excluded, carry forward the maximum profit from the previous job.
Optimization:

Use a sorted array of job end times to perform binary search efficiently.
Algorithm
Combine startTime, endTime, and profit into a single array of jobs.
Sort the jobs based on their endTime.
Use a dp array to store the maximum profit at each step.
For each job:
Use binary search to find the most recent non-overlapping job.
Calculate the profit if the current job is included and compare it with the profit if the current job is excluded.
Update dp[i] accordingly.
Return the last value in the dp array, which represents the maximum profit considering all jobs.
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
