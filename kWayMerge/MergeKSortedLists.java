package kWayMerge;

import java.util.PriorityQueue;

public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> a.value - b.value);

        // Add the head of each list to the minHeap
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                minHeap.add(new Node(lists[i].val, i, 0));  // Use arrayIndex (i) for the list index
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Extract the smallest element from the heap and add the next node from the same list
        while (!minHeap.isEmpty()) {
            Node node = minHeap.poll();
            current.next = new ListNode(node.value);
            current = current.next;

            // Add the next element from the same list, if available
            if (lists[node.arrayIndex].next != null) {
                lists[node.arrayIndex] = lists[node.arrayIndex].next;
                minHeap.add(new Node(lists[node.arrayIndex].val, node.arrayIndex, 0));  // Use arrayIndex to track the list
            }
        }

        return dummy.next;
    }
}
