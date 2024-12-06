package doordash.slidingWindow;

public class MinimumStepsAnagram {
    public int minSteps(String s, String t) {
        // Frequency arrays for 's' and 't'
        int[] freqS = new int[26];
        int[] freqT = new int[26];
        // Count frequencies in 's' and 't'
        //Maps each lowercase letter ('a' to 'z') to an index in the range [0, 25]:
        for(char c:s.toCharArray()){
            freqS[c - 'a']++;
        }
        for(char c:s.toCharArray()){
            freqT[c - 'a']++;
        }
        // Calculate the number of steps
        int steps = 0;
        for(int i=0;i<26;i++){
            if(freqS[i]>freqT[i]){
                steps += freqS[i] - freqT[i];
            }
        }
        return steps;
    }
}
