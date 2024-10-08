package topKElementsHeaps;

import java.util.PriorityQueue;

// Find the Kth largest element in an array
public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
    
    public static void main(String[] args) {
        KthLargestElement obj = new KthLargestElement();
        int[] nums = {3, 2, 1, 5, 6, 4};
        System.out.println(obj.findKthLargest(nums, 2));  // Output: 5
    }
}
