package two_heaps;

import java.util.PriorityQueue;

public class KthLargestElement {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();  // Remove the smallest element in the heap
            }
        }

        return minHeap.peek();  // The top of the heap is the Kth largest element
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;

        KthLargestElement solution = new KthLargestElement();
        System.out.println("Kth largest element: " + solution.findKthLargest(nums, k));  // Output: 5
    }
}
