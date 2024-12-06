package doordash.linkedlist;

public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode pA = headA;
        ListNode pB = headB;

        // Traverse both lists
        while (pA != pB) {
            // Move to the next node or switch to the other list
            pA = (pA == null) ? headB : pA.next;
            pB = (pB == null) ? headA : pB.next;
        }

        // Return either the intersection node or null
        return pA;
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
        // Example: Create two intersecting linked lists
        ListNode intersect = new ListNode(8);
        intersect.next = new ListNode(4);
        intersect.next.next = new ListNode(5);

        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = intersect;

        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = intersect;

        IntersectionOfTwoLinkedLists solver = new IntersectionOfTwoLinkedLists();
        ListNode result = solver.getIntersectionNode(headA, headB);

        System.out.println(result != null ? "Intersection at node with value: " + result.val : "No intersection");
    }
}

