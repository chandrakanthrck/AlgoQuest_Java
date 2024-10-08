
package MergeIntervals;

import java.util.Arrays;

public class MinimumNumberOfPlatforms {

    public static int findPlatform(int[] arr, int[] dep) {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int platforms = 1, result = 1;
        int i = 1, j = 0;

        while (i < arr.length && j < arr.length) {
            if (arr[i] <= dep[j]) {
                platforms++;
                i++;
            } else {
                platforms--;
                j++;
            }
            result = Math.max(result, platforms);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {900, 940, 950, 1100, 1500, 1800};
        int[] dep = {910, 1200, 1120, 1130, 1900, 2000};
        System.out.println("Minimum Number of Platforms Required: " + findPlatform(arr, dep));
    }
}
