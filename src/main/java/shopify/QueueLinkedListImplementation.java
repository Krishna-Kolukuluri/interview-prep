package shopify;


//Java program for linked-list implementation of queue

//A linked list (LL) node to store a queue entry
class QNode {
    int key;
    QNode next;

    // constructor to create a new linked list node
    public QNode(int key)
    {
        this.key = key;
        this.next = null;
    }
}

//A class to represent a queue
//The queue, front stores the front node of LL and rear stores the
//last node of LL
class Queue {
    QNode front, rear;

    public Queue()
    {
        this.front = this.rear = null;
    }

    // Method to add an key to the queue.
    void add(int key)
    {

        // Create a new LL node
        QNode temp = new QNode(key);

        // If queue is empty, then new node is front and rear both
        if (this.rear == null) {
            this.front = this.rear = temp;
            return;
        }

        // Add the new node at the end of queue and change rear
        this.rear.next = temp;
        this.rear = temp;
    }

    // Method to remove an key from queue.
    void remove()
    {
        // If queue is empty, return NULL.
        if (this.front == null)
            return;

        // Store previous front and move front one node ahead
        QNode temp = this.front;
        this.front = this.front.next;

        // If front becomes NULL, then change rear also as NULL
        if (this.front == null)
            this.rear = null;
    }
}


public class QueueLinkedListImplementation {
    public static void main(String[] args)
    {
        Queue q = new Queue();
        q.add(10);
        q.add(20);
        q.remove();
        q.remove();
        q.add(30);
        q.add(40);
        q.add(50);
        q.remove();
        System.out.println("Queue Front : " + q.front.key);
        System.out.println("Queue Rear : " + q.rear.key);
    }
}
