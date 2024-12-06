package doordash.string;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        // Frequency array for 26 lowercase letters
        int[] charCounts = new int[26];

        // Count characters in 's'
        for (char c : s.toCharArray()) {
            charCounts[c - 'a']++;
        }

        // Subtract character counts for 't'
        for (char c : t.toCharArray()) {
            charCounts[c - 'a']--;
        }

        // Check if all counts are zero
        for (int count : charCounts) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ValidAnagram solver = new ValidAnagram();

        System.out.println("Is anagram (\"anagram\", \"nagaram\"): " + solver.isAnagram("anagram", "nagaram")); // Output: true
        System.out.println("Is anagram (\"rat\", \"car\"): " + solver.isAnagram("rat", "car")); // Output: false
    }
}
