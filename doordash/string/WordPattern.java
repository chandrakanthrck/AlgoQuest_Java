package doordash.string;

import java.util.HashMap;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");

        // If lengths don't match, the pattern can't be followed
        if (pattern.length() != words.length) {
            return false;
        }

        HashMap<Character, String> charToWord = new HashMap<>();
        HashMap<String, Character> wordToChar = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];

            // Check char-to-word mapping
            if (charToWord.containsKey(c)) {
                if (!charToWord.get(c).equals(word)) {
                    return false; // Mismatch in mapping
                }
            } else {
                charToWord.put(c, word);
            }

            // Check word-to-char mapping
            if (wordToChar.containsKey(word)) {
                if (wordToChar.get(word) != c) {
                    return false; // Mismatch in mapping
                }
            } else {
                wordToChar.put(word, c);
            }
        }

        return true; // Pattern matches
    }

    public static void main(String[] args) {
        WordPattern solver = new WordPattern();

        System.out.println(solver.wordPattern("abba", "dog cat cat dog")); // Output: true
        System.out.println(solver.wordPattern("abba", "dog cat cat fish")); // Output: false
        System.out.println(solver.wordPattern("aaaa", "dog cat cat dog")); // Output: false
        System.out.println(solver.wordPattern("abba", "dog dog dog dog")); // Output: false
    }
}
