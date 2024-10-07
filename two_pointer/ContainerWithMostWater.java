package two_pointer;

/*
Problem Statement: You are given n non-negative integers representing the height of vertical lines on the x-axis.
Find two lines that together with the x-axis forms a container that holds the most water.

How to Approach
Use two pointers—one pointing at the beginning (left) and one at the end (right). Calculate the area,
and move the pointer corresponding to the smaller height inward.
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int maxArea = maxWater(heights);
        System.out.println("Maximum Area: " + maxArea);
    }
    public static int maxWater(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while(left < right){
            int currentHeight = Math.min(height[left], height[right]);
            int currentWidth = right - left;
            int area = currentHeight * currentWidth;
            maxArea = Math.max(maxArea, area);
            if(height[left] < height[right]){
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
