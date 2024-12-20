package doordash.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumStepsAnagram {
    public int minSteps(String s, String t) {
        if(s == null || t == null || s.length() != t.length() || s.isEmpty()){
            throw new IllegalArgumentException("Strings must be non-null and of the same length");
        }
        Map<Character, Integer> sCount = new HashMap<>();
        for(char c : s.toCharArray()){
            sCount.put(c, sCount.getOrDefault(c, 0) + 1);
        }
        int misMatches = 0;
        for(char c : t.toCharArray()){
            if(sCount.containsKey(c) && sCount.get(c) > 0){
                // Use one matching character from sCount
                sCount.put(c, sCount.get(c)-1);
            }else{
                // No matching character available in sCount
                misMatches++;
            }
        }
        return misMatches;
    }
}
