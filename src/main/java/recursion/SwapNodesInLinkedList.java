package recursion;

public class SwapNodesInLinkedList {

    public ListNode swapNodePairsRec(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode tempNode = head.next;
        head.next = swapNodePairsRec(head.next.next);
        tempNode.next = head;
        return tempNode;
    }


    public ListNode swapNodePairsIter(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = head;
        ListNode newHead = head.next;
        while (cur != null && cur.next != null) {
            ListNode tmp = cur;
            cur = cur.next;
            tmp.next = cur.next;
            cur.next = tmp;
            cur = tmp.next;
            if (cur != null && cur.next != null) tmp.next = cur.next;
        }
        return newHead;
    }
}
