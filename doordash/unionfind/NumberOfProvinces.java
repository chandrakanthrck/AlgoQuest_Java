package doordash.unionfind;

public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        // Step 1: Initialize Union-Find structures
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // Step 2: Union cities that are directly connected
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    union(parent, i, j);
                }
            }
        }

        // Step 3: Count unique roots (provinces)
        int provinces = 0;
        for (int i = 0; i < n; i++) {
            if (find(parent, i) == i) {
                provinces++;
            }
        }

        return provinces;
    }

    // Find function with path compression
    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]); // Path compression
        }
        return parent[x];
    }

    // Union function to connect two components
    private void union(int[] parent, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);
        if (rootX != rootY) {
            parent[rootX] = rootY; // Union the two components
        }
    }
}

