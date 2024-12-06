package doordash.dp;

public class HouseRobber {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int prev2 = 0; // dp[i-2]
        int prev1 = 0; // dp[i-1]

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

