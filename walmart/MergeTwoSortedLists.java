package walmart;/*
This program merges two sorted linked lists into a single sorted linked list.

### Problem Statement:
- You are given the heads of two sorted linked lists `list1` and `list2`.
- Merge the two lists into a single sorted linked list and return the head of the merged list.

### Approach: Iterative Two-Pointer Approach

1. **Two Pointers:**
   - Since both lists are sorted, we can use two pointers to compare the nodes of `list1` and `list2` one by one.
   - We initialize a dummy node to help in building the merged list, and we use a pointer `current` to track the position in the merged list.

2. **Core Idea:**
   - Compare the current nodes of both `list1` and `list2`.
   - Attach the smaller of the two nodes to the merged list and move the corresponding pointer (either `list1` or `list2`) to the next node.
   - Repeat this process until we reach the end of one of the lists.

3. **Handling Remaining Nodes:**
   - After the main comparison loop, one of the two lists might still have remaining nodes.
   - Attach the remaining nodes to the merged list since they are already sorted.

4. **Dummy Node:**
   - The dummy node simplifies the process of merging the lists. At the end of the function, we return the merged list starting from `dummy.next`.

5. **Time Complexity:**
   - The time complexity is **O(N + M)**, where `N` and `M` are the lengths of `list1` and `list2`, respectively, since we traverse both lists exactly once.

6. **Space Complexity:**
   - The space complexity is **O(1)**, as we only use constant extra space to store pointers.

### Example:
For the following two sorted linked lists:
   list1 = 1 -> 2 -> 4
   list2 = 1 -> 3 -> 4

The merged result will be:
   1 -> 1 -> 2 -> 3 -> 4 -> 4

### Code:
*/

public class MergeTwoSortedLists {

    // ListNode class definition
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a dummy node to simplify the merging process
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Traverse both lists, comparing the nodes
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;  // Attach list1 node to the merged list
                list1 = list1.next;  // Move to the next node in list1
            } else {
                current.next = list2;  // Attach list2 node to the merged list
                list2 = list2.next;  // Move to the next node in list2
            }
            current = current.next;  // Move the current pointer forward
        }

        // If one of the lists has remaining nodes, attach it to the merged list
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        // Return the merged list, skipping the dummy node
        return dummy.next;
    }

    public static void main(String[] args) {
        MergeTwoSortedLists mergeLists = new MergeTwoSortedLists();

        // Example input: list1 = 1 -> 2 -> 4, list2 = 1 -> 3 -> 4
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        // Merging the two sorted lists
        ListNode mergedList = mergeLists.mergeTwoLists(list1, list2);

        // Print the merged list
        while (mergedList != null) {
            System.out.print(mergedList.val + " ");
            mergedList = mergedList.next;
        }
        // Expected output: 1 1 2 3 4 4
    }
}
