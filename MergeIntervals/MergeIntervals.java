
package MergeIntervals;

import java.util.*;

public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][0];
        
        // Sort intervals based on the starting time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> merged = new ArrayList<>();
        int[] currentInterval = intervals[0];
        merged.add(currentInterval);

        for (int[] interval : intervals) {
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            if (currentEnd >= nextStart) {
                // Merge overlapping intervals
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                // Add new interval
                currentInterval = interval;
                merged.add(currentInterval);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result = merge(intervals);
        for (int[] interval : result) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
