package doordash.greedyAlgorithm;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        // Step 1: Convert the integers to strings
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }

        // Step 2: Sort the strings using a custom comparator
        Arrays.sort(strNums, (a, b) -> (b + a).compareTo(a + b));

        // Step 3: Handle the edge case where the largest number is "0"
        if (strNums[0].equals("0")) {
            return "0";
        }

        // Step 4: Build the largest number by concatenating the strings
        StringBuilder largestNumber = new StringBuilder();
        for (String num : strNums) {
            largestNumber.append(num);
        }

        return largestNumber.toString();
    }

    public static void main(String[] args) {
        LargestNumber solver = new LargestNumber();

        int[] nums1 = {10, 2};
        System.out.println("Largest Number: " + solver.largestNumber(nums1)); // Output: "210"

        int[] nums2 = {3, 30, 34, 5, 9};
        System.out.println("Largest Number: " + solver.largestNumber(nums2)); // Output: "9534330"

        int[] nums3 = {0, 0};
        System.out.println("Largest Number: " + solver.largestNumber(nums3)); // Output: "0"
    }
}

