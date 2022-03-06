package patterns.general;

import datastructures.dstype.linkedListType.ListNode;

/*
* Implement Queue with O(1) Time Complexity for pop, push and peek operations.
* using Linked list
* Can you implement the queue such that each operation is amortized O(1) time complexity? In other words,
* performing n operations will take overall O(n) time even if one of those operations may take longer.
* O(1) TC for pop, push and peek operations.
* */
public class QueueWithLinkedList {
    private ListNode head, tail;

    /*
    * O(1) TC:
    * */
    public void push(int x){
        if(head == null){
            head = new ListNode(x, null);
            tail = head;
        }else {
            tail.next = new ListNode(x, null);
            tail = tail.next;
        }
    }

    /*
    * TC: O(1)
    * */
    public int pop(){
        int val = head.val;
        head = head.next;
        return val;
    }

    /*
     * TC: O(1)
     * */
    public int peek(){
        return head.val;
    }

    /*
    * TC: O(1)
    * */
    public boolean isEmpty(){
        if(head == null){
            return true;
        }
        else {
            return false;
        }
    }
}
