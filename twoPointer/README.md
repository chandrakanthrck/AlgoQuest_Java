
# Two Pointers

## Overview
The **Two Pointers** technique is a powerful and efficient method used to traverse arrays or lists to solve problems that involve pairs or sequences of elements. It typically involves two pointers starting from different positions—either at the beginning and end or adjacent positions—and moving towards each other or in the same direction. This technique is most effective with **sorted arrays** or problems that involve comparisons between pairs.

## When to Use:
- **Finding pairs or triplets**: When the problem asks to find pairs, triplets, or sets that satisfy certain conditions (like adding up to a specific value).
- **Comparing elements** from both ends of an array or list.
- **Reversing arrays or strings in-place**: Useful when you need to reverse sequences without additional memory.
- **Checking for symmetry**: For example, determining if a string or array is a palindrome.
- **Partitioning arrays**: When rearranging elements based on conditions like odd vs even, positive vs negative, etc.

## Effective Scenarios:
- **Sorted arrays**: If the input array is sorted, this approach often allows for significant performance improvements by reducing time complexity from O(n²) to O(n).
- **Problems involving pairs**: The technique is commonly used to solve problems like **Two Sum**, **Three Sum**, and **finding unique pairs**.
- **In-place operations**: It's useful for problems where you are asked to modify the array or string in-place, as it uses minimal extra memory.

## How to Recognize Problems that Use Two Pointers:
- **The problem asks to find pairs or triplets** of numbers or elements that meet specific conditions.
- **The input is sorted**, and you're asked to solve the problem efficiently (indicating the need for a linear O(n) or O(n log n) solution).
- **The problem involves checking from both ends of the array or list**, such as palindrome checking or finding elements with certain properties at both ends.
- **The problem involves partitioning an array** based on a certain condition (e.g., separating even and odd numbers).

## Example Problem Types:
- **Two Sum in a sorted array**: Given a sorted array, find two numbers that sum to a target value.
- **Three Sum**: Find all unique triplets in an array that sum up to zero.
- **Palindrome Check**: Determine if a string is a palindrome by comparing characters from both ends.
- **Partitioning Arrays**: Rearranging arrays to separate certain elements (e.g., separating even and odd numbers).

## Smart Hacks to Recognize Two Pointer Problems:
- **Sorted Input**: If the input is sorted and you're required to find a specific relationship between elements (e.g., sum, product, or difference), two pointers may be the best approach.
- **Pair or Triplet Relationship**: If you need to find pairs or triplets that meet a condition (like summing to a target), two pointers are likely effective.
- **In-place Modifications**: If the problem requires you to modify the array or string in-place, consider two pointers for efficient traversal and modification.
