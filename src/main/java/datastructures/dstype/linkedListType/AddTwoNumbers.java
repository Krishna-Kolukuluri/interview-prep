package datastructures.dstype.linkedListType;
/*
*
* https://leetcode.com/problems/add-two-numbers/
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order,
and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.
*
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
* */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){

        ListNode result = new ListNode(0);
        ListNode pointer = result;
        int carry = 0;
        if(l1 != null && l2 == null) return l1;
        if(l1 == null && l2 != null) return l2;
        while (l1 != null || l2 != null || carry != 0){
            if(l1 != null){
                carry += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                carry += l2.val;
                l2 = l2.next;
            }
            pointer.next = new ListNode(carry%10);
            carry /= 10;
            pointer = pointer.next;
        }

        return result.next;
    }


    public ListNode addTwoNumbersBest(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
    /*
    *
    Complexity Analysis
    Time complexity : (max(m,n)). Assume that m and n represents the length of l1 and l2 respectively,
    the algorithm above iterates at most max(m,n) times.
    Space complexity : O(max(m,n)). The length of the new list is at most max(m,n)+1.
    *
    * */
}
