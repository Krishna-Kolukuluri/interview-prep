package ds.dstype.linkedListType;


public class MergeSortedLinkedList {

    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2){

        if(l1 == null && l2 != null) return l2;
        if(l1 != null && l2 == null) return l1;
        if(l1 == null && l2 == null) return null;

        ListNode result = new ListNode(-1); // sentinel
        ListNode pointer = result;

        while (l1 != null && l2 != null){
            if(l1.val < l2.val){
                pointer.next = l1;
                l1 = l1.next;
            }else{
                pointer.next = l2;
                l2 = l2.next;
            }
            pointer = pointer.next;
        }

        while (l1 != null){
            pointer.next = l1;
            pointer = pointer.next;
            l1 = l1.next;
        }

        while (l2 != null){
            pointer.next = l2;
            pointer = pointer.next;
            l2 =l2.next;
        }
        return result.next;
    }

}