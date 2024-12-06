package doordash.twoPointers;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int nonZero = 0; // Pointer for the position of the next non-zero element

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // Swap nums[i] with nums[nonZero]
                int temp = nums[nonZero];
                nums[nonZero] = nums[i];
                nums[i] = temp;

                nonZero++;
            }
        }
    }
}
