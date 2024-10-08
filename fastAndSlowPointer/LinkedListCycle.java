package fastAndSlowPointer;

/*Problem Statement: Given a linked list, determine if it has a cycle in it. A cycle exists if,
while traversing the list, you revisit a node.

Approach:
Use a slow pointer that moves one step at a time and a fast pointer that moves two steps at a time.
If the fast pointer and slow pointer meet, then the linked list contains a cycle.

 */
public class LinkedListCycle {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            if (slow == fast) {
                return true;  // Cycle detected
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return false;  // No cycle detected
    }
}