package doordash.binarySearch;

public class Search2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Start from the top-right corner
        int row = 0, col = cols - 1;

        while (row < rows && col >= 0) {
            if (matrix[row][col] == target) {
                return true; // Target found
            } else if (matrix[row][col] > target) {
                col--; // Move left
            } else {
                row++; // Move down
            }
        }

        return false; // Target not found
    }

    public static void main(String[] args) {
        Search2DMatrixII solver = new Search2DMatrixII();

        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        int target1 = 5;
        int target2 = 20;

        System.out.println("Search for 5: " + solver.searchMatrix(matrix, target1)); // Output: true
        System.out.println("Search for 20: " + solver.searchMatrix(matrix, target2)); // Output: false
    }
}

