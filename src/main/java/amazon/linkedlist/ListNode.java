package amazon.linkedlist;


public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
    
    public <T> void insertAtEnd(T data) {
        if (next == null) {
            next = (ListNode) data;
        } else {
            ListNode temp = next;
            while (temp.next != null)
                temp = temp.next;
            temp.next = (ListNode) data;
        }
    }
}
