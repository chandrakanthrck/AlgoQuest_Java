package doordash.interval;

import java.util.*;

public class EmployeeFreeTime {
    // Definition for an Interval
    public static class Interval {
        int start;
        int end;

        Interval() {}
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> allIntervals = new ArrayList<>();

        // Step 1: Flatten the schedule into a single list
        for (List<Interval> employee : schedule) {
            allIntervals.addAll(employee);
        }

        // Step 2: Sort intervals by start time (and end time as a tie-breaker)
        allIntervals.sort((a, b) -> a.start != b.start ? a.start - b.start : a.end - b.end);

        // Step 3: Merge intervals
        List<Interval> mergedIntervals = new ArrayList<>();
        Interval prev = allIntervals.get(0);
        for (int i = 1; i < allIntervals.size(); i++) {
            Interval curr = allIntervals.get(i);
            if (prev.end >= curr.start) { // Overlapping intervals
                prev.end = Math.max(prev.end, curr.end);
            } else { // No overlap
                mergedIntervals.add(prev);
                prev = curr;
            }
        }
        mergedIntervals.add(prev); // Add the last interval

        // Step 4: Find gaps between merged intervals
        List<Interval> freeTime = new ArrayList<>();
        for (int i = 1; i < mergedIntervals.size(); i++) {
            Interval prevInterval = mergedIntervals.get(i - 1);
            Interval currInterval = mergedIntervals.get(i);
            if (prevInterval.end < currInterval.start) {
                freeTime.add(new Interval(prevInterval.end, currInterval.start));
            }
        }

        return freeTime;
    }

    // Main method for testing
    public static void main(String[] args) {
        EmployeeFreeTime solution = new EmployeeFreeTime();

        // Test case 1
        List<List<Interval>> schedule1 = Arrays.asList(
                Arrays.asList(new Interval(1, 2), new Interval(5, 6)),
                Arrays.asList(new Interval(1, 3)),
                Arrays.asList(new Interval(4, 10))
        );
        List<Interval> result1 = solution.employeeFreeTime(schedule1);
        for (Interval interval : result1) {
            System.out.println("[" + interval.start + ", " + interval.end + "]");
        }

        // Test case 2
        List<List<Interval>> schedule2 = Arrays.asList(
                Arrays.asList(new Interval(1, 3), new Interval(6, 7)),
                Arrays.asList(new Interval(2, 4)),
                Arrays.asList(new Interval(2, 5), new Interval(9, 12))
        );
        List<Interval> result2 = solution.employeeFreeTime(schedule2);
        for (Interval interval : result2) {
            System.out.println("[" + interval.start + ", " + interval.end + "]");
        }
    }
}

