package doordash;

import java.util.Arrays;

/*
826. Most Profit Assigning Work
You have n jobs and m workers. You are given three arrays: difficulty, profit, and worker where:
difficulty[i] and profit[i] are the difficulty and the profit of the ith job, and
worker[j] is the ability of jth worker (i.e., the jth worker can only complete a job with difficulty at most worker[j]).
Every worker can be assigned at most one job, but one job can be completed multiple times.
For example, if three workers attempt the same job that pays $1, then the total profit will be $3. If a worker
cannot complete any job, their profit is $0.
Return the maximum profit we can achieve after assigning the workers to the jobs.

Example 1:
Input: difficulty = [2,4,6,8,10], profit = [10,20,30,40,50], worker = [4,5,6,7]
Output: 100
Explanation: Workers are assigned jobs of difficulty [4,4,6,6] and they get a profit of [20,20,30,30] separately.
Example 2:

Input: difficulty = [85,47,57], profit = [24,66,99], worker = [40,25,25]
Output: 0
Constraints:
n == difficulty.length
n == profit.length
m == worker.length
1 <= n, m <= 104
1 <= difficulty[i], profit[i], worker[i] <= 105

Approach
Sort Jobs by Difficulty:
Combine difficulty and profit into a list of jobs and sort them by difficulty. This allows us to easily find
the highest-paying job that a worker can handle.
Sort Workers by Ability:
Sort the worker array in ascending order so we can assign jobs to workers in increasing order of their ability.
Optimize Profit Tracking:
As we traverse the sorted jobs, maintain the maximum profit for jobs of increasing difficulty. This ensures that
for any worker, we can directly assign the best possible job they can handle.
Iterate Over Workers:
For each worker, determine the highest-paying job they can handle by iterating through the sorted jobs.
Accumulate Total Profit:
For each worker, add the profit of the best job they can handle to the total profit.
 */
public class MostProfitAssigningWork {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        // Combine difficulty and profit into jobs and sort by difficulty
        int n = difficulty.length;
        int[][] jobs = new int[n][2];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]); // Sort jobs by difficulty

        // Sort workers by their ability
        Arrays.sort(worker);

        int maxProfit = 0; // Maximum profit at or below current difficulty
        int totalProfit = 0; // Total profit for all workers
        int jobIndex = 0; // Pointer to iterate through jobs

        // Assign jobs to workers
        for (int ability : worker) {
            // Update maxProfit for the current worker's ability
            while (jobIndex < n && jobs[jobIndex][0] <= ability) {
                maxProfit = Math.max(maxProfit, jobs[jobIndex][1]);
                jobIndex++;
            }
            // Add the best possible profit for this worker
            totalProfit += maxProfit;
        }

        return totalProfit;
    }
}

/*
Explanation with Example
Example 1:
Input:
difficulty = [2, 4, 6, 8, 10]
profit = [10, 20, 30, 40, 50]
worker = [4, 5, 6, 7]
Combine and Sort Jobs:
Jobs = [[2, 10], [4, 20], [6, 30], [8, 40], [10, 50]]
Sorted by difficulty.
Sort Workers:
Worker = [4, 5, 6, 7]
Iterate Over Workers:
Worker 4:
Can handle job 4 with profit 20.
Update maxProfit = 20.
Add 20 to totalProfit.
Worker 5:
Can handle job 4 with profit 20.
Add 20 to totalProfit.
Worker 6:
Can handle job 6 with profit 30.
Update maxProfit = 30.
Add 30 to totalProfit.
Worker 7:
Can handle job 6 with profit 30.
Add 30 to totalProfit.
Result:
TotalProfit = 20 + 20 + 30 + 30 = 100
Output:
100
 */
