package doordash.graph;

import java.util.*;

public class MaximumPathQuality {
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        // Step 1: Build the graph as an adjacency list
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(new int[]{edge[1], edge[2]});
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(new int[]{edge[0], edge[2]});
        }

        // Step 2: Initialize variables
        boolean[] visited = new boolean[values.length];
        int[] maxQuality = new int[1]; // Single-element array to store maximum quality

        // Step 3: Perform DFS to find the maximum quality path
        dfs(graph, values, visited, 0, 0, 0, maxTime, maxQuality);

        return maxQuality[0];
    }

    private void dfs(Map<Integer, List<int[]>> graph, int[] values, boolean[] visited, int currentNode,
                     int currentTime, int currentQuality, int maxTime, int[] maxQuality) {
        // Step 4: Visit the current node
        if (!visited[currentNode]) {
            currentQuality += values[currentNode];
            visited[currentNode] = true;
        }

        // Step 5: Update the maximum quality if back at node 0
        if (currentNode == 0) {
            maxQuality[0] = Math.max(maxQuality[0], currentQuality);
        }

        // Step 6: Explore neighbors
        if (graph.containsKey(currentNode)) {
            for (int[] neighbor : graph.get(currentNode)) {
                int nextNode = neighbor[0];
                int travelTime = neighbor[1];

                if (currentTime + travelTime <= maxTime) {
                    dfs(graph, values, visited, nextNode, currentTime + travelTime, currentQuality, maxTime, maxQuality);
                }
            }
        }

        // Step 7: Backtrack
        if (visited[currentNode]) {
            visited[currentNode] = false;
        }
    }
}

