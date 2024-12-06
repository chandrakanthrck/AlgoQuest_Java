package doordash.interval;

import java.util.Arrays;

public class MeetingRooms {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return true; // No meetings, so all can be attended
        }

        // Step 1: Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 2: Check for overlapping intervals
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                return false; // Overlap detected
            }
        }

        return true; // No overlaps, all meetings can be attended
    }

    public static void main(String[] args) {
        MeetingRooms solver = new MeetingRooms();

        int[][] intervals1 = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println("Can attend all meetings: " + solver.canAttendMeetings(intervals1)); // Output: false

        int[][] intervals2 = {{7, 10}, {2, 4}};
        System.out.println("Can attend all meetings: " + solver.canAttendMeetings(intervals2)); // Output: true
    }
}
