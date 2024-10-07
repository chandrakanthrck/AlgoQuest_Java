package kWayMerge;

import kWayMerge.Node;

import java.util.PriorityQueue;

public class KWayMerge {

    // Merge K sorted arrays using a min-heap
    public int[] mergeKSortedArrays(int[][] arrays) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> a.value - b.value);
        int totalElements = 0;

        // Add the first element of each array to the min-heap
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i].length > 0) {
                minHeap.add(new Node(arrays[i][0], i, 0));  // First element from each array
                totalElements += arrays[i].length;  // Count the total number of elements
            }
        }

        int[] result = new int[totalElements];
        int resultIndex = 0;

        // Extract the smallest element and add the next element from the same array
        while (!minHeap.isEmpty()) {
            Node node = minHeap.poll();  // Get the smallest element
            result[resultIndex++] = node.value;

            // Add the next element from the same array if it exists
            if (node.elementIndex + 1 < arrays[node.arrayIndex].length) {
                minHeap.add(new Node(arrays[node.arrayIndex][node.elementIndex + 1], node.arrayIndex, node.elementIndex + 1));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] arrays = {
                {1, 4, 7},
                {2, 5, 8},
                {3, 6, 9}
        };

        KWayMerge kWayMerge = new KWayMerge();
        int[] result = kWayMerge.mergeKSortedArrays(arrays);

        System.out.println("Merged Array: ");
        for (int val : result) {
            System.out.print(val + " ");  // Output: 1 2 3 4 5 6 7 8 9
        }
    }
}
