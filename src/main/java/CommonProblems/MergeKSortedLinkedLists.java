package CommonProblems;

import recursion.ListNode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/*
* https://leetcode.com/problems/merge-k-sorted-lists/solution/
* You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
* Merge all the linked-lists into one sorted linked-list and return it.
*
Example 1:
Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
* */
public class MergeKSortedLinkedLists {
    public static void main(String[] args) {

    }

    public static ListNode mergeKLists(ListNode[] lists){
        Queue<ListNode> queue = new PriorityQueue<ListNode>((A,B) -> A.val - B.val);
        Arrays.stream(lists).forEach(list -> {
            if(list != null){
                queue.offer(list);
            }
        });

        ListNode head = new ListNode(0);
        ListNode point = head;
        while (!queue.isEmpty()){
            point.next = queue.poll();
            point = point.next;
            ListNode next = point.next;
            if(next != null){
                queue.offer(next);
            }
        }
        return head.next;
    }
    /*
    * Complexity Analysis:
        Time complexity : O(Nlogk) where k is the number of linked lists.
        The comparison cost will be reduced to O(logk) for every pop and insertion to priority queue. But finding the
        node with the smallest value just costs O(1) time.
        There are N nodes in the final linked list.

        Space complexity :
        O(n) Creating a new linked list costs O(n) space.
        O(k) The code above present applies in-place method which cost O(1) space. And the priority queue (often implemented with heaps)
        costs O(k) space (it's far less than N in most situations).
    * */
}
