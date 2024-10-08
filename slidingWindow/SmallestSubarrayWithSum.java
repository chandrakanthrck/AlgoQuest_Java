package slidingWindow;

/*
Problem Statement: Given an array of positive integers, find the smallest contiguous subarray whose sum is greater
than or equal to a given number S. Return the length of the smallest subarray.

Approach:
The window size is dynamic. You increase the size of the window until the sum is greater than or equal to S,
then shrink the window from the left while it still satisfies the condition.

 */
public class SmallestSubarrayWithSum {
    public static int minSubArrayLen(int s, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        int left = 0;
        int windowSum = 0;
        for(int right = 0; right<nums.length;right++){
            windowSum+=nums[right];
            while(windowSum>=s){
                minLength = Math.min(minLength, right - left + 1);
                windowSum-=nums[left];
                left++;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 2, 3, 2};
        int s = 7;
        System.out.println(minSubArrayLen(s, nums));  // Output: 2 (subarray [5,2])
    }
}
