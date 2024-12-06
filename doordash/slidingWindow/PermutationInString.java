package doordash.slidingWindow;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        // Frequency arrays for s1 and the current window in s2
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        // Fill freq1 with s1's frequencies
        for (char c : s1.toCharArray()) {
            freq1[c - 'a']++;
        }

        // Process the first window in s2
        for (int i = 0; i < s1.length(); i++) {
            freq2[s2.charAt(i) - 'a']++;
        }

        // Check if the first window matches
        if (matches(freq1, freq2)) return true;

        // Slide the window across s2
        for (int i = s1.length(); i < s2.length(); i++) {
            // Add the new character to the window
            freq2[s2.charAt(i) - 'a']++;
            // Remove the character that is sliding out
            freq2[s2.charAt(i - s1.length()) - 'a']--;
            // Check if the current window matches
            if (matches(freq1, freq2)) return true;
        }

        return false;
    }

    // Helper function to compare two frequency arrays
    private boolean matches(int[] freq1, int[] freq2) {
        for (int i = 0; i < 26; i++) {
            if (freq1[i] != freq2[i]) return false;
        }
        return true;
    }
}

