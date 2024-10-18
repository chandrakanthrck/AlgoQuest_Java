package walmart;

import java.util.*;

public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return new ArrayList<>();

        String[] mapping = new String[] {
                "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        List<String> result = new ArrayList<>();
        backtrack(result, digits, "", 0, mapping);
        return result;
    }

    private void backtrack(List<String> result, String digits, String current, int index, String[] mapping) {
        if (index == digits.length()) {
            result.add(current);
            return;
        }
        String letters = mapping[digits.charAt(index) - '0'];
        for (char letter : letters.toCharArray()) {
            backtrack(result, digits, current + letter, index + 1, mapping);
        }
    }
}
