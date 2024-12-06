package doordash.backtracking;

import java.util.*;

public class DifferentWaysToAddParentheses {
    public List<Integer> diffWaysToCompute(String expression) {
        Map<String, List<Integer>> memo = new HashMap<>();
        return compute(expression, memo);
    }

    private List<Integer> compute(String expression, Map<String, List<Integer>> memo) {
        // If the result for this expression is already computed, return it
        if (memo.containsKey(expression)) {
            return memo.get(expression);
        }

        List<Integer> result = new ArrayList<>();
        boolean isSingleNumber = true;

        // Split the expression at each operator
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*') {
                isSingleNumber = false;

                // Divide into left and right subexpressions
                String left = expression.substring(0, i);
                String right = expression.substring(i + 1);

                // Recursively compute the results for the left and right parts
                List<Integer> leftResults = compute(left, memo);
                List<Integer> rightResults = compute(right, memo);

                // Combine the results from the left and right parts
                for (int l : leftResults) {
                    for (int r : rightResults) {
                        if (ch == '+') {
                            result.add(l + r);
                        } else if (ch == '-') {
                            result.add(l - r);
                        } else if (ch == '*') {
                            result.add(l * r);
                        }
                    }
                }
            }
        }

        // If the expression is a single number, add it to the result
        if (isSingleNumber) {
            result.add(Integer.parseInt(expression));
        }

        // Store the result in memo for future reference
        memo.put(expression, result);
        return result;
    }

    public static void main(String[] args) {
        DifferentWaysToAddParentheses solver = new DifferentWaysToAddParentheses();

        // Example 1
        String expression1 = "2-1-1";
        System.out.println("Results for '2-1-1': " + solver.diffWaysToCompute(expression1));
        // Output: [0, 2]

        // Example 2
        String expression2 = "2*3-4*5";
        System.out.println("Results for '2*3-4*5': " + solver.diffWaysToCompute(expression2));
        // Output: [-34, -14, -10, -10, 10]
    }
}

