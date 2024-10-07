
# Two Heaps

## Overview
The **Two Heaps** technique is used when you need to maintain dynamic data with the ability to quickly retrieve the median, smallest, or largest elements. Two heaps typically consist of a **max-heap** to store the smaller half of elements and a **min-heap** to store the larger half.

## When to Use:
- **Finding the median in a data stream**: Two heaps allow you to keep track of the median dynamically by balancing the heaps.
- **Kth smallest/largest problems**: Two heaps are often used to efficiently find Kth smallest or largest elements.

## Effective Scenarios:
- **Dynamic datasets**: If you need to add elements dynamically and retrieve the smallest/largest/median values in constant or logarithmic time.
- **Median maintenance**: Problems that ask for finding or maintaining the median of a data stream.

## How to Recognize Problems that Use Two Heaps:
- **Median of a stream**: If the problem requires you to maintain or calculate the median while adding new numbers.
- **Sliding window**: Problems where you need to calculate medians in a sliding window.

## Example Problem Types:
- **Median from Data Stream**: Maintain a running median as new numbers are added.
- **Sliding Window Median**: Calculate the median for each sliding window in an array.
- **Kth Largest Element**: Find the Kth largest element in an unsorted array.

## Smart Hacks to Recognize Two Heap Problems:
- **Median Calculation**: If the problem requires calculating or updating a median dynamically, two heaps may be effective.
- **Kth Smallest/Largest**: When asked to find Kth smallest or largest, heaps are typically used to optimize this.

## Key Code Components:
- **Max-Heap & Min-Heap**: Two heaps (a max-heap and a min-heap) are used to partition and balance the elements.
- **Balancing Heaps**: Ensuring that both heaps are balanced, i.e., either of equal size or the max-heap has one more element than the min-heap.
