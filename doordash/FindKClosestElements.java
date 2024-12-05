package doordash;

import java.util.ArrayList;
import java.util.List;

/*
Find K Closest Elements
Medium
Topics
Companies
Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array.
The result should also be sorted in ascending order.
An integer a is closer to x than an integer b if:
|a - x| < |b - x|, or
|a - x| == |b - x| and a < b
 Example 1:
Input: arr = [1,2,3,4,5], k = 4, x = 3
Output: [1,2,3,4]
Example 2:
Input: arr = [1,1,2,3,4,5], k = 4, x = -1
Output: [1,1,2,3]

Constraints:
1 <= k <= arr.length
1 <= arr.length <= 104
arr is sorted in ascending order.
-104 <= arr[i], x <= 104
Explanation:
As it is a sorted array, we need to use binary search. Instead of finding the closest floor value and expanding outward,
 we find the starting index of the window of size k that contains the k closest elements.
Initialize the range of the left boundary:
Start with left = 0 and right = arr.length - k.
This ensures that the window of size k stays within bounds.
Binary search for the leftmost position:
Calculate the middle index mid = left + (right - left) / 2.
Compare the distances of arr[mid] and arr[mid + k] to x:
If arr[mid] is farther from x than arr[mid + k], move the left boundary (left = mid + 1).
Otherwise, move the right boundary (right = mid).
Stop when the left boundary is determined:

When left == right, the window of size k starts at index left.
Return the k elements from the starting position:

Slice the array starting from left to left + k.
 */
public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length-k; // The rightmost boundary for the left pointer
        while(left<right){
            int mid = left + (left + right)/2;
            // Compare the distances of arr[mid] and arr[mid + k] to x
            if(Math.abs(arr[mid] - x) > Math.abs(arr[mid+k] - k)){
                left = mid + 1; // Move the left boundary rightward
            }else{
                right = mid; // Keep the left boundary at mid or earlier
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = left; i < left + k; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}
