package twoPointer;

/**
 * Problem Statement: Given a sorted array, remove the duplicates in place such that each element appears only once
 * and return the new length.
 * How to Approach
 * Since the array is sorted, duplicate elements will be next to each other. You can use two pointers—one for
 * iterating (i) and one (j) to keep track of the position where the next unique element should be placed.
 *
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 4, 4, 5};
        int length = removeDuplicates(nums);
        System.out.println("New length: " + length);
        for (int i = 0; i < length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }
        return j + 1;
    }
}
