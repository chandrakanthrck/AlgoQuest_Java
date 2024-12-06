package doordash.arrays;

/**
 * Problem: Find the minimum element in a rotated sorted array.
 *
 * Approach:
 * - The array is sorted and then rotated, so it contains two sorted subarrays.
 * - Our goal is to find the pivot point where the rotation occurs, as the minimum element lies at the pivot.
 *
 * Key Observations:
 * 1. If the array is not rotated (e.g., [1, 2, 3, 4]), the first element is the smallest.
 * 2. If the array is rotated, the smallest element will be in the right subarray relative to the rotation point.
 *
 * Plan:
 * - Use a binary search approach to find the minimum element efficiently in O(log n) time.
 * - Compare the mid element with the rightmost element:
 *   a. If mid > right, the minimum is in the right half (rotation point lies there).
 *   b. Otherwise, the minimum is in the left half (including mid).
 * - Continue narrowing the range until left and right converge.
 *
 * Edge Cases:
 * - Single-element array.
 * - Array with no rotation (already sorted).
 * - Large array sizes to ensure efficiency.
 */

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        // Check for invalid input
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }

        // Initialize pointers for binary search
        int left = 0;
        int right = nums.length - 1;

        // If the array is not rotated, the first element is the minimum
        if (nums[left] < nums[right]) {
            return nums[left];
        }

        // Perform binary search to find the minimum element
        while (left < right) {
            // Calculate the mid-point of the current range
            int mid = left + (right - left) / 2;

            // If the middle element is greater than the rightmost element,
            // it means the smallest element must be in the right half.
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // Otherwise, the smallest element is in the left half,
                // including the current mid element.
                right = mid;
            }
        }

        // Left and right pointers converge to the minimum element
        return nums[left];
    }

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray solver = new FindMinimumInRotatedSortedArray();

        // Test case: rotated array
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("Minimum element: " + solver.findMin(nums)); // Output: 0
    }
}
