package doordash.stack;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        // Iterate through all bars
        for (int i = 0; i <= heights.length; i++) {
            // Use 0 as a sentinel height at the end
            int currentHeight = (i == heights.length) ? 0 : heights[i];

            // Process bars in the stack when the current height is smaller
            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1; // Calculate width
                maxArea = Math.max(maxArea, height * width);
            }

            stack.push(i); // Push the current index
        }

        return maxArea;
    }
}

