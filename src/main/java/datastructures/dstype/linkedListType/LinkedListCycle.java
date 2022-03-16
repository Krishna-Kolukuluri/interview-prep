package datastructures.dstype.linkedListType;
/*
* https://leetcode.com/problems/linked-list-cycle/
* Given head, the head of a linked list, determine if the linked list has a cycle in it
There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following
the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to.
Note that pos is not passed as a parameter.
Return true if there is a cycle in the linked list. Otherwise, return false.
* */
public class LinkedListCycle {
    public static boolean hasCycle(ListNode head){
        if(head == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    //Linked List Cycle Node
    public static ListNode detectCycle(ListNode head){
        if(head == null || head.next == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode target = head;

        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                while (target != fast){
                    target = target.next;
                    fast = fast.next;
                }
                return target;
            }
        }
        return null;
    }

    //Intersection of Two Linked Lists
    public ListNode intersectionNode(ListNode headA, ListNode headB){

        int aLength = length(headA);
        int bLength = length(headB);
        if(aLength > bLength){
            headA = advanceByK(headA, aLength - bLength);
        }else{
            headB = advanceByK(headB, bLength - aLength);
        }
        while (headA != null && headB != null && headA != headB){
            headA =headA.next;
            headB = headB.next;
        }
        return headA;
    }
    private int length(ListNode node){
        int len = 0;
        while (node != null){
            node = node.next;
            len++;
        }
        return len;
    }

    private ListNode advanceByK(ListNode node, int index){
        while (index-- > 0){
            node = node.next;
        }
        return node;
    }
    //Intersection of Two Linked Lists

    //Remove Nth Node From End of List
    public ListNode removeNthFromEnd(ListNode head, int n){
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode a = newHead;
        ListNode b = newHead;
        while (n > 0){
            b = b.next;
             n--;
        }
        while (b.next != null){
            b = b.next;
            a = a.next;
        }
        a.next = a.next.next;
        return newHead.next;
    }
    //Remove Nth Node From End of List


    public ListNode reverseList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode node = head;
        ListNode prev = null;
        ListNode reversed = null;

        while (node != null){
            ListNode next = node.next;
            if(node.next == null){
                reversed = node;
            }
            node.next = prev;
            prev = node;
            node = next;
        }
        return reversed;
    }

    public ListNode reverseListRecursion(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode reversedHead = reverseListRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return reversedHead;
    }
    /*
    * https://leetcode.com/problems/remove-linked-list-elements/
    * Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.
    * */
    public ListNode removeElements(ListNode head, int val){
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode curr = head;
        ListNode prev = fakeHead;
        while (curr != null){
            if(curr.val == val){
                prev.next = curr.next;
            }else {
                prev = prev.next;
            }
            curr = curr.next;
        }
        return fakeHead.next;
    }
    /*
    * Complexity Analysis:
        Time complexity: O(N), it's one pass solution.
        Space complexity: O(1), it's a constant space solution.
    * */


    public ListNode oddEvenList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode p1 = head, p2 = head.next, prev = p2;
        while (p2 != null && p2.next != null){
            p1.next = p2.next;
            p1 = p1.next;
            p2.next = p1.next;
            p2 = p2.next;
        }
        p1.next = prev;
        return head;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) { // odd nodes: let right half smaller
            slow = slow.next;
        }
        slow = reverse(slow);
        fast = head;

        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}

