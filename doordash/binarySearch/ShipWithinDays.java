package doordash.binarySearch;

public class ShipWithinDays {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0, right = 0;

        // Calculate the bounds for binary search
        for (int weight : weights) {
            left = Math.max(left, weight); // The heaviest package
            right += weight;              // Sum of all weights
        }

        // Binary search for the minimum capacity
        while (left < right) {
            int mid = left + (right - left) / 2;

            // If the current capacity can ship within days, search for a smaller capacity
            if (canShip(weights, days, mid)) {
                right = mid;
            } else {
                left = mid + 1; // Increase the capacity
            }
        }

        return left;
    }

    // Helper function to check if we can ship within days using a given capacity
    private boolean canShip(int[] weights, int days, int capacity) {
        int currentLoad = 0;
        int dayCount = 1;

        for (int weight : weights) {
            if (currentLoad + weight > capacity) {
                dayCount++;
                currentLoad = 0;
            }

            currentLoad += weight;

            // If we exceed the number of days, return false
            if (dayCount > days) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ShipWithinDays solution = new ShipWithinDays();
        System.out.println(solution.shipWithinDays(new int[]{1,2,3,4,5,6,7,8,9,10}, 5)); // Output: 15
        System.out.println(solution.shipWithinDays(new int[]{3,2,2,4,1,4}, 3));          // Output: 6
        System.out.println(solution.shipWithinDays(new int[]{1,2,3,1,1}, 4));            // Output: 3
    }
}

