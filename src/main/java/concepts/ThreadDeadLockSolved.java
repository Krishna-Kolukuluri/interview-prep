package concepts;
/**
Deadlocks cannot be completely resolved. But we can avoid them by following basic rules
        mentioned below:

        Avoid Nested Locks: We must avoid giving locks to multiple threads, this is the main reason
        for a deadlock condition. It normally happens when you give locks to multiple threads.
        Avoid Unnecessary Locks: The locks should be given to the important threads. Giving locks
        to the unnecessary threads that cause the deadlock condition.
        Using Thread Join: A deadlock usually happens when one thread is waiting for the other
        to finish. In this case, we can use join with a maximum time that a thread will take.
**/

//Let's change the order of the lock and run
// of the same program to see if both the threads still wait for each other
public class ThreadDeadLockSolved {
    public static Object Lock1 = new Object();
    public static Object Lock2 = new Object();

    public static void main(String args[]) {
        ThreadDemo1 T1 = new ThreadDemo1();
        ThreadDemo2 T2 = new ThreadDemo2();
        T1.start();
        T2.start();
    }

    private static class ThreadDemo1 extends Thread {
        public void run() {
            synchronized (Lock1) {
                System.out.println("Thread 1: Holding lock 1...");

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {}
                System.out.println("Thread 1: Waiting for lock 2...");

                synchronized (Lock2) {
                    System.out.println("Thread 1: Holding lock 1 & 2...");
                }
            }
        }
    }
    private static class ThreadDemo2 extends Thread {
        public void run() {
            synchronized (Lock1) {
                System.out.println("Thread 2: Holding lock 1...");

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {}
                System.out.println("Thread 2: Waiting for lock 2...");

                synchronized (Lock2) {
                    System.out.println("Thread 2: Holding lock 1 & 2...");
                }
            }
        }
    }
}
