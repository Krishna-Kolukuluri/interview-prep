package ds.dstype.linkedListType;

public class RotateListRight {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        ListNode tail = head;                       //first, build a cycle
        while (tail.next != null){
            tail = tail.next;
        }
        tail.next = head;                          //cycle built.
        ListNode fast = head, slow = head;         //now find where to break the cycle
        while (k-->0){
            fast = fast.next;                      //move the fast runner first
        }
        while (fast!=tail){
            fast = fast.next;                      //then move the fast and the slow runners together
            slow = slow.next;
        }
        head = slow.next;                          //break the cycle at after the slow runner
        slow.next = null;
        return head;                              // return the new head
    }
}
