package doordash.binarySearch;

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[mid + 1]) {
                // Peak is on the left half
                right = mid;
            } else {
                // Peak is on the right half
                left = mid + 1;
            }
        }

        // Left and right converge to the peak element
        return left;
    }

    public static void main(String[] args) {
        FindPeakElement solver = new FindPeakElement();

        // Example 1
        int[] nums1 = {1, 2, 3, 1};
        System.out.println("Peak Index: " + solver.findPeakElement(nums1)); // Output: 2

        // Example 2
        int[] nums2 = {1, 2, 1, 3, 5, 6, 4};
        System.out.println("Peak Index: " + solver.findPeakElement(nums2)); // Output: 5 or 1
    }
}
