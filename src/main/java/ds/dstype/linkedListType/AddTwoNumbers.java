package ds.dstype.linkedListType;

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
}
