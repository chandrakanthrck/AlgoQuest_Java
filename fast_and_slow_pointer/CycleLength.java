package fast_and_slow_pointer;

/*
Problem Statement: Given a linked list that contains a cycle, return the length of the cycle.

Approach:
First, use the fast and slow pointer technique to detect the cycle.
Once you detect the cycle, keep one pointer fixed and move the other pointer until it
comes back to the starting point to measure the length of the cycle.

 */
public class CycleLength {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static int findCycleLength(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // Detect the cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return calculateLength(slow);
            }
        }

        return 0;  // No cycle
    }

    private static int calculateLength(ListNode slow) {
        ListNode current = slow;
        int length = 0;

        do {
            current = current.next;
            length++;
        } while (current != slow);

        return length;
    }
}
