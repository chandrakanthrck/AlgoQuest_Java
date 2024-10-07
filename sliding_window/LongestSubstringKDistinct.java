package sliding_window;

import java.util.HashMap;

/*
Problem Statement: Given a string, find the length of the longest substring that contains at most k distinct characters.

Approach:
The window size is dynamic. Expand the window by adding characters to it and contract the
window from the left if the number of distinct characters exceeds k.
 */
public class LongestSubstringKDistinct {
    public static int longestSubstringWithKDistinct(String s, int k) {
        int left = 0;
        int maxLength = 0;
        HashMap<Character, Integer> charFrequency = new HashMap<>();

        // Expand the window by moving the right pointer
        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            charFrequency.put(rightChar, charFrequency.getOrDefault(rightChar, 0) + 1);

            // Shrink the window if we have more than `k` distinct characters
            while (charFrequency.size() > k) {
                char leftChar = s.charAt(left);
                charFrequency.put(leftChar, charFrequency.get(leftChar) - 1);

                if (charFrequency.get(leftChar) == 0) {
                    charFrequency.remove(leftChar);
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s = "araaci";
        int k = 2;
        System.out.println(longestSubstringWithKDistinct(s, k));  // Output: 4 (substring "araa")
    }
}
