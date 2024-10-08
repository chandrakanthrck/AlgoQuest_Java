package slidingWindow;

/*
Problem Statement: Given a binary array nums and an integer k, find the length of the longest contiguous subarray
that contains only 1s after replacing at most k 0s with 1s.

Approach:
The window size is dynamic. Expand the window, and whenever the number of 0s in the window exceeds k, shrink the
window by moving the left pointer.
 */
public class LongestOnesAfterReplacement {
    public static int longestOnes(int[] nums, int k) {
        int left = 0;
        int maxLength = 0;
        int zeroCount = 0;
        for(int right = 0; right < nums.length; right++){
            if(nums[right] == 0){
                zeroCount++;
            }
            while(zeroCount>k){
                if(nums[left] == 0){
                    zeroCount--;
                }
                left++;
            }
            //right - left + 1 calculates the current length
            //basically to keep the longest subarray
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 0, 1, 1, 0, 1, 1, 1};
        int k = 2;
        System.out.println(longestOnes(nums, k));  // Output: 6 (subarray [1,1,1,1,1,1])
    }
}
