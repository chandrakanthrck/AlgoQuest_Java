package doordash.dp;

public class HouseRobberII {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        // Rob excluding the first house or excluding the last house
        return Math.max(robLinear(nums, 0, nums.length - 2), robLinear(nums, 1, nums.length - 1));
    }

    private int robLinear(int[] nums, int start, int end) {
        int prev2 = 0; // dp[i-2]
        int prev1 = 0; // dp[i-1]

        for (int i = start; i <= end; i++) {
            int current = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }

    public static void main(String[] args) {
        HouseRobberII solver = new HouseRobberII();

        int[] nums1 = {2, 3, 2};
        System.out.println("Maximum robbed amount: " + solver.rob(nums1)); // Output: 3

        int[] nums2 = {1, 2, 3, 1};
        System.out.println("Maximum robbed amount: " + solver.rob(nums2)); // Output: 4

        int[] nums3 = {1, 2, 3};
        System.out.println("Maximum robbed amount: " + solver.rob(nums3)); // Output: 3
    }
}
