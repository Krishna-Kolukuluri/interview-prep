package datastructures.dstype.queuetype;
/*
* Implement Queue with Time complexity of both operations enqueue()(offer()) and dequeue()(poll()) is O(1).
* */
public class QueueWithConstantTime {
    private QueueNode root, tail;
    public QueueWithConstantTime(){
        this.root = null;
        this.tail = null;
    }
    public void offer(int key){
        //Create new tempNode
        QueueNode node = new QueueNode(key);
        //check if queue is empty, then node will be both root and tail
        if(this.tail == null){
            this.root = this.tail = node;
            return;
        }
        //Add new node at the end of the queue and change tail
        this.tail.next = node;
        this.tail = node;
    }

    public Integer poll(){
        //if queue is empty, return null
        if(this.root == null){
            return null;
        }

        QueueNode node = this.root;
        this.root = this.root.next;

        //If root becomes NULL, then change tail also NULL
        if(this.root == null){
            this.tail = null;
        }
        return node.key;
    }

    public Integer peek(){
        if(this.root == null){
            return null;
        }
        return this.root.key;
    }
}
class QueueNode{
    int key;
    QueueNode next;
    public QueueNode(int key){
        this.key = key;
        this.next = null;
    }
}
