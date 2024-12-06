package doordash.interval;

import java.util.Arrays;

public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0; // No meetings, no rooms needed
        }

        // Step 1: Separate and sort start and end times
        int[] startTimes = new int[intervals.length];
        int[] endTimes = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            startTimes[i] = intervals[i][0];
            endTimes[i] = intervals[i][1];
        }

        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        // Step 2: Use two pointers to track rooms
        int startPointer = 0, endPointer = 0;
        int roomsRequired = 0;

        while (startPointer < intervals.length) {
            if (startTimes[startPointer] < endTimes[endPointer]) {
                // A new room is needed
                roomsRequired++;
            } else {
                // Free up a room
                endPointer++;
            }
            startPointer++;
        }

        return roomsRequired;
    }

    public static void main(String[] args) {
        MeetingRoomsII solver = new MeetingRoomsII();

        int[][] intervals1 = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println("Minimum rooms required: " + solver.minMeetingRooms(intervals1)); // Output: 2

        int[][] intervals2 = {{7, 10}, {2, 4}};
        System.out.println("Minimum rooms required: " + solver.minMeetingRooms(intervals2)); // Output: 1
    }
}

