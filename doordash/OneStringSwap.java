package doordash;

import java.util.ArrayList;
import java.util.List;

/*
Check if One String Swap Can Make Strings Equal
You are given two strings s1 and s2 of equal length. A string swap is an operation where you choose two indices in a
string (not necessarily different) and swap the characters at these indices.
Return true if it is possible to make both strings equal by performing at most one string swap on exactly one of the
strings. Otherwise, return false.
Example 1:
Input: s1 = "bank", s2 = "kanb"
Output: true
Explanation: For example, swap the first character with the last character of s2 to make "bank".
Example 2:
Input: s1 = "attack", s2 = "defend"
Output: false
Explanation: It is impossible to make them equal with one string swap.
Example 3:
Input: s1 = "kelb", s2 = "kelb"
Output: true
Explanation: The two strings are already equal, so no string swap operation is required.
Constraints:
1 <= s1.length, s2.length <= 100
s1.length == s2.length
s1 and s2 consist of only lowercase English letters.
Explanation:
Approach
Basic Check:

If s1 and s2 are already equal, return true (no swap is needed).
Find Differences:

Traverse both strings and record the indices where s1[i] is not equal to s2[i].
Evaluate Differences:

If there are more than 2 differences, return false (one swap can't fix more than two mismatched positions).
If there are exactly 2 differences:
Check if swapping the characters at these positions in one string makes the strings equal.
If there is exactly 1 or no difference, return false.
Algorithm
Traverse s1 and s2 to identify indices where characters differ.
If the count of differences is:
0: The strings are already equal (true).
2: Ensure swapping resolves the mismatch.
Any other count: Return false.
Return the result based on the evaluation.

 */
public class OneStringSwap {
    public boolean areAlmostEqual(String s1, String s2) {
        // If strings are already equal, return true
        if (s1.equals(s2)) return true;

        // Store the indices where characters differ
        List<Integer> diffIndices = new ArrayList<>();

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diffIndices.add(i);
            }
        }

        // Check the number of differences
        if (diffIndices.size() == 2) {
            // Get the indices of the differences
            int i = diffIndices.get(0);
            int j = diffIndices.get(1);

            // Check if swapping makes the strings equal
            return s1.charAt(i) == s2.charAt(j) && s1.charAt(j) == s2.charAt(i);
        }

        // If there are no differences or more than two, return false
        return false;
    }
}

