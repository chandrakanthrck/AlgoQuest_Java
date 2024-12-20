package doordash.slidingWindow;

import java.io.CharConversionException;
import java.util.*;

/*
Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
 */

class FindAllAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(s == null || p == null ||p.isEmpty() || s.length()<p.length()){
            return result;
        }
        Map<Character, Integer> pCount = new HashMap<>();
        for(char c : p.toCharArray()){
            //hashmap p
            pCount.put(c, pCount.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> windowCount = new HashMap<>();
        int windowSize = p.length();
        int left = 0;
        for(int right = 0; right<s.length(); right++){
            char currentChar = s.charAt(right);
            //string s;
            windowCount.put(currentChar, windowCount.getOrDefault(currentChar, 0) + 1);
            if(right>=windowSize){
                //abc
                //a = 1
                char removeChar = s.charAt(left);
                //bc
                if(windowCount.get(removeChar) == 1){
                    windowCount.remove(removeChar);
                    //aabc
                    //a = 1
                }else{
                    windowCount.put(removeChar, windowCount.get(removeChar) - 1);
                }
                left++;
            }
            if(windowCount.equals(pCount)){
                result.add(left);
            }
        }
        return result;
    }
}