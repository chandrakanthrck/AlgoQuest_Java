package topologySort;

import java.util.*;

public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<Integer> result = new ArrayList<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();

        // Build graph and calculate in-degrees
        for (int[] pre : prerequisites) {
            graph.putIfAbsent(pre[1], new ArrayList<>());
            graph.get(pre[1]).add(pre[0]);
            inDegree[pre[0]]++;
        }

        // Add all nodes with zero in-degree to the queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) queue.add(i);
        }

        // Perform BFS for topological sorting
        while (!queue.isEmpty()) {
            int course = queue.poll();
            result.add(course);

            if (graph.containsKey(course)) {
                for (int neighbor : graph.get(course)) {
                    inDegree[neighbor]--;
                    if (inDegree[neighbor] == 0) queue.add(neighbor);
                }
            }
        }

        // If there is a cycle, return an empty array
        if (result.size() != numCourses) return new int[0];

        // Convert result list to array
        return result.stream().mapToInt(i -> i).toArray();
    }
}
