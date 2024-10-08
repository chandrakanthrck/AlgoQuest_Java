package topKElementsHeaps;

import java.util.PriorityQueue;

public class KthLargestElementInStream {
    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargestElementInStream(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>(k);
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (minHeap.size() < k) {
            minHeap.offer(val);
        } else if (val > minHeap.peek()) {
            minHeap.poll();
            minHeap.offer(val);
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 8, 2};
        KthLargestElementInStream obj = new KthLargestElementInStream(3, nums);
        System.out.println(obj.add(3));  // Output: 4
        System.out.println(obj.add(5));  // Output: 5
        System.out.println(obj.add(10)); // Output: 5
        System.out.println(obj.add(9));  // Output: 8
        System.out.println(obj.add(4));  // Output: 8
    }
}
