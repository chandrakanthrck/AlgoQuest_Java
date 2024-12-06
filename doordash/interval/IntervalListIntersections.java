package doordash.interval;

import java.util.*;

public class IntervalListIntersections {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < firstList.length && j < secondList.length) {
            // Find the intersection
            int start = Math.max(firstList[i][0], secondList[j][0]);
            int end = Math.min(firstList[i][1], secondList[j][1]);

            // If the intersection is valid, add it to the result
            if (start <= end) {
                result.add(new int[]{start, end});
            }

            // Move the pointer for the interval that ends first
            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }

        // Convert result to array
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        IntervalListIntersections solution = new IntervalListIntersections();

        int[][] firstList1 = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
        int[][] secondList1 = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};
        System.out.println(Arrays.deepToString(solution.intervalIntersection(firstList1, secondList1)));
        // Output: [[1, 2], [5, 5], [8, 10], [15, 23], [24, 24], [25, 25]]

        int[][] firstList2 = {{1, 3}, {5, 9}};
        int[][] secondList2 = {};
        System.out.println(Arrays.deepToString(solution.intervalIntersection(firstList2, secondList2)));
        // Output: []
    }
}
