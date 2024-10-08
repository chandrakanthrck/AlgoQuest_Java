package inPlaceReversalOfLinkedList;

public class ReverseAlternateKNodes {
    public ListNode reverseAlternateKNodes(ListNode head, int k) {
        if (head == null || k <= 1) return head;
        return reverseAlternateK(head, k, true);
    }

    private ListNode reverseAlternateK(ListNode head, int k, boolean reverse) {
        if (head == null) return null;
        
        ListNode prev = null;
        ListNode current = head;
        int count = 0;
        
        // Reverse first k nodes if reverse flag is true
        while (current != null && count < k) {
            if (reverse) {
                ListNode next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            } else {
                prev = current;
                current = current.next;
            }
            count++;
        }

        if (reverse) {
            head.next = reverseAlternateK(current, k, !reverse);
            return prev;
        } else {
            prev.next = reverseAlternateK(current, k, !reverse);
            return head;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        
        ReverseAlternateKNodes obj = new ReverseAlternateKNodes();
        ListNode result = obj.reverseAlternateKNodes(head, 2);
        
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
