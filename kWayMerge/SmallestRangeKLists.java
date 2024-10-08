package kWayMerge;

import java.util.PriorityQueue;
import java.util.List;

public class SmallestRangeKLists {

    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> a.value - b.value);

        int max = Integer.MIN_VALUE;
        int rangeStart = 0;
        int rangeEnd = Integer.MAX_VALUE;

        // Add the first element of each list to the heap
        for (int i = 0; i < nums.size(); i++) {
            minHeap.add(new Node(nums.get(i).get(0), i, 0));
            max = Math.max(max, nums.get(i).get(0));
        }

        // Process the heap to find the smallest range
        while (minHeap.size() == nums.size()) {
            Node node = minHeap.poll();
            int min = node.value;

            if (max - min < rangeEnd - rangeStart) {
                rangeStart = min;
                rangeEnd = max;
            }

            // Add the next element from the same list
            if (node.elementIndex + 1 < nums.get(node.arrayIndex).size()) {
                int nextVal = nums.get(node.arrayIndex).get(node.elementIndex + 1);
                minHeap.add(new Node(nextVal, node.arrayIndex, node.elementIndex + 1));
                max = Math.max(max, nextVal);
            }
        }

        return new int[]{rangeStart, rangeEnd};
    }
}
