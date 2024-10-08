package cyclicSort;

import java.util.ArrayList;
import java.util.List;

// Find all duplicates in an array
public class FindAllDuplicates {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            } else {
                i++;
            }
        }

        // Find duplicates
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                result.add(nums[i]);
            }
        }

        return result;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        FindAllDuplicates obj = new FindAllDuplicates();
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(obj.findDuplicates(nums));  // Output: [2, 3]
    }
}
