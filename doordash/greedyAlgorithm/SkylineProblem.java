package doordash.greedyAlgorithm;

import java.util.*;

public class SkylineProblem {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();
        List<int[]> events = new ArrayList<>();

        // Step 1: Convert buildings to events
        for (int[] building : buildings) {
            events.add(new int[]{building[0], -building[2]}); // Start of a building
            events.add(new int[]{building[1], building[2]});  // End of a building
        }

        // Step 2: Sort events
        events.sort((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0]; // Sort by x-coordinate
            return a[1] - b[1];                  // Sort by height
        });

        // Max heap to keep track of current building heights
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(0); // Ground level

        int prevMaxHeight = 0;

        // Step 3: Process events
        for (int[] event : events) {
            int x = event[0];
            int h = event[1];

            if (h < 0) {
                maxHeap.add(-h); // Add building height (start point)
            } else {
                maxHeap.remove(h); // Remove building height (end point)
            }

            int currentMaxHeight = maxHeap.peek();
            if (currentMaxHeight != prevMaxHeight) {
                // If the max height changes, add a critical point
                result.add(Arrays.asList(x, currentMaxHeight));
                prevMaxHeight = currentMaxHeight;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        SkylineProblem solver = new SkylineProblem();

        int[][] buildings = {
                {2, 9, 10},
                {3, 7, 15},
                {5, 12, 12},
                {15, 20, 10},
                {19, 24, 8}
        };

        List<List<Integer>> skyline = solver.getSkyline(buildings);
        System.out.println("Skyline: " + skyline);
    }
}

