package walmart;

/*
This program solves the **Trapping Rain Water** problem using the **Two Pointers** approach.

### Problem Statement:
- Given an array `height[]` of non-negative integers representing the elevation map where the width of each bar is 1, compute how much water can be trapped after raining.
- The water is trapped between two bars if the current bar is shorter than the bars to the left and right of it.

### Approach: Two Pointers

1. **Two Pointers Setup:**
   - Use two pointers `left` and `right`, starting from the two ends of the array.
   - Maintain two variables, `leftMax` and `rightMax`, which represent the maximum height of the bars from the left and right respectively.

2. **Core Idea:**
   - Move the pointer that has the smaller height. The logic is that water trapped at any index is determined by the smaller boundary (left or right), as water can only be trapped up to the height of the shorter boundary.
   - If the current height at the left pointer is smaller than the right pointer, move the left pointer inward and update the `leftMax` and calculate trapped water based on this.
   - Similarly, if the current height at the right pointer is smaller or equal, move the right pointer inward and update `rightMax`.

3. **Calculating Trapped Water:**
   - At each step, if the current height is less than the `leftMax` or `rightMax`, the difference between `leftMax`/`rightMax` and the current height is the amount of water that can be trapped at that position.

4. **Time Complexity:**
   - The time complexity is **O(N)** where N is the length of the array. We traverse the array once using the two pointers.

5. **Space Complexity:**
   - The space complexity is **O(1)** because we are using only a constant amount of extra space for the variables `left`, `right`, `leftMax`, and `rightMax`.

### Example:
For the input:
   height = [0,1,0,2,1,0,1,3,2,1,2,1]

The algorithm returns 6, because 6 units of water can be trapped between the bars.

### Code:
*/

public class TrappingRainWater {

    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;

        int left = 0, right = height.length - 1;  // Two pointers starting at the ends
        int leftMax = 0, rightMax = 0;  // Track the maximum height from the left and right
        int waterTrapped = 0;  // Store the total water trapped

        // Process the array until the two pointers meet
        while (left < right) {
            if (height[left] < height[right]) {
                // If height[left] is smaller, process the left side
                if (height[left] >= leftMax) {
                    leftMax = height[left];  // Update leftMax
                } else {
                    waterTrapped += leftMax - height[left];  // Water trapped at this position
                }
                left++;  // Move the left pointer inward
            } else {
                // If height[right] is smaller or equal, process the right side
                if (height[right] >= rightMax) {
                    rightMax = height[right];  // Update rightMax
                } else {
                    waterTrapped += rightMax - height[right];  // Water trapped at this position
                }
                right--;  // Move the right pointer inward
            }
        }

        return waterTrapped;
    }

    public static void main(String[] args) {
        TrappingRainWater trw = new TrappingRainWater();

        // Example input
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};

        // Expected output: 6
        System.out.println("Water trapped: " + trw.trap(height));
    }
}
