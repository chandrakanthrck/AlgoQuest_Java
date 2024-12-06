package doordash.unionfind;

public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        // A tree must have exactly n-1 edges
        if (edges.length != n - 1) {
            return false;
        }

        // Initialize Union-Find
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i; // Each node is initially its own parent
        }

        // Union-Find to detect cycles
        for (int[] edge : edges) {
            int root1 = find(parent, edge[0]);
            int root2 = find(parent, edge[1]);

            // If two nodes share the same root, a cycle is detected
            if (root1 == root2) {
                return false;
            }

            // Union the two nodes
            parent[root1] = root2;
        }

        return true; // If no cycles and n-1 edges, it's a valid tree
    }

    private int find(int[] parent, int node) {
        if (parent[node] != node) {
            parent[node] = find(parent, parent[node]); // Path compression
        }
        return parent[node];
    }

    public static void main(String[] args) {
        GraphValidTree solver = new GraphValidTree();

        int n1 = 5;
        int[][] edges1 = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        System.out.println("Is valid tree: " + solver.validTree(n1, edges1)); // Output: true

        int n2 = 5;
        int[][] edges2 = {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
        System.out.println("Is valid tree: " + solver.validTree(n2, edges2)); // Output: false
    }
}

