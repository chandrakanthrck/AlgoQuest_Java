package doordash.slidingWindow;

import java.util.*;

public class FindAllAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() < p.length()) return result;

        // Frequency arrays for characters in 'p' and current window in 's'
        int[] freqP = new int[26];
        int[] freqS = new int[26];

        // Fill frequency array for 'p'
        for (char c : p.toCharArray()) {
            freqP[c - 'a']++;
        }

        // Traverse 's' with a sliding window
        for (int i = 0; i < s.length(); i++) {
            // Add the current character to the window
            freqS[s.charAt(i) - 'a']++;

            // Remove the character that is sliding out of the window
            if (i >= p.length()) {
                freqS[s.charAt(i - p.length()) - 'a']--;
            }

            // Compare the frequency arrays
            if (Arrays.equals(freqP, freqS)) {
                result.add(i - p.length() + 1);
            }
        }

        return result;
    }
}

