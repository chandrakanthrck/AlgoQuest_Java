package cyclicSort;

// Find the duplicate number in an array where only one number repeats
public class FindDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != i + 1) {
                if (nums[i] != nums[nums[i] - 1]) {
                    swap(nums, i, nums[i] - 1);
                } else {
                    return nums[i];
                }
            } else {
                i++;
            }
        }

        return -1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        FindDuplicateNumber obj = new FindDuplicateNumber();
        int[] nums = {1, 3, 4, 2, 2};
        System.out.println(obj.findDuplicate(nums));  // Output: 2
    }
}
