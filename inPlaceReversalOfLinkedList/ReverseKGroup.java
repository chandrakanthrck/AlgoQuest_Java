package inPlaceReversalOfLinkedList;

public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode current = head;
        int count = 0;
        
        // Count the number of nodes in the list
        while (current != null && count != k) {
            current = current.next;
            count++;
        }
        
        // If we have k nodes, then we reverse the group
        if (count == k) {
            current = reverseKGroup(current, k); // Reverse rest of the list
            while (count-- > 0) {
                ListNode nextNode = head.next;
                head.next = current;
                current = head;
                head = nextNode;
            }
            head = current;
        }
        return head;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        
        ReverseKGroup rkg = new ReverseKGroup();
        ListNode reversed = rkg.reverseKGroup(head, 2);
        
        while (reversed != null) {
            System.out.print(reversed.val + " ");
            reversed = reversed.next;
        }
    }
}
