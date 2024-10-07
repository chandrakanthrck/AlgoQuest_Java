package sliding_window;

/*
Problem Statement: Given an array of integers and a number k, find the maximum sum of a subarray of size k.

Approach:
The window size is fixed (size k).
Start with the sum of the first k elements, then slide the window by one position at a time, adding the new element
that comes into the window and removing the old element that goes out.
 */
public class MaxSumSubarray {
    public static int maxSumSubarray(int[] nums, int k) {
        int maxSum = 0, windowSum = 0;

        // Calculate the sum of the first window
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        maxSum = windowSum;

        // Slide the window, adjusting the sum
        for (int i = k; i < nums.length; i++) {
            windowSum += nums[i] - nums[i - k];  // Slide window by adding new and removing old
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println(maxSumSubarray(nums, k));  // Output: 9 (5 + 1 + 3)
    }
}
