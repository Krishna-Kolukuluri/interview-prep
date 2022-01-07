package CommonProblems;

import recursion.ListNode;
/*
*
* Amazon-or-OA-or-LinkedListSum
Given a singly linkedlist like:
1->4->3->2

You have to calculate the sum of first and last elements like:
1+2 = 3
4+3 = 7

Then output the maximum sum. Here maximum sum is 7.

Space complexity should be O(1).
No constraint on time complexity.
*
* */
public class LinkedListMaxSum {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next = new ListNode(11);
        System.out.println(maxSumPair(head));
    }

    private static int maxSumPair(ListNode listNode){
        if(listNode == null) return 0;
        if(listNode.next == null) return listNode.val;
        ListNode slow = listNode;
        ListNode fast = listNode;
        while (fast!= null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode firstHalf = listNode;
        ListNode reversedSecondHalf = null;
        while (slow != null){
            ListNode nextNode = slow.next;
            slow.next = reversedSecondHalf;
            reversedSecondHalf = slow;
            slow = nextNode;
        }

        int maxSum = Integer.MIN_VALUE;
        while (firstHalf != null && reversedSecondHalf != null){
            maxSum =  Math.max(maxSum, firstHalf.val+ reversedSecondHalf.val);
            firstHalf = firstHalf.next;
            reversedSecondHalf = reversedSecondHalf.next;
        }
        return maxSum;
    }
}
