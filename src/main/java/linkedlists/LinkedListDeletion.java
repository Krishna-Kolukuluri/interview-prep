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
        LinkedListDeletion linkedList = new LinkedListDeletion();
        linkedList.insertAtBegin(new Node(5));
        linkedList.insertAtBegin(new Node(10));
        linkedList.insertAtBegin(new Node(6));
        linkedList.insertAtBegin(new Node(15));
        System.out.println(linkedList.deleteNode(linkedList.head, 6));
        linkedList.printList();
        
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
