package doordash.binarySearch;

class LastPositionOfElement {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findPosition(nums, target, true);  // Find first position
        result[1] = findPosition(nums, target, false); // Find last position
        return result;
    }

    private int findPosition(int[] nums, int target, boolean findFirst) {
        int left = 0, right = nums.length - 1;
        int index = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                index = mid; // Record the current position
                if (findFirst) {
                    right = mid - 1; // Narrow the search to the left half
                } else {
                    left = mid + 1;  // Narrow the search to the right half
                }
            } else if (nums[mid] < target) {
                left = mid + 1; // Search in the right half
            } else {
                right = mid - 1; // Search in the left half
            }
        }

        return index;
    }
}

