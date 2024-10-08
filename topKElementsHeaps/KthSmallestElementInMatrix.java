package topKElementsHeaps;

import java.util.PriorityQueue;

public class KthSmallestElementInMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int i = 0; i < matrix.length; i++) {
            minHeap.offer(new int[]{matrix[i][0], i, 0});
        }

        int number = 0;
        for (int i = 0; i < k; i++) {
            int[] curr = minHeap.poll();
            number = curr[0];
            int row = curr[1];
            int col = curr[2];

            if (col + 1 < matrix[0].length) {
                minHeap.offer(new int[]{matrix[row][col + 1], row, col + 1});
            }
        }

        return number;
    }

    public static void main(String[] args) {
        KthSmallestElementInMatrix obj = new KthSmallestElementInMatrix();
        int[][] matrix = {
            {1, 5, 9},
            {10, 11, 13},
            {12, 13, 15}
        };
        System.out.println(obj.kthSmallest(matrix, 8));  // Output: 13
    }
}
