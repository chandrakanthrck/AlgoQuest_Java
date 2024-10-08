# Merge Intervals Variations

## Overview
The **Merge Intervals** technique involves solving problems related to overlapping intervals, such as merging intervals, inserting new intervals, or managing interval-based schedules. This method typically deals with sorting intervals based on their starting points and then merging them as needed.

## When to Use:
- **Overlapping intervals**: When the problem involves merging intervals that overlap.
- **Inserting intervals**: When you need to insert a new interval into an already sorted list and merge overlaps if necessary.
- **Scheduling problems**: For problems like meeting rooms, train platforms, and other scheduling issues where time intervals overlap.

## Effective Scenarios:
- **Sorted intervals**: If the input intervals are sorted or need sorting before processing.
- **Merging operations**: When the problem involves reducing overlapping intervals into fewer, non-overlapping intervals.
- **Time-based intervals**: Frequently used in scheduling problems (meetings, platforms, etc.).

## How to Recognize Problems that Use Merge Intervals:
- The problem asks you to **merge overlapping intervals** or identify conflicts between intervals.
- You need to insert a new interval into a list of sorted intervals.
- The problem involves checking availability between multiple events or meetings (meeting room problems, train scheduling).
- You need to determine the **maximum overlap** or minimum resources (like meeting rooms or train platforms).

## Example Problem Types:
1. **Merge Intervals**: Merging overlapping intervals in a list.
2. **Insert Interval**: Inserting a new interval into an existing sorted list of non-overlapping intervals.
3. **Meeting Rooms**: Determining if a person can attend all meetings or how many meeting rooms are required.
4. **Minimum Number of Platforms**: Finding the minimum number of platforms required based on train arrival and departure times.

## Smart Hacks to Recognize Merge Interval Problems:
- **Time-based input**: If the problem involves time-based input (like meeting schedules), merge intervals may be needed.
- **Overlapping intervals**: If intervals overlap and need merging or splitting, this is a clear indicator of merge intervals.
- **Multiple intervals**: When dealing with scheduling problems or managing multiple resources, merge intervals is a likely approach.

---

### Files:
1. **MergeIntervals.java**: Merging overlapping intervals in a list.
2. **InsertInterval.java**: Inserting a new interval into an existing sorted list of intervals and merging if necessary.
3. **MeetingRooms.java**: Determining if a person can attend all meetings based on their start and end times.
4. **MinimumNumberOfPlatforms.java**: Finding the minimum number of platforms required at a railway station based on train arrival and departure times.
