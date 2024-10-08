package topKElementsHeaps;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;

// Find the top K frequent elements in an array
public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        // Count the frequency of each element
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        
        // Use a min-heap to find the top K frequent elements
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            heap.add(entry);
            if (heap.size() > k) heap.poll();  // Remove the least frequent element
        }
        
        // Build the result
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = heap.poll().getKey();
        }
        return result;
    }
    
    public static void main(String[] args) {
        TopKFrequentElements obj = new TopKFrequentElements();
        int[] nums = {1, 1, 1, 2, 2, 3};
        int[] result = obj.topKFrequent(nums, 2);
        for (int num : result) {
            System.out.print(num + " ");  // Output: 1 2
        }
    }
}
