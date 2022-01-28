package recursion;
/*
https://leetcode.com/problems/merge-two-sorted-lists/
* You are given the heads of two sorted linked lists list1 and list2.
Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
Return the head of the merged linked list.
*
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
* */
public class MergeSortedLinkedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if(l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        }
        else if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
/*
Complexity Analysis:
Time complexity : O(n + m)O(n+m)
    Because each recursive call increments the pointer to l1 or l2 by one (approaching the dangling null at the end of each list),
    there will be exactly one call to mergeTwoLists per element in each list. Therefore, the time complexity is linear in the combined size of the lists.

Space complexity : O(n + m)O(n+m)
    The first call to mergeTwoLists does not return until the ends of both l1 and l2 have been reached, so n + mn+m stack
    frames consume O(n + m)O(n+m) space.
* */
    public ListNode mergeSortedLinkedLists(ListNode l1, ListNode l2){
        ListNode preHead = new ListNode(-1);
        ListNode prev = preHead;
        while (l1 != null && l2 != null){
            if(l1.val < l2.val){
                prev.next = l1;
                l1 = l1.next;
            }else {
                prev.next  = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        // Exactly one of l1 and l2 can still have nodes at this point, so connect
        // the non-null list to the end of the merged list.
        prev.next = l1 == null? l2 : l1;

        return preHead.next;
    }
}
