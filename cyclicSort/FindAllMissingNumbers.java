package cyclicSort;

import java.util.ArrayList;
import java.util.List;

// Find All Missing Numbers: Find all missing numbers from the array in a specific range
public class FindAllMissingNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        
        // Place each number in its correct index
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        
        // Find all missing numbers
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                result.add(i + 1);
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
        FindAllMissingNumbers obj = new FindAllMissingNumbers();
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> result = obj.findDisappearedNumbers(nums);
        System.out.println(result);  // Output: [5, 6]
    }
}
