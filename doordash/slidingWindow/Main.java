package doordash.slidingWindow;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        FindAllAnagrams solver = new FindAllAnagrams();

        // Test case 1
        String s1 = "cbaebabacd";
        String p1 = "abc";
        List<Integer> result1 = solver.findAnagrams(s1, p1);
        System.out.println("Anagram start indices for s = \"cbaebabacd\" and p = \"abc\": " + result1);
        // Expected output: [0, 6]

        // Test case 2
        String s2 = "abab";
        String p2 = "ab";
        List<Integer> result2 = solver.findAnagrams(s2, p2);
        System.out.println("Anagram start indices for s = \"abab\" and p = \"ab\": " + result2);
        // Expected output: [0, 1, 2]

        // Test case 3 (No anagrams)
        String s3 = "abcdef";
        String p3 = "xyz";
        List<Integer> result3 = solver.findAnagrams(s3, p3);
        System.out.println("Anagram start indices for s = \"abcdef\" and p = \"xyz\": " + result3);
        // Expected output: []

        // Test case 4 (Edge case - p is empty)
        String s4 = "abcdef";
        String p4 = "";
        List<Integer> result4 = solver.findAnagrams(s4, p4);
        System.out.println("Anagram start indices for s = \"abcdef\" and p = \"\": " + result4);
        // Expected output: []

        // Test case 5 (Edge case - s is empty)
        String s5 = "";
        String p5 = "abc";
        List<Integer> result5 = solver.findAnagrams(s5, p5);
        System.out.println("Anagram start indices for s = \"\" and p = \"abc\": " + result5);
        // Expected output: []

        // Test case 6 (Both s and p are empty)
        String s6 = "";
        String p6 = "";
        List<Integer> result6 = solver.findAnagrams(s6, p6);
        System.out.println("Anagram start indices for s = \"\" and p = \"\": " + result6);
        // Expected output: []
    }
}

