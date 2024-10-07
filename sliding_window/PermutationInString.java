package sliding_window;

import java.util.HashMap;

/*
Problem Statement: Given two strings s1 and s2, return true if s2 contains a permutation of s1.

Approach:
Use a fixed-size window that matches the size of s1. Check if the current window in s2 contains
all characters from s1 (i.e., it’s a permutation).

 */
public class PermutationInString {
    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        HashMap<Character, Integer> s1Map = new HashMap<>();
        for (char c : s1.toCharArray()) {
            s1Map.put(c, s1Map.getOrDefault(c, 0) + 1);
        }

        HashMap<Character, Integer> s2Map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c = s2.charAt(i);
            s2Map.put(c, s2Map.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        for (int right = s1.length(); right < s2.length(); right++) {
            if (s1Map.equals(s2Map)) return true;

            // Add the new character to the window
            char newChar = s2.charAt(right);
            s2Map.put(newChar, s2Map.getOrDefault(newChar, 0) + 1);

            // Remove the leftmost character from the window
            char oldChar = s2.charAt(left);
            if (s2Map.get(oldChar) == 1) {
                s2Map.remove(oldChar);
            } else {
                s2Map.put(oldChar, s2Map.get(oldChar) - 1);
            }
            left++;
        }

        return s1Map.equals(s2Map);
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo"));  // Output: true
        System.out.println(checkInclusion("ab", "eidboaoo"));  // Output: false
    }
}
