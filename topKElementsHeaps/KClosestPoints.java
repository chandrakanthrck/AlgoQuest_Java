package topKElementsHeaps;

import java.util.PriorityQueue;

public class KClosestPoints {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> distance(b) - distance(a));

        for (int[] point : points) {
            maxHeap.add(point);
            if (maxHeap.size() > K) {
                maxHeap.poll();
            }
        }

        int[][] result = new int[K][2];
        for (int i = 0; i < K; i++) {
            result[i] = maxHeap.poll();
        }

        return result;
    }

    private int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];  // Squared distance from origin
    }

    public static void main(String[] args) {
        KClosestPoints obj = new KClosestPoints();
        int[][] points = {{1, 3}, {-2, 2}, {5, 8}, {0, 1}};
        int[][] result = obj.kClosest(points, 2);
        for (int[] point : result) {
            System.out.println(point[0] + ", " + point[1]);  // Output: [-2, 2] [0, 1]
        }
    }
}
