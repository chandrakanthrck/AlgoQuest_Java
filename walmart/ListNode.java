package walmart;

public class ListNode {
    int val;        // The value of the node
    ListNode next;  // The pointer to the next node in the list

    // Constructor to initialize the node with a value
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    // Constructor to initialize the node with a value and next node reference
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

