package doordash.heap;

import java.util.*;

public class SingleThreadedCPU {
    public int[] getOrder(int[][] tasks) {
        // Step 1: Add indices to tasks for stable sorting
        int n = tasks.length;
        int[][] indexedTasks = new int[n][3]; // {enqueueTime, processingTime, index}
        for (int i = 0; i < n; i++) {
            indexedTasks[i][0] = tasks[i][0];
            indexedTasks[i][1] = tasks[i][1];
            indexedTasks[i][2] = i;
        }

        // Step 2: Sort tasks by enqueueTime (and by index for stable sorting)
        Arrays.sort(indexedTasks, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 3: Priority Queue to process tasks
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) return Integer.compare(a[1], b[1]); // Sort by processingTime
            return Integer.compare(a[2], b[2]); // Sort by index if processingTime is equal
        });

        // Step 4: Simulate the CPU
        int[] result = new int[n];
        int resultIndex = 0;
        int currentTime = 0;
        int taskIndex = 0;

        while (resultIndex < n) {
            // Add all tasks that can be processed at the current time
            while (taskIndex < n && indexedTasks[taskIndex][0] <= currentTime) {
                pq.add(indexedTasks[taskIndex]);
                taskIndex++;
            }

            if (pq.isEmpty()) {
                // If no tasks are available, jump to the next task's enqueueTime
                currentTime = indexedTasks[taskIndex][0];
            } else {
                // Process the task with the shortest processing time (or smallest index)
                int[] task = pq.poll();
                result[resultIndex++] = task[2];
                currentTime += task[1];
            }
        }

        return result;
    }
}
