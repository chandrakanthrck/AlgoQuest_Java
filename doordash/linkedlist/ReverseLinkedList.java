package doordash.linkedlist;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null; // Initially, no previous node
        ListNode curr = head; // Start with the head node

        while (curr != null) {
            ListNode next = curr.next; // Save the next node
            curr.next = prev;          // Reverse the current node's pointer
            prev = curr;               // Move prev to the current node
            curr = next;               // Move curr to the next node
        }

        return prev; // prev becomes the new head of the reversed list
    }

    // Helper class to define a ListNode
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        ReverseLinkedList solver = new ReverseLinkedList();

        // Example: Create a linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Reverse the linked list
        ListNode reversedHead = solver.reverseList(head);

        // Print the reversed linked list: 5 -> 4 -> 3 -> 2 -> 1
        System.out.print("Reversed list: ");
        while (reversedHead != null) {
            System.out.print(reversedHead.val + " ");
            reversedHead = reversedHead.next;
        }
    }
}

