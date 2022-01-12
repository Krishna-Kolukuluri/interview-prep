package concepts;

import java.util.LinkedList;
import java.util.concurrent.ThreadFactory;
/*
Thread.start() vs Thread.run() differences:

Even if programmatically we are not creating any thread, For every application, O.S will create a default thread to execute its code with CPU.
Calling run method directly will make that run method execute in that main thread given by O.S.

But the intention of creating a thread class is to make sure that run method executes in a different thread. Unless
thread manager of O.S creates a thread, your run method will not get executed in a separate thread. To request O.S to
create the separate thread you have to call start() method which will send a request to O.S to create a thread. Once O.S
creates a thread, then O.S will automatically call run method of your thread class in that newly created thread context.
And hence your purpose of creating a separate thread and executing your run method in a separate thread will be served.

If you call run method directly, then it is like O.S is not creating any thread for you, and default main thread will
execute your run method. No point of creating a separate thread class for that!

Hope I am clear. Let me know if you need more explanation to answer your question.
Note: Though books say JVM creates threads, internally JVM will have to send a request to thread manager driver of O.S
layer to create a new thread in its thread pool. That's why I use O.S term more here than JVM.
* */
public class ThreadFactoryExample {
    public static void main(String[] args) {
        CustomThread customThread = new CustomThread();
        //Starts a new thread and runs the thread
        customThread.start();
        //Doesn't starts new thread instead it runs on the same thread, which defeats the purpose of declaring new thread.
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
