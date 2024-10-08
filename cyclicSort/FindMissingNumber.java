package cyclicSort;

// Find the missing number in an array of consecutive integers
public class FindMissingNumber {
    public int findMissingNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] < nums.length && nums[i] != nums[nums[i]]) {
                swap(nums, i, nums[i]);
            } else {
                i++;
            }
        }

        // Find the missing number
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }

        return nums.length;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        FindMissingNumber obj = new FindMissingNumber();
        int[] nums = {3, 0, 1};
        System.out.println(obj.findMissingNumber(nums));  // Output: 2
    }
}
