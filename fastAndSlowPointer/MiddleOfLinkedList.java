package fastAndSlowPointer;

/*Problem Statement: Given a non-empty singly linked list, return the middle node. If there are two middle nodes,
return the second one.

Approach:
Use a slow pointer that moves one step at a time and a fast pointer that moves two steps at a time.
When the fast pointer reaches the end of the list, the slow pointer will be at the middle.

 */
public class MiddleOfLinkedList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;  // Slow is now pointing to the middle node
    }
}