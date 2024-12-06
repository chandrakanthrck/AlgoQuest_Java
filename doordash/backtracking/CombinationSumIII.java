package doordash.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), k, n, 1);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> combination, int k, int n, int start) {
        // Base case: if combination size equals k and the sum equals n
        if (combination.size() == k && n == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }

        // Explore numbers from 'start' to 9
        for (int i = start; i <= 9; i++) {
            if (i > n) break; // Early termination if current number exceeds remaining target

            // Add the current number to the combination
            combination.add(i);
            // Recur with updated parameters
            backtrack(result, combination, k, n - i, i + 1);
            // Backtrack
            combination.remove(combination.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSumIII solver = new CombinationSumIII();

        // Example 1
        System.out.println("Combinations for k=3, n=7: " + solver.combinationSum3(3, 7));
        // Output: [[1, 2, 4]]

        // Example 2
        System.out.println("Combinations for k=3, n=9: " + solver.combinationSum3(3, 9));
        // Output: [[1, 2, 6], [1, 3, 5], [2, 3, 4]]
    }
}

