package inPlaceReversalOfLinkedList;

// Reverse a sub-list between two given positions
public class ReverseSubList {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        
        // Move prev to one node before the reversal starts
        for (int i = 1; i < m; i++) {
            prev = prev.next;
        }
        
        ListNode start = prev.next;
        ListNode then = start.next;
        
        // Reverse the sublist
        for (int i = 0; i < n - m; i++) {
            start.next = then.next;
            then.next = prev.next;
            prev.next = then;
            then = start.next;
        }
        
        return dummy.next;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        
        ReverseSubList rsl = new ReverseSubList();
        ListNode reversed = rsl.reverseBetween(head, 2, 4);
        
        while (reversed != null) {
            System.out.print(reversed.val + " ");
            reversed = reversed.next;
        }
    }
}
