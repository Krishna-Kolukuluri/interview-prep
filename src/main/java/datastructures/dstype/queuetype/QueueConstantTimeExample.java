package datastructures.dstype.queuetype;

public class QueueConstantTimeExample {
    public static void main(String[] args) {
        QueueWithConstantTime queue = new QueueWithConstantTime();
        queue.offer(10);
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        queue.offer(100);
        System.out.println(queue.peek());
        queue.offer(1000);
        //System.out.println(queue.peek());
        queue.offer(10000);
        System.out.println("peek" +  queue.peek());
        System.out.println("poll" +  queue.poll());
        System.out.println( "poll" + queue.poll());
        System.out.println("poll" + queue.poll());
        System.out.println("poll" + queue.poll());
        System.out.println("peek" + queue.poll());
    }
}
