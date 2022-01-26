package linkedlists;

public class LinkedListDuplicates {
    public static void main(String args[]) {
        LinkedListInsertion<Node> linkedlist = new LinkedListInsertion<Node>();
        linkedlist.insertAtEnd(new Node(5));
        linkedlist.insertAtEnd(new Node(8));
        linkedlist.insertAtEnd(new Node(9));
        linkedlist.insertAtEnd(new Node(5));
        linkedlist.insertAtEnd(new Node(4));
        linkedlist.insertAtEnd(new Node(9));
        removeDuplicates(linkedlist.head);
        printList(linkedlist.head);
    }
    
    static void removeDuplicates(Node node){
        Node temp = node; 
        Node temp2 = null;   

        while (temp != null && temp.next != null) {
            temp2 = temp;
            while (temp2.next != null) {
                if (temp.data==temp2.next.data) { 
                    temp2.next = temp2.next.next;
                } else {
                    temp2 = temp2.next;
                }
            }
            temp = temp.next;
        }
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
