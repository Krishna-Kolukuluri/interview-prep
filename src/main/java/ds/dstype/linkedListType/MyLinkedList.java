package ds.dstype.linkedListType;

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
