package doordash.stack;

import java.util.*;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // Handle edge case where the input array is empty
        if (nums == null || nums.length == 0) return new int[0];

        // Result array to store the maximum of each sliding window
        int[] result = new int[nums.length - k + 1];

        // Deque to store indices of elements in the current window
        // The deque will store indices in a way that the front holds the max element's index
        Deque<Integer> deque = new LinkedList<>();

        // Traverse through the array
        for (int i = 0; i < nums.length; i++) {
            // Remove indices that are out of the current window
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst(); // Remove from the front of the deque
            }

            // Remove smaller elements from the back of the deque
            // Since they can't be the maximum when a larger element is present
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast(); // Remove from the back of the deque
            }

            // Add the current index to the deque
            deque.offerLast(i);

            // If the window has reached size k, record the maximum element
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()]; // Front of deque is the max element
            }
        }

        return result;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum solver = new SlidingWindowMaximum();

        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = solver.maxSlidingWindow(nums, k);

        System.out.println("Sliding Window Maximum: " + Arrays.toString(result));
        // Output: [3, 3, 5, 5, 6, 7]
    }
}
