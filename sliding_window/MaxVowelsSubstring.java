package sliding_window;

/*Problem Statement: Given a string and a number k, find the maximum number of vowels in any substring of length k.

Approach:
The window size is fixed (size k). Use the sliding window to count the number of vowels in the first k characters,
then slide the window and update the count.
 */
public class MaxVowelsSubstring {
    public static int maxVowels(String s, int k) {
        int maxVowels = 0, currentVowels = 0;

        // Check the first window of size `k`
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                currentVowels++;
            }
        }
        maxVowels = currentVowels;

        // Slide the window across the string
        for (int i = k; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                currentVowels++;
            }
            if (isVowel(s.charAt(i - k))) {
                currentVowels--;
            }
            maxVowels = Math.max(maxVowels, currentVowels);
        }

        return maxVowels;
    }

    private static boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }

    public static void main(String[] args) {
        String s = "abciiidef";
        int k = 3;
        System.out.println(maxVowels(s, k));  // Output: 3 (substring "iii")
    }
}
