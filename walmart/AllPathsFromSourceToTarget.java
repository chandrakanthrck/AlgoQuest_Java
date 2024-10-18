package walmart;

import java.util.*;

public class AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(graph, 0, result, path);
        return result;
    }

    private void dfs(int[][] graph, int node, List<List<Integer>> result, List<Integer> path) {
        if (node == graph.length - 1) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int next : graph[node]) {
            path.add(next);
            dfs(graph, next, result, path);
            path.remove(path.size() - 1);
        }
    }
}
