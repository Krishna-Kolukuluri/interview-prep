package amazon.linkedlist;


public class AddTwoSum {
    public static void main(String args[]) {
        ListNode l1=new ListNode();
        l1.insertAtEnd(new ListNode(2));
        l1.insertAtEnd(new ListNode(4));
        l1.insertAtEnd(new ListNode(3));
        ListNode l2=new ListNode();
        l2.insertAtEnd(new ListNode(5));
        l2.insertAtEnd(new ListNode(6));
        l2.insertAtEnd(new ListNode(4));
        printList(addTwoNumbers(l1,l2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode p = l1, q = l2, curr = node;
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
        return node.next;
    }
    static void printList(ListNode node) {
        ListNode temp = node;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
