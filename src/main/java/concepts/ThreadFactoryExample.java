package concepts;

import java.util.LinkedList;
import java.util.concurrent.ThreadFactory;

public class ThreadFactoryExample {
    public static void main(String[] args) {
        CustomThread customThread = new CustomThread();
        //Starts a new thread and runs the thread
        customThread.start();
        //Doesn't stat new thread instead it runs on the same thread, which defeats the purpose of declaring new thread.
        //customThread.run();
        Task task = new Task();
        task.run();
    }
}
//Creating Thread by extending Thread class
class CustomThread extends Thread{
    @Override
    public void run(){
        System.out.println("CustomThread Class Run()");
    }
}
//Creating Task/Thread by implementing Runnable interface
class Task implements Runnable{

    @Override
    public void run() {
        System.out.println("Task Class Run()");
    }
}

class CustomThreadFactory implements ThreadFactory{

    // newThread is a factory method
    // provided by ThreadFactory
    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r);
    }
}
