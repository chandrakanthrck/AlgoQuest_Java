package fastAndSlowPointer;

/*
Problem Statement: Given a linked list that contains a cycle, return the length of the cycle.

Approach:
First, use the fast and slow pointer technique to detect the cycle.
Once you detect the cycle, keep one pointer fixed and move the other pointer until it
comes back to the starting point to measure the length of the cycle.

 */
public class CycleLength {

    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            x = val;
            next = null;
        }
    }

    public static int findCycle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return calculateLength(slow);
            }
        }
        return 0;
    }
    public static int calculateLength(ListNode slow){
        ListNode current = slow;
        int length = 0;
        do{
            current = current.next;
            length++;
        }while(current!= slow);
        return length;
    }
}
