package walmart;

import java.util.*;

public class LongestFibonacciSubsequence {
    public int lenLongestFibSubseq(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) set.add(num);

        int maxLen = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int a = arr[i], b = arr[j];
                int length = 2;
                while (set.contains(a + b)) {
                    int next = a + b;
                    a = b;
                    b = next;
                    length++;
                }
                maxLen = Math.max(maxLen, length);
            }
        }

        return maxLen >= 3 ? maxLen : 0;
    }
}
