package doordash.greedyAlgorithm;

import java.util.*;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        // Step 1: Count frequencies of each task
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }

        // Step 2: Sort frequencies in descending order
        Arrays.sort(freq);

        // Step 3: Calculate the maximum frequency and tasks with max frequency
        int maxFreq = freq[25];
        int maxFreqCount = 0;
        for (int f : freq) {
            if (f == maxFreq) {
                maxFreqCount++;
            }
        }

        // Step 4: Calculate the minimum required intervals
        int partCount = maxFreq - 1;
        int partLength = n - (maxFreqCount - 1);
        int emptySlots = partCount * partLength;
        int remainingTasks = tasks.length - (maxFreq * maxFreqCount);
        int idleSlots = Math.max(0, emptySlots - remainingTasks);

        return tasks.length + idleSlots;
    }
}

