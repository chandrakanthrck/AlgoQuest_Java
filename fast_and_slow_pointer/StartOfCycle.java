package fast_and_slow_pointer;

/*Problem Statement: Given a linked list that contains a cycle, find the node where the cycle begins.

Approach:
First, use the fast and slow pointer technique to detect the cycle (as in the first problem).
Once a cycle is detected, reset one pointer to the head of the list and move both pointers one step at a time.
The point at which they meet is the start of the cycle.

 */
public class StartOfCycle {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        // First, detect the cycle using fast and slow pointers
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {  // Cycle detected
                ListNode pointer = head;

                // Move both pointers one step at a time to find the start of the cycle
                while (pointer != slow) {
                    pointer = pointer.next;
                    slow = slow.next;
                }
                return pointer;  // Starting point of the cycle
            }
        }

        return null;  // No cycle
    }
}
