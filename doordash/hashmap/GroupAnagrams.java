package doordash.hashmap;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            // Step 1: Sort the string to use as a key
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            // Step 2: Add the string to the corresponding group
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        // Step 3: Return all groups
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        GroupAnagrams solution = new GroupAnagrams();

        String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(solution.groupAnagrams(strs1));
        // Output: [["bat"], ["nat", "tan"], ["ate", "eat", "tea"]]

        String[] strs2 = {""};
        System.out.println(solution.groupAnagrams(strs2));
        // Output: [[""]]

        String[] strs3 = {"a"};
        System.out.println(solution.groupAnagrams(strs3));
        // Output: [["a"]]
    }
}

