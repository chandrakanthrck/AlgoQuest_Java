package doordash.arrays;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int n = nums.length;
        k = k % n; // Handle cases where k > n

        // Step 1: Reverse the entire array
        reverse(nums, 0, n - 1);

        // Step 2: Reverse the first k elements
        reverse(nums, 0, k - 1);

        // Step 3: Reverse the remaining n-k elements
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        RotateArray solver = new RotateArray();

        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        solver.rotate(nums, k);

        // Output the rotated array
        System.out.print("Rotated array: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        // Output: Rotated array: 5 6 7 1 2 3 4
    }
}

