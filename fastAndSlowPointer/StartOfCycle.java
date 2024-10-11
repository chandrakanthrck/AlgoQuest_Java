package fastAndSlowPointer;

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
        if(head == null || head.next == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                slow = head;
                while(slow!=fast){
                    slow = slow.next;
                    fast= fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
