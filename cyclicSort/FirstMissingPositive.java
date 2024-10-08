package cyclicSort;

// First Missing Positive: Find the smallest positive integer missing from the array
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        
        // Place each number in its correct index if possible
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        
        // Find the first index where the number is not placed correctly
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        
        return n + 1;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        FirstMissingPositive obj = new FirstMissingPositive();
        int[] nums = {3, 4, -1, 1};
        System.out.println(obj.firstMissingPositive(nums));  // Output: 2
    }
}
