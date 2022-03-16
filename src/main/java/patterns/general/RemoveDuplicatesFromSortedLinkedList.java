package patterns.general;

import recursion.ListNode;

/*
* https://leetcode.com/problems/remove-duplicates-from-sorted-list/
* Remove Duplicates from Sorted List
* Given the head of a sorted linked list, delete all duplicates such that each element appears only once.
* Return the linked list sorted as well.
* Example 1:
Input: head = [1,1,2]
Output: [1,2]
* */
public class RemoveDuplicatesFromSortedLinkedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }
    /*
    *
    * Complexity Analysis:
        Time complexity : O(n). Because each node in the list is checked exactly once to determine if it is a duplicate
                          or not, the total run time is O(n), where nn is the number of nodes in the list.
        Space complexity : O(1). No additional space is used.
    * */
}
