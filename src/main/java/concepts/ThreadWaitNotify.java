package concepts;

import java.util.concurrent.ThreadLocalRandom;

/*
* https://www.baeldung.com/java-wait-notify
* */
public class ThreadWaitNotify {
    public static void main(String[] args) {
        Data data = new Data();
        Thread sender = new Thread(new Sender(data));
        Thread receiver = new Thread(new Receiver(data));

        sender.start();
        receiver.start();
    }
}

/*
*
* Let's break down what's going on here:
    The packet variable denotes the data that is being transferred over the network.
    We have a boolean variable transfer, which the Sender and Receiver will use for synchronization:
        If this variable is true, the Receiver should wait for Sender to send the message.
    If it's false, Sender should wait for Receiver to receive the message.
    The Sender uses the send() method to send data to the Receiver:
        If transfer is false, we'll wait by calling wait() on this thread.
        But when it is true, we toggle the status, set our message, and call notifyAll() to wake up other threads to
        specify that a significant event has occurred and they can check if they can continue execution.
    Similarly, the Receiver will use the receive() method:
        If the transfer was set to false by Sender, only then will it proceed, otherwise we'll call wait() on this thread.
        When the condition is met, we toggle the status, notify all waiting threads to wake up, and return the data packet that was received.
* */
class Data{
    private String packet;

    // True if receiver should wait
    // False if sender should wait
    private boolean transfer = true;

    public synchronized String receive() {
        while (transfer) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread Interrupted");
            }
        }
        transfer = true;

        String returnPacket = packet;
        notifyAll();
        return returnPacket;
    }

    public synchronized void send(String packet) {
        while (!transfer) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread Interrupted");
            }
        }
        transfer = false;

        this.packet = packet;
        notifyAll();
    }
}

/*
* Let's take a closer look at this Sender:
    We're creating some random data packets that will be sent across the network in packets[] array.
    For each packet, we're merely calling send().
    Then we're calling Thread.sleep() with random interval to mimic heavy server-side processing.
*
* */
class Sender implements Runnable{
    private Data data;

    // standard constructors

    public Sender(Data data){
        this.data = data;
    }

    public void run() {
        String packets[] = {
                "First packet",
                "Second packet",
                "Third packet",
                "Fourth packet",
                "End"
        };

        for (String packet : packets) {
            data.send(packet);

            // Thread.sleep() to mimic heavy server-side processing
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread interrupted" +  e);
            }
        }
    }
}


/*
* Here, we're simply calling load.receive() in the loop until we get the last “End” data packet.
* */
class Receiver implements Runnable{
    private Data load;

    // standard constructors
    public Receiver(Data data){
        this.load = data;
    }

    public void run() {
        for(String receivedMessage = load.receive();
            !"End".equals(receivedMessage);
            receivedMessage = load.receive()) {

            System.out.println(receivedMessage);

            // ...
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread interrupted" +  e);
            }
        }
    }
}