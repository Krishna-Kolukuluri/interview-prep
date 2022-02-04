package linkedlists;

public class LinkedListReverse {
    Node head;

    public <T> void insertAtEnd(T data) {
        if (head == null) {
            head = (Node) data;
        } else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = (Node) data;
        }
    }

    void printList(Node node) {
        Node temp = node;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String args[]) {
        LinkedListReverse linkedlist = new LinkedListReverse();
        linkedlist.insertAtEnd(new Node(5));
        linkedlist.insertAtEnd(new Node(8));
        linkedlist.insertAtEnd(new Node(9));
        linkedlist.printList(linkedlist.head);
        Node newlist = linkedlist.reverse(linkedlist.head);
        linkedlist.printList(newlist);
    }

    public Node reverse(Node node) {
        Node next = null, prev = null, data = node;
        while (data != null) {
            next = data.next;
            data.next = prev;
            prev = data;
            data = next;
        }
        node = prev;
        return node;
    }
}
