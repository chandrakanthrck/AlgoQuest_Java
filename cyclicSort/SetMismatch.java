package cyclicSort;

// Set Mismatch: Finding a set of numbers where one number is missing and one is duplicated
public class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        int[] result = new int[2];
        
        // Place each number in its correct index
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        
        // Find the mismatch
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                result[0] = nums[i];  // Duplicate number
                result[1] = i + 1;    // Missing number
                break;
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
        SetMismatch obj = new SetMismatch();
        int[] nums = {1, 2, 2, 4};
        int[] result = obj.findErrorNums(nums);
        System.out.println("Duplicate: " + result[0] + ", Missing: " + result[1]);  // Output: Duplicate: 2, Missing: 3
    }
}
