package doordash.dp;

public class HouseRobberII {
    public int rob(int[] nums){
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        //as this is cyclic, we need to check for 2 conditions to get the solution
        //1st : rob house 1 until last but one
        //2nd : rob house 2 until last one
        return  Math.max(robLinear(nums, 0 , nums.length-2), robLinear(nums, 1, nums.length-1));
    }

    //regular house robber logic
    //cannot rob adjacent house, and keep checking for the max you can rob with the same condition
    private int robLinear(int[] nums, int start, int stop){
        int prev1 = 0, prev2 = 0;
        for(int i = start; i<=stop; i++){
            int current = Math.max(prev1, prev2+nums[i]);
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
