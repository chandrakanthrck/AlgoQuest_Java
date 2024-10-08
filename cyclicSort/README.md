# Cyclic Sort

## Overview
The **Cyclic Sort** technique is used to efficiently sort numbers when the input array contains elements that belong to a fixed range. This technique sorts the array in-place and can also help in detecting duplicates, missing numbers, or misplaced elements.

## When to Use:
- When the input array contains numbers in a fixed range, such as 1 to n.
- When you need to find missing or duplicate numbers in the array without extra space.
- When asked to sort the array efficiently in place.

## Effective Scenarios:
- Problems involving arrays with elements from a fixed range.
- Sorting problems where minimal space usage is required.

## How to Recognize Problems that Use Cyclic Sort:
- The problem asks to find missing or duplicate numbers in an array.
- The array contains numbers from a fixed range (e.g., 1 to n).
- The problem mentions sorting an array with minimal extra space.

---

## Basic Problem Types:
1. **Find Missing Number**: Find the missing number in an array of consecutive integers.
2. **Find All Duplicates**: Find all duplicate numbers in an array.
3. **Find the Duplicate Number**: Find the duplicate number in an array where only one number repeats.

### Smart Hacks for Basic Problems:
- If the problem involves finding missing or duplicate numbers in a range, Cyclic Sort is likely useful.
- Focus on in-place sorting of the array where each number is placed in its correct index position.

---

## Advanced Problem Types:
1. **First Missing Positive**: Finding the smallest positive integer missing from the array.
2. **Set Mismatch**: Finding a set of numbers where one number is missing, and one number is duplicated.
3. **Find All Missing Numbers**: Find all missing numbers from the array in a specific range.

### Smart Hacks for Advanced Problems:
- Pay attention to problems where the numbers range from 1 to n and you're asked to manipulate them in-place.
- Use cyclic sort to rearrange the numbers at their correct positions.
- Problems involving "missing numbers" often involve comparing each element with its index.
