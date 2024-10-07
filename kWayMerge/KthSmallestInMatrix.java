package kWayMerge;

import java.util.PriorityQueue;

public class KthSmallestInMatrix {

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> a.value - b.value);

        // Add the first element of each row to the heap
        for (int i = 0; i < matrix.length; i++) {
            minHeap.add(new Node(matrix[i][0], i, 0));
        }

        Node currentNode = null;

        // Extract the smallest element from the heap k times
        for (int i = 0; i < k; i++) {
            currentNode = minHeap.poll();

            // If there's another element in the same row, add it to the heap
            if (currentNode.col + 1 < matrix[0].length) {
                minHeap.add(new Node(matrix[currentNode.row][currentNode.col + 1], currentNode.row, currentNode.col + 1));
            }
        }

        return currentNode.value;
    }
}
