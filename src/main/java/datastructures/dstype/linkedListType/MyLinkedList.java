package datastructures.dstype.linkedListType;
/*
https://leetcode.com/problems/design-linked-list/solution/
Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next
is a pointer/reference to the next node.
If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the
linked list. Assume all nodes in the linked list are 0-indexed.

Implement the MyLinkedList class:

MyLinkedList() Initializes the MyLinkedList object.
int get(int index) Get the value of the indexth node in the linked list. If the index is invalid, return -1.
void addAtHead(int val) Add a node of value val before the first element of the linked list. After the insertion, the
new node will be the first node of the linked list.
void addAtTail(int val) Append a node of value val as the last element of the linked list.
void addAtIndex(int index, int val) Add a node of value val before the indexth node in the linked list. If index equals
the length of the linked list, the node will be appended to the end of the linked list. If index is greater than the length,
the node will not be inserted.
void deleteAtIndex(int index) Delete the indexth node in the linked list, if the index is valid.
* */
class MyLinkedList {
    class ListNode {
        public int val;
        public ListNode previous, next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    int size;
    ListNode head, tail;

    public MyLinkedList() {
        size = 0;
        head = new ListNode(-1);
        tail = new ListNode(-1);

        head.next = tail;
        tail.previous = head;
    }

    //head <-> 1 <-> 2 <-> 3 <-> 4 <-> 5 <-> tail
    public int get(int index) {
        if(index < 0 || index >= size) {
            return -1;
        }
        ListNode current = head.next;
        for(int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.val;
    }

    public void addAtHead(int val) {
        ListNode toAdd = new ListNode(val);

        toAdd.next = head.next;
        toAdd.previous = head;

        head.next.previous = toAdd;
        head.next = toAdd;
        size++;
    }

    public void addAtTail(int val) {
        ListNode toAdd = new ListNode(val);

        toAdd.next = tail;
        toAdd.previous = tail.previous;

        tail.previous.next = toAdd;
        tail.previous = toAdd;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if(index < 0 || index > size) {
            return;
        }

        ListNode current = head.next;

        for(int i = 0; i < index; i++) {
            current = current.next;
        }

        ListNode toAdd = new ListNode(val);

        toAdd.previous = current.previous;
        toAdd.next = current;

        current.previous.next = toAdd;
        current.previous = toAdd;
        size++;
    }

    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size) {
            return;
        }

        ListNode current = head.next;
        for(int i = 0; i < index; i++) {
            current = current.next;
        }
        current.next.previous = current.previous;
        current.previous.next = current.next;
        size--;
    }
}
/*
Complexity Analysis

Time complexity: O(1) for addAtHead. O(k) for get, addAtIndex, and deleteAtIndex, where kk is an index of the element to
get, add or delete. O(N) for addAtTail.
Space complexity: O(1) for all operations.
* */