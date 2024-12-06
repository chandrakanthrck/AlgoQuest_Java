package doordash.binarySearch;

/*
The Koko Eating Bananas problem is a classic example of using binary search to minimize the value of
k (bananas per hour) while ensuring that Koko can eat all the bananas within the given time limit h.

Problem Breakdown
Koko has n piles of bananas, and she can eat k bananas per hour.
If a pile has fewer than k bananas, she finishes the pile and does not eat any more during that hour.
We are asked to find the minimum value of k such that Koko can finish all the bananas within h hours.
Approach
The key observation is that for any given speed k, we can compute how many hours it will take for Koko to finish all
the piles of bananas. If the time it takes is less than or equal to h, then k is a feasible solution, and we may try
a smaller k. If the time exceeds h, we need to try a larger k.

To efficiently find the smallest valid k, we use binary search. Here's how it works:

Lower Bound (low): The smallest possible speed is 1 (i.e., Koko eats 1 banana per hour).
Upper Bound (high): The largest possible speed is the size of the largest pile because Koko could eat the entire
largest pile in 1 hour.
Binary Search: We repeatedly check the middle point of the current range (mid), calculate the time it would take with
that mid as the speed, and adjust the bounds based on whether the time is too long or too short.
Steps:
Binary Search:

Set low = 1 and high = max(piles).
While low <= high:
Compute the middle value mid = (low + high) / 2.
Compute the total hours it will take to eat all bananas if Koko eats mid bananas per hour.
If the total time is less than or equal to h, then it's feasible, and we may try a smaller k (high = mid - 1).
If the total time is greater than h, we need a larger k (low = mid + 1).
Time Calculation:

For each pile piles[i], calculate how many hours it will take if Koko eats mid bananas per hour. This is given
by ceil(piles[i] / mid), which is equivalent to (piles[i] + mid - 1) / mid.
 */
public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;

        // Find the maximum number of bananas in any pile
        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        // Binary search for the minimum k (speed)
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (canFinish(piles, mid, h)) {
                high = mid;  // Try smaller speeds
            } else {
                low = mid + 1;  // Increase the speed
            }
        }

        return low;
    }

    // Helper method to check if Koko can finish eating within h hours at speed k
    private boolean canFinish(int[] piles, int k, int h) {
        int hours = 0;
        for (int pile : piles) {
            hours += (pile + k - 1) / k;  // This is equivalent to Math.ceil(pile / k)
        }
        return hours <= h;
    }
}

