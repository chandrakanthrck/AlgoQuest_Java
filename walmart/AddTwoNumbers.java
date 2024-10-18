package walmart;

public class AddTwoNumbers {

    // Method to add two numbers represented by two linked lists
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // A dummy node is used to simplify handling edge cases.
        ListNode dummy = new ListNode(0);
        ListNode p = l1, q = l2, current = dummy;
        int carry = 0;  // Initialize carry to 0 (no carry at the start)

        // Loop through both linked lists as long as there are digits to process
        while (p != null || q != null) {
            // Get the current value of p (or 0 if p is null)
            int x = (p != null) ? p.val : 0;
            // Get the current value of q (or 0 if q is null)
            int y = (q != null) ? q.val : 0;

            // Add the two digits along with any carry from the previous step
            int sum = carry + x + y;

            // Update carry for the next step
            carry = sum / 10;

            // Create a new node for the current digit (sum % 10) and attach it to the result list
            current.next = new ListNode(sum % 10);

            // Move current pointer to the next node in the result list
            current = current.next;

            // Move p and q to the next nodes in their respective lists (if they exist)
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }

        // If there's any remaining carry after the loop, add a new node with carry value
        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        // Return the next node after the dummy (the start of the actual result)
        return dummy.next;
    }

    // Helper method to print the linked list (for testing)
    public void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    // Main method to test the addTwoNumbers method
    public static void main(String[] args) {
        AddTwoNumbers solution = new AddTwoNumbers();

        // Create first number: 342 represented as 2 -> 4 -> 3
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        // Create second number: 465 represented as 5 -> 6 -> 4
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        // Add the two numbers
        ListNode result = solution.addTwoNumbers(l1, l2);

        // Print the result: Expected output 7 -> 0 -> 8 (807)
        System.out.print("Result: ");
        solution.printList(result);
    }
}
