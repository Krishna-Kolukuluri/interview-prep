package linkedlists;

import java.util.HashSet;

public class LinkedListDetectLoop {
    Node head;

    public void insertAtEnd(Node data) {
        if (head == null) {
            head = (Node) data;
        } else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = (Node) data;
        }
    }
    public void createLoop(Node node){
        node.next.next.next.next = node;
    }
    
    void printList(Node node) {
        Node temp = node;
        while (temp != null) {
            System.out.println(temp.data + " "+temp.next);
            temp = temp.next;
        }
        System.out.println();
    }
    public boolean detectLoop(Node node){
        HashSet<Node> allNodes = new HashSet<Node>();
        while(node !=null){
            if(allNodes.contains(node))
                return true;
            allNodes.add(node);
            node = node.next;
        }
        return false;
    }

    public static void main(String args[]) {
        LinkedListDetectLoop linkedlist = new LinkedListDetectLoop();
        linkedlist.insertAtEnd(new Node(5));
        linkedlist.insertAtEnd(new Node(10));
        linkedlist.insertAtEnd(new Node(6));
        linkedlist.insertAtEnd(new Node(15));
        linkedlist.createLoop(linkedlist.head);
//        linkedlist.printList(linkedlist.head);
        System.out.println(linkedlist.detectLoop(linkedlist.head));
    }

}
