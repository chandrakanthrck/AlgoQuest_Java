package walmart;/*
This program merges `K` sorted linked lists into a single sorted linked list using a **Min-Heap (Priority Queue)** approach.

### Problem Statement:
- Given an array of `K` linked lists, each sorted in non-decreasing order, merge them into one sorted linked list and
 return the merged list.

### Approach: Min-Heap (Priority Queue)

1. **Why Use a Min-Heap?**
   - Since each of the `K` lists is already sorted, we can use a **min-heap** to efficiently find the smallest element
    from the heads of all the lists at any time.
   - A min-heap helps maintain the smallest element at the top, and we can easily extract it and add the next element
   from the same list into the heap.
   - This ensures that the elements are always merged in sorted order.

2. **Heap Setup:**
   - Use a custom node class or a `ListNode` directly, and insert the head of each list into the heap (min-heap).
   - The heap will automatically sort the nodes by their values, allowing us to efficiently merge the lists.

3. **Algorithm:**
   - Initialize a min-heap (priority queue) and insert the first node (head) of each linked list.
   - Use a dummy node to simplify the construction of the final merged list.
   - While the heap is not empty:
     - Extract the smallest node from the heap.
     - Append it to the result list.
     - If the node has a next node in the same list, insert the next node into the heap.
   - Repeat until the heap is empty and all lists are fully merged.

4. **Time Complexity:**
   - Inserting and extracting from a heap takes **O(log K)** time, where `K` is the number of linked lists.
   - The overall time complexity is **O(N log K)**, where `N` is the total number of nodes across all linked lists.

5. **Space Complexity:**
   - The space complexity is **O(K)** for the heap, where `K` is the number of lists.

### Example:
For the following `K = 3` sorted lists:
   1 -> 4 -> 5
   1 -> 3 -> 4
   2 -> 6

The merged result will be:
   1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 6

### Code:
*/

import java.util.PriorityQueue;

public class MergeKSortedLists {

    // ListNode class definition (Assuming you have a ListNode class similar to the following)
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    // Node class to represent the value in the priority queue along with array index tracking
    static class Node {
        int value;
        int arrayIndex;
        int nodeIndex;

        public Node(int value, int arrayIndex, int nodeIndex) {
            this.value = value;
            this.arrayIndex = arrayIndex;
            this.nodeIndex = nodeIndex;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> a.value - b.value);

        // Add the head of each list to the minHeap
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                minHeap.add(new Node(lists[i].val, i, 0));  // Use arrayIndex (i) for the list index
            }
        }

        ListNode dummy = new ListNode(0);  // Dummy node to simplify the merged list construction
        ListNode current = dummy;

        // Extract the smallest element from the heap and add the next node from the same list
        while (!minHeap.isEmpty()) {
            Node node = minHeap.poll();  // Get the node with the smallest value
            current.next = new ListNode(node.value);  // Append the smallest node to the merged list
            current = current.next;

            // Add the next element from the same list, if available
            if (lists[node.arrayIndex].next != null) {
                lists[node.arrayIndex] = lists[node.arrayIndex].next;  // Move to the next node in the list
                minHeap.add(new Node(lists[node.arrayIndex].val, node.arrayIndex, 0));  // Add the next node to the heap
            }
        }

        return dummy.next;  // Return the merged list, skipping the dummy node
    }

    public static void main(String[] args) {
        MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();

        // Example input (3 sorted linked lists)
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(5);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode list3 = new ListNode(2);
        list3.next = new ListNode(6);

        ListNode[] lists = new ListNode[]{list1, list2, list3};

        // Merging K sorted linked lists
        ListNode mergedList = mergeKSortedLists.mergeKLists(lists);

        // Print the merged list
        while (mergedList != null) {
            System.out.print(mergedList.val + " ");
            mergedList = mergedList.next;
        }
        // Expected Output: 1 1 2 3 4 4 5 6
    }
}
