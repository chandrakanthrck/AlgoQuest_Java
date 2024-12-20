package doordash.dp;

/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected, and
it will automatically contact the police if two adjacent houses were broken into on the same night.
Given an integer array nums representing the amount of money of each house, return the maximum amount of
money you can rob tonight without alerting the police.
Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.

Constraints:
1 <= nums.length <= 100
0 <= nums[i] <= 400
 */
public class HouseRobber {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int prev2 = 0; // dp[i-2]
        int prev1 = 0; // dp[i-1]

        //we are comparing prev1, prev2+num because the condition of the problem is that
        //you cannot rob 2 adjacent houses.
        for (int num : nums) {
            int current = Math.max(prev1, prev2 + num);
            prev2 = prev1;
            prev1 = current;
        }

        return prev1; // The last calculated maximum
    }

    public static void main(String[] args) {
        HouseRobber solver = new HouseRobber();

        int[] nums1 = {1, 2, 3, 1};
        System.out.println("Maximum robbed amount: " + solver.rob(nums1)); // Output: 4

        int[] nums2 = {2, 7, 9, 3, 1};
        System.out.println("Maximum robbed amount: " + solver.rob(nums2)); // Output: 12
    }
}

