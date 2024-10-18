package walmart;

import java.util.*;

public class DegreeOfArray {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> first = new HashMap<>();
        int degree = 0, minLength = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            first.putIfAbsent(nums[i], i);
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
            degree = Math.max(degree, count.get(nums[i]));
        }

        for (int num : nums) {
            if (count.get(num) == degree) {
                minLength = Math.min(minLength, nums.length - first.get(num) - 1);
            }
        }

        return minLength + 1;
    }
}
