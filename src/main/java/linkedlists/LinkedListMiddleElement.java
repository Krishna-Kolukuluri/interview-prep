package linkedlists;

public class LinkedListMiddleElement {
    public static void main(String args[]) {

        LinkedListInsertion<Node> linkedlist = new LinkedListInsertion<Node>();
        linkedlist.insertAtEnd(new Node(5));
        linkedlist.insertAtEnd(new Node(8));
        linkedlist.insertAtEnd(new Node(9));
        linkedlist.insertAtEnd(new Node(15));
        linkedlist.insertAtEnd(new Node(4));
        linkedlist.printList();
        System.out.println("Count:  " + linkedlist.count);
        LinkedListMiddleElement middleElem = new LinkedListMiddleElement();
        Node node = middleElem.findMiddleNode(linkedlist.head);
        System.out.println(node.data);
    }
    
    Node findMiddleNode(Node node){
        Node mid = null;
        Node temp=node;
        Node temp1=null,temp2=temp;
        while(temp!=null){
            temp1=temp.next;
            if(temp1!=null&&temp2!=null&&temp2.next !=null){
                temp2=temp2.next.next;
            }
            if(temp2.next == null){
                return temp1;
            }
            temp=temp.next;
            
        }
        
        return mid;
    }

}
