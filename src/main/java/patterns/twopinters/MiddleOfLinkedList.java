package patterns.twopinters;

/*
* https://leetcode.com/problems/middle-of-the-linked-list/
* Given the head of a singly linked list, return the middle node of the linked list.
* If there are two middle nodes, return the second middle node.
* Example 1:
Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.
* Example 2:
Input: head = [1,2,3,4,5,6]
Output: [4,5,6]
Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
* */

import recursion.ListNode;

public class MiddleOfLinkedList {
    /*
    * Complexity Analysis:
        Time Complexity: O(N), where N is the number of nodes in the given list.
        Space Complexity: O(1), the space used by slow and fast.
    *
    * */
     public ListNode middleNode(ListNode head){
         ListNode slow = head, fast = head;
         while (slow != null && fast != null && fast.next != null){
             slow = slow.next;
             fast = fast.next.next;
         }

         return slow;
     }
}
