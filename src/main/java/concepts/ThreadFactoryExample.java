package concepts;

import java.util.LinkedList;
import java.util.concurrent.ThreadFactory;

public class ThreadFactoryExample {
    public static void main(String[] args) {
        CustomThread customThread = new CustomThread();
        customThread.start();
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
