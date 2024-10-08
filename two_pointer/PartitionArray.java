package two_pointer;

public class PartitionArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        partitionArray(nums);

        System.out.print("Reordered Array: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public static void partitionArray(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            while (left < right && nums[left] % 2 != 0) {
                left++;
            }
            while (left < right && nums[right] % 2 != 0) {
                right++;
            }
        }
        if (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
    }
}

