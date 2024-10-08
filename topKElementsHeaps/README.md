# Top K Elements (Heaps)

## Overview
The **Top K Elements (Heaps)** technique is used to solve problems where you need to find the top K largest, smallest, or most frequent elements in a dataset. This method is efficient when you want to avoid sorting the entire dataset but need the top K items.

## When to Use:
- When asked to find the top K frequent elements, or top K largest or smallest elements.
- When you need efficient ranking of elements using a heap.

## Effective Scenarios:
- Problems involving finding top K elements without sorting the entire dataset.
- Finding the Kth largest or smallest element in a large dataset.

## How to Recognize Problems that Use Heaps:
- The problem asks for the top K frequent elements or the Kth largest/smallest element.
- Problems related to ranking or ordering elements without requiring a full sort.

---

## Basic Problem Types:
1. **Top K Frequent Elements**: Find the K most frequent elements in a dataset.
2. **Kth Largest Element in Array**: Find the Kth largest element in an unsorted array.
3. **Sliding Window Maximum**: Find the maximum element in each sliding window of size K.

### Smart Hacks for Basic Problems:
- Use a min-heap to keep track of the top K largest elements.
- Use a max-heap to keep track of the top K smallest elements.

---

## Advanced Problem Types:
1. **K Closest Points to Origin**: Finding the K closest points to the origin in a 2D plane.
2. **Kth Smallest Element in a Matrix**: Finding the Kth smallest element in a sorted matrix.
3. **Kth Largest Element in a Stream**: Continuously finding the Kth largest element in a dynamic stream of data.

### Smart Hacks for Advanced Problems:
- Use max-heaps or min-heaps depending on whether you're tracking the smallest or largest values.
- Problems like finding closest points to the origin rely on distance calculations with efficient heap usage.
- For dynamic streams, maintaining a min-heap to track the K largest elements helps you retrieve the Kth largest element efficiently.
