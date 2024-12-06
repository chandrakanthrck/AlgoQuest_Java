package doordash.binarySearch;

public class FindMinimumInRotatedSortedArrayII {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < nums[right]) {
                // Minimum is in the left half (including mid)
                right = mid;
            } else if (nums[mid] > nums[right]) {
                // Minimum is in the right half (excluding mid)
                left = mid + 1;
            } else {
                // nums[mid] == nums[right], cannot determine, shrink right
                right--;
            }
        }

        return nums[left]; // Left points to the minimum element
    }

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArrayII solver = new FindMinimumInRotatedSortedArrayII();

        // Example 1
        int[] nums1 = {1, 3, 5};
        System.out.println("Minimum: " + solver.findMin(nums1)); // Output: 1

        // Example 2
        int[] nums2 = {2, 2, 2, 0, 1};
        System.out.println("Minimum: " + solver.findMin(nums2)); // Output: 0
    }
}

