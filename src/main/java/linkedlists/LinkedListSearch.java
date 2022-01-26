package linkedlists;

public class LinkedListSearch<T> {
    Node head;

    public void insertAtEnd(T data) {
        if (head == null) {
            head = (Node) data;
        } else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = (Node) data;
        }
    }

    public static void main(String args[]) {
        LinkedListSearch<Node> linkedlist = new LinkedListSearch<Node>();
        linkedlist.insertAtEnd(new Node(5));
        linkedlist.insertAtEnd(new Node(10));
        linkedlist.insertAtEnd(new Node(6));
        linkedlist.insertAtEnd(new Node(15));
        System.out.println(linkedlist.searchNode(linkedlist.head, 6));
    }

    public boolean searchNode(Node data, int val) {
        Node temp = data;
        while (temp != null) {
            if (temp.data == val) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
}
