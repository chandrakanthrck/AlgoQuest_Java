package topologySort;

import java.util.*;

public class TopologicalSort {

    // Perform Topological Sort using Kahn's Algorithm (BFS-based)
    public List<Integer> topologicalSort(int numCourses, int[][] prerequisites) {
        List<Integer> result = new ArrayList<>();
        int[] inDegree = new int[numCourses];  // To track the in-degree of each node
        Map<Integer, List<Integer>> graph = new HashMap<>();

        // Build the graph and initialize in-degrees
        for (int[] pre : prerequisites) {
            graph.putIfAbsent(pre[1], new ArrayList<>());
            graph.get(pre[1]).add(pre[0]);
            inDegree[pre[0]]++;
        }

        // Initialize the queue with nodes having zero in-degree (no prerequisites)
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) queue.add(i);
        }

        // Process nodes with zero in-degree
        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);

            // Decrease the in-degree of all neighbors
            if (graph.containsKey(node)) {
                for (int neighbor : graph.get(node)) {
                    inDegree[neighbor]--;
                    if (inDegree[neighbor] == 0) queue.add(neighbor);
                }
            }
        }

        // If result doesn't contain all courses, there is a cycle
        if (result.size() != numCourses) return new ArrayList<>();
        return result;
    }

    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 1}, {3, 2}};

        TopologicalSort ts = new TopologicalSort();
        List<Integer> result = ts.topologicalSort(numCourses, prerequisites);

        System.out.println("Topological Order: " + result);
    }
}
