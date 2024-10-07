package two_heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class SlidingWindowMedian {

    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            // Add the current number to the heaps
            addNum(nums[i]);

            // Remove the element that is out of the window
            if (i >= k) {
                removeNum(nums[i - k]);
            }

            // Calculate the median for the current window
            if (i >= k - 1) {
                result[i - k + 1] = findMedian();
            }
        }

        return result;
    }

    private void addNum(int num) {
        maxHeap.add(num);
        minHeap.add(maxHeap.poll());
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    private void removeNum(int num) {
        // Logic to remove the number from the correct heap and rebalance the heaps
    }

    private double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } else {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }
}
