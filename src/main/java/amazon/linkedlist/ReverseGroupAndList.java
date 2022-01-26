package amazon.linkedlist;

public class ReverseGroupAndList {
    
    public static void main(String args[]) {
        ListNode l1=new ListNode();
        l1.insertAtEnd(new ListNode(2));
        l1.insertAtEnd(new ListNode(4));
        l1.insertAtEnd(new ListNode(3));
        l1.insertAtEnd(new ListNode(8));
        l1.insertAtEnd(new ListNode(5));
        l1.insertAtEnd(new ListNode(7));
        l1.insertAtEnd(new ListNode(9));
        l1.insertAtEnd(new ListNode(1));
        printList(reverseLinkedList(l1,3));
        printList(reverseKGroup(l1,3));
    }
    
    static void printList(ListNode node) {
        ListNode temp = node;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
 public static ListNode reverseLinkedList(ListNode head, int k) {
        
        // Reverse k nodes of the given linked list.
        // This function assumes that the list contains 
        // atleast k nodes.
        ListNode new_head = null;
        ListNode ptr = head;
        
        while (k > 0) {
            
            // Keep track of the next node to process in the
            // original list
            ListNode next_node = ptr.next;
            
            // Insert the node pointed to by "ptr"
            // at the beginning of the reversed list
            ptr.next = new_head;
            new_head = ptr;
            
            // Move on to the next node
            ptr = next_node;
            
            // Decrement the count of nodes to be reversed by 1
            k--;
        }
            
            
        // Return the head of the reversed list
        return new_head;
    
    }
            
    public static ListNode reverseKGroup(ListNode head, int k) {
        
        int count = 0;
        ListNode ptr = head;
        
        // First, see if there are atleast k nodes
        // left in the linked list.
        while (count < k && ptr != null) {
            ptr = ptr.next;
            count++;
        }
            
        
        // If we have k nodes, then we reverse them
        if (count == k) {
            
            // Reverse the first k nodes of the list and
            // get the reversed list's head.
            ListNode reversedHead = reverseLinkedList(head, k);//this.reverseLinkedList(head, k);
            
            // Now recurse on the remaining linked list. Since
            // our recursion returns the head of the overall processed
            // list, we use that and the "original" head of the "k" nodes
            // to re-wire the connections.
            head.next = reverseKGroup(ptr, k);//this.reverseKGroup(ptr, k);
            return reversedHead;
        }
            
        return head;
    }
}
