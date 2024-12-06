package doordash.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: Find the length of the longest increasing subsequence (LIS) in an array.
 *
 * Approach:
 * - The goal is to efficiently calculate the LIS length in O(n log n) time.
 * - We use a **dynamic programming with binary search** approach:
 *   1. Maintain a list `sub` to represent the smallest end elements of increasing subsequences of different lengths.
 *   2. For each element in the input array:
 *      - Use binary search to find its position in `sub`.
 *      - If it's greater than all elements in `sub`, append it (extend the subsequence).
 *      - Otherwise, replace the first element in `sub` that is greater than or equal to it (optimize subsequence).
 *   3. The length of `sub` at the end gives the length of LIS.
 *
 * Key Observations:
 * - `sub` does not store the actual LIS, but helps us track its length.
 * - Binary search ensures that we handle each element in logarithmic time.
 *
 * Edge Cases:
 * - Empty input array.
 * - Arrays with all increasing or all decreasing elements.
 */

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        // Validate input to handle edge cases
        if (nums == null || nums.length == 0) return 0;

        // List to store the smallest end elements of increasing subsequences
        List<Integer> sub = new ArrayList<>();

        // Iterate through each number in the array
        for (int num : nums) {
            // Find the position to insert/replace the current number using binary search
            int pos = binarySearch(sub, num);

            if (pos == sub.size()) {
                // If the number is greater than all elements, extend the subsequence
                sub.add(num);
            } else {
                // Otherwise, replace the element at position `pos` to optimize
                sub.set(pos, num);
            }
        }

        // The size of `sub` represents the length of the LIS
        return sub.size();
    }

    /**
     * Binary search helper function to find the position to insert or replace an element.
     * @param sub - The current list of end elements of increasing subsequences.
     * @param target - The current number being processed.
     * @return The position in `sub` where `target` can be inserted or replaced.
     */
    private int binarySearch(List<Integer> sub, int target) {
        int left = 0, right = sub.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (sub.get(mid) < target) {
                left = mid + 1; // Move right if target is greater
            } else {
                right = mid - 1; // Move left if target is less than or equal
            }
        }

        return left; // Position to insert or replace
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence solver = new LongestIncreasingSubsequence();

        // Test case: General case with mixed increasing and decreasing numbers
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("Length of LIS: " + solver.lengthOfLIS(nums)); // Output: 4
    }
}
