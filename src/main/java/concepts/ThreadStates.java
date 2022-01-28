package concepts;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

enum State {
    /**
     * Thread state for a thread which has not yet started.
     */
    NEW,

    /**
     * Thread state for a runnable thread.  A thread in the runnable
     * state is executing in the Java virtual machine but it may
     * be waiting for other resources from the operating system
     * such as processor.
     */
    RUNNABLE,

    /**
     * Thread state for a thread blocked waiting for a monitor lock.
     * A thread in the blocked state is waiting for a monitor lock
     * to enter a synchronized block/method or
     * reenter a synchronized block/method after calling
     * {@link Object#wait() Object.wait}.
     */
    BLOCKED,

    /**
     * Thread state for a waiting thread.
     * A thread is in the waiting state due to calling one of the
     * following methods:
     * <ul>
     *   <li> wait() with no timeout</li>
     *   <li> join() with no timeout</li>
     *   <li>{@link LockSupport#park() LockSupport.park}</li>
     * </ul>
     *
     * <p>A thread in the waiting state is waiting for another thread to
     * perform a particular action.
     *
     * For example, a thread that has called {@code Object.wait()}
     * on an object is waiting for another thread to call
     * {@code Object.notify()} or {@code Object.notifyAll()} on
     * that object. A thread that has called {@code Thread.join()}
     * is waiting for a specified thread to terminate.
     */
    WAITING,

    /**
     * Thread state for a waiting thread with a specified waiting time.
     * A thread is in the timed waiting state due to calling one of
     * the following methods with a specified positive waiting time:
     * <ul>
     *   <li> </li>
     *   <li>{@link Object#wait(long) Object.wait} with timeout</li>
     *   <li> sleep() </li>
     *   <li> wait() with timeout</li>
     *   <li> join() with timeout</li>
     *   <li>{@link LockSupport#parkNanos LockSupport.parkNanos}</li>
     *   <li>{@link LockSupport#parkUntil LockSupport.parkUntil}</li>
     * </ul>
     */
    TIMED_WAITING,

    /**
     * Thread state for a terminated thread.
     * The thread has completed execution.
     */
    TERMINATED;
}
public class ThreadStates {
    public static void main(String[] args) throws InterruptedException {
        checkThreadStates();
    }
    private static void checkThreadStates() throws InterruptedException {
        Thread thread = new Thread(new TestRunnable());
        thread.start();
        //thread.run() --> do not call run() method directly, use thread.start() instead.
        thread.interrupt(); //interrupts the thread;
        System.out.println("thread.isInterrupted() -> " + thread.isInterrupted());
        thread.interrupt();
        System.out.println("thread.interrupted() -> " + thread.interrupted());

        Thread thread2 = new Thread(new TestRunnable());
        thread2.start();
        System.out.println("thread2.getState() -> " + thread2.getState());
        thread.yield();
        System.out.println("thread2.getState() -> " + thread2.getState());
        thread2.join();
        thread.yield();
        System.out.println("thread.getState() -> " + thread.getState());
        thread.setPriority(100);
        thread2.setPriority(1000);
    }
}
class TestRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Calling runnable run method");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}