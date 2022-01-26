package linkedlists;

public class LinkedListInsertion<T> {
    Node head;
    int count = 0;
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
    public void insertAtBegin(T data) {
        if (head == null) {
            head = (Node) data;
        } else {
            Node temp = head;
            head = (Node) data;
            head.next = temp;
        }
    }
    void printList() {
        count = 0;
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
            count++;
        }
        System.out.println();
    }
    static void printList(Node node) {
        Node temp = node;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String args[]) {
        LinkedListInsertion<Node> ll = new LinkedListInsertion<Node>();
        ll.insertAtEnd(new Node(5));
        ll.insertAtEnd(new Node(8));
        ll.insertAtEnd(new Node(9));
        ll.printList();
        System.out.println("Count:  " + ll.count);
        LinkedListInsertion<Node> ll2 = new LinkedListInsertion<Node>();
        ll2.insertAtBegin(new Node(10));
        ll2.insertAtBegin(new Node(15));
        ll2.printList();
        System.out.println("Count:  " + ll2.count);
    }
}
