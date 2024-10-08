package inPlaceReversalOfLinkedList;

public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        
        // Move prev to the node before the reverse start
        for (int i = 0; i < m - 1; i++) {
            prev = prev.next;
        }
        
        ListNode start = prev.next;
        ListNode then = start.next;
        
        // Reverse the sublist between m and n
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
        
        ReverseBetween obj = new ReverseBetween();
        ListNode result = obj.reverseBetween(head, 2, 4);
        
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
