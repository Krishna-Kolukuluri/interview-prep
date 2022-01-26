package linkedlists;

public class LinkedListDeletion {
    
    Node head;

    public void insertAtBegin(Node data) {
        if (head == null) {
            head = (Node) data;
        } else {
            Node temp=head;
           head = (Node) data;
           head.next = temp;
        }
    }
    public static void main(String args[]) {
        LinkedListDeletion linkedlist = new LinkedListDeletion();
        linkedlist.insertAtBegin(new Node(5));
        linkedlist.insertAtBegin(new Node(10));
        linkedlist.insertAtBegin(new Node(6));
        linkedlist.insertAtBegin(new Node(15));
        System.out.println(linkedlist.deleteNode(linkedlist.head, 6));
        linkedlist.printList();
        
    }
    
    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    
    boolean deleteNode(Node data,int val){
        Node temp =data;
        Node prevNode = null;
        while(temp!=null){
            if(temp.data == val){
                prevNode.next=temp.next;
                return true;
            }
            prevNode = temp;
            temp=temp.next;
        }
        return false;
    }

}
