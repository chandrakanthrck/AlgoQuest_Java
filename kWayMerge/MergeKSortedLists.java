package kWayMerge;

import java.util.PriorityQueue;

public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> a.value - b.value);

        // Add the head of each list to the minHeap
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.add(new Node(list.val, 0, 0));  // Only use value for lists
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Extract the smallest element from the heap and add the next node from the same list
        while (!minHeap.isEmpty()) {
            Node node = minHeap.poll();
            current.next = new ListNode(node.value);
            current = current.next;

            if (lists[node.row].next != null) {
                lists[node.row] = lists[node.row].next;
                minHeap.add(new Node(lists[node.row].val, node.row, 0));
            }
        }

        return dummy.next;
    }
}

