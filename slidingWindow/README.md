
# Sliding Window

## Overview
The **Sliding Window** technique is a highly efficient way to solve problems involving subarrays or substrings. It works by maintaining a window (which can be fixed or dynamic in size) that moves across the array or string. The goal is to slide the window across the input while keeping track of a condition, such as the sum, frequency of elements, or distinct characters.

## When to Use:
- **Finding maximum or minimum in a subarray**: For problems that ask for the maximum, minimum, or some other property of subarrays of fixed length.
- **Substrings with certain properties**: For problems involving substrings with conditions like distinct characters, or finding if a substring is a permutation of another string.
- **Dynamic subarrays**: Problems that require finding subarrays with properties like a sum greater than or equal to a certain value.

## Effective Scenarios:
- **Fixed or variable window sizes**: Works well when you need to keep track of a sliding segment of the input. The window size can either be fixed or dynamically adjusted.
- **Subarray or substring problems**: If the problem deals with subarrays (contiguous subsegments) or substrings, sliding window techniques are very effective.
- **Efficient traversal of large inputs**: Reduces the need for brute-force solutions by maintaining and adjusting a window over the data, making it possible to process the input in O(n) time.

## How to Recognize Problems that Use Sliding Window:
- **Subarrays or substrings**: If the problem asks for properties of subarrays or substrings (e.g., finding the largest, smallest, or a certain condition), sliding window is a good candidate.
- **Fixed or adjustable window**: Problems where you need to consider either a fixed-size window (e.g., finding maximum sum of a subarray of size k) or dynamic (e.g., finding the smallest subarray with sum ≥ S).
- **Efficient processing**: If brute-force would be too slow (O(n²)) but there’s a way to maintain a running total or condition as you move through the input, sliding window is often a solution.

## Example Problem Types:
- **Maximum sum subarray of size k**: Find the subarray of a given length with the maximum sum.
- **Smallest subarray with a sum greater than or equal to S**: Find the smallest subarray whose sum is at least S.
- **Longest substring with k distinct characters**: Find the longest substring that contains at most k distinct characters.

## Smart Hacks to Recognize Sliding Window Problems:
- **Subarrays or substrings**: If the problem revolves around subarrays or substrings, especially if the solution needs to be efficient, consider sliding window.
- **Window of fixed size**: If you're asked to process elements in fixed-size chunks, a sliding window is likely the best approach.
- **Conditions on subarrays or substrings**: Problems asking for maximum/minimum/target conditions on subarrays or substrings frequently involve a sliding window.
