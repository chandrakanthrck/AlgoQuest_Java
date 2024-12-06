package doordash.linkedlist;

public class DeleteNodeInLinkedList {
    public void deleteNode(ListNode node) {
        if (node == null || node.next == null) return;

        // Copy the value of the next node into the current node
        node.val = node.next.val;

        // Update the current node's next pointer to skip the next node
        node.next = node.next.next;
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
        DeleteNodeInLinkedList solver = new DeleteNodeInLinkedList();

        // Example: Create a linked list: 4 -> 5 -> 1 -> 9
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);

        // Node to be deleted (e.g., node with value 5)
        ListNode nodeToDelete = head.next;

        // Delete the node
        solver.deleteNode(nodeToDelete);

        // Print the modified list: 4 -> 1 -> 9
        System.out.print("Modified list: ");
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
