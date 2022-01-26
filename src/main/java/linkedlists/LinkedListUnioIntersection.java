package linkedlists;

public class LinkedListUnioIntersection {

    public static void main(String args[]){
        LinkedListInsertion<Node> linkedlist = new LinkedListInsertion<Node>();
        linkedlist.insertAtEnd(new Node(5));
        linkedlist.insertAtEnd(new Node(8));
        linkedlist.insertAtEnd(new Node(9));
        linkedlist.insertAtEnd(new Node(4));
        
        LinkedListInsertion<Node> linkedlist2 = new LinkedListInsertion<Node>();
        linkedlist2.insertAtEnd(new Node(6));
        linkedlist2.insertAtEnd(new Node(8));
        linkedlist2.insertAtEnd(new Node(19));
        linkedlist2.insertAtEnd(new Node(42));
        
        printList(unionLinkedLists(linkedlist.head,linkedlist2.head));
    }
    
   static Node unionLinkedLists(Node node1,Node node2){
       Node unionnode=null;;
       while(true){
           
           if (node1 == null) {
               unionnode.next = node2;
               break;
           }
           if (node2 == null) {
               unionnode.next = node1;
               break;
           }
           if(unionnode == null)
               unionnode=node1;
           else
               unionnode.next=node1;
           node1=node1.next;
       }
        
        return unionnode;
        
    }
    
  static Node sortedMerge(Node headA, Node headB) {

       Node dummyNode = new Node(0);

       Node tail = dummyNode;
       while (true) {

           if (headA == null) {
               tail.next = headB;
               break;
           }
           if (headB == null) {
               tail.next = headA;
               break;
           }

           if (headA.data <= headB.data) {
               tail.next = headA;
               headA = headA.next;
           } else {
               tail.next = headB;
               headB = headB.next;
           }

           tail = tail.next;
       }
       return dummyNode.next;
   }
   
   
    static void printList(Node node) {
        Node temp = node;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
