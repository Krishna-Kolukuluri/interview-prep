package concepts;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadExecutors threadExecutors = new ThreadExecutors();
        threadExecutors.getSingleThreadExecutor();
        threadExecutors.getFixedThreadPool();
        ThreadPoolExecutorExample poolExecutorExample = new ThreadPoolExecutorExample();
        poolExecutorExample.getFixedThreadPool();
        poolExecutorExample.getCachedThreadPool();
        ScheduledThreadPoolExecutorExample scheduledExecutor = new ScheduledThreadPoolExecutorExample();
        scheduledExecutor.getScheduledThreadPool();
    }
}

class ThreadExecutors{
    public void getSingleThreadExecutor(){
        //The Executors' helper class contains several methods for the creation of preconfigured thread pool instances
        //The Executor interface has a single execute method to submit Runnable instances for execution.

        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> System.out.println("Using Executor to start new thread and run task"));
        /*
         * The Executors.newSingleThreadExecutor() API creates another typical form of ThreadPoolExecutor containing a
         * single thread. The single thread executor is ideal for creating an event loop. The corePoolSize and maximumPoolSize
         * parameters are equal to 1, and the keepAliveTime is 0.
         * Tasks in the above example will be run sequentially, so the flag value will be 2 after the task's completion:
         * */
        AtomicInteger counter = new AtomicInteger();
        ExecutorService executorService =  Executors.newSingleThreadExecutor();
        executorService.submit(() -> counter.set(1));
        executorService.submit(() -> counter.compareAndSet(1, 2));
        executorService.shutdownNow();
    }

    public void getFixedThreadPool() throws ExecutionException, InterruptedException {
        /*
        * The ExecutorService interface contains a large number of methods to control the progress of the tasks and manage
        * the termination of the service. Using this interface, we can submit the tasks for execution and also control
        * their execution using the returned Future instance.
        * */
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future<String> future = executorService.submit(() -> "Using ExecutorService to with 5 threads in a pool and run task");
        String result = future.get();
        System.out.println(result);
        executorService.shutdownNow();
    }
}

class ThreadPoolExecutorExample{
    /*
    * The ThreadPoolExecutor is an extensible thread pool implementation with lots of parameters and hooks for fine-tuning.
      The main configuration parameters that we'll discuss here are corePoolSize, maximumPoolSize and keepAliveTime.
    * The pool consists of a fixed number of core threads that are kept inside all the time. It also consists of some excessive
      threads that may be spawned and then terminated when they are no longer needed.
    * The corePoolSize parameter is the number of core threads that will be instantiated and kept in the pool. When a new task
      comes in, if all core threads are busy and the internal queue is full, the pool is allowed to grow up to maximumPoolSize.
    * The keepAliveTime parameter is the interval of time for which the excessive threads (instantiated in excess of the corePoolSize)
      are allowed to exist in the idle state. By default, the ThreadPoolExecutor only considers non-core threads for removal.
      In order to apply the same removal policy to core threads, we can use the allowCoreThreadTimeOut(true) method.
    * These parameters cover a wide range of use cases, but the most typical configurations are predefined in the Executors static methods
    * */
    public void getFixedThreadPool(){
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        threadPoolExecutor.setKeepAliveTime(6, TimeUnit.SECONDS);
        threadPoolExecutor.submit(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("Thread 1");
            }catch (InterruptedException ex){
                System.out.println("InterruptedException");
            }
        });
        threadPoolExecutor.submit(() -> {
            try {
                Thread.sleep(12000);
                System.out.println("Thread 2");
            }catch (InterruptedException ex){
                System.out.println("InterruptedException");
            }
        });
        threadPoolExecutor.submit(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("Thread 3");
            }catch (InterruptedException ex){
                System.out.println("InterruptedException");
            }
        });
        System.out.println("pool-size -> "+ threadPoolExecutor.getPoolSize());
        System.out.println("task-queue-size -> "+ threadPoolExecutor.getQueue().size());
    }
    public void getCachedThreadPool(){
        /*
        * This method does not receive a number of threads at all. We set the corePoolSize to 0 and set the maximumPoolSize
        * to Integer.MAX_VALUE. Finally, the keepAliveTime is 60 seconds:
        * */
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        System.out.println(threadPoolExecutor.getKeepAliveTime(TimeUnit.SECONDS));

        threadPoolExecutor.submit(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("Thread 1");
            }catch (InterruptedException ex){
                System.out.println("InterruptedException");
            }
        });
        threadPoolExecutor.submit(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("Thread 2");
            }catch (InterruptedException ex){
                System.out.println("InterruptedException");
            }
        });
        threadPoolExecutor.submit(() -> {
            try {
                Thread.sleep(3000);
                System.out.println("Thread 3");
            }catch (InterruptedException ex){
                System.out.println("InterruptedException");
            }
        });
        System.out.println("getPoolSize -> " + threadPoolExecutor.getPoolSize());
        System.out.println("getCorePoolSize -> " + threadPoolExecutor.getCorePoolSize());
        System.out.println("getMaximumPoolSize -> " + threadPoolExecutor.getMaximumPoolSize());
        System.out.println("getActiveCount -> " + threadPoolExecutor.getActiveCount());
        System.out.println("pool-size -> "+ threadPoolExecutor.getPoolSize());
        System.out.println("task-queue-size -> "+ threadPoolExecutor.getQueue().size());
    }
}

class ScheduledThreadPoolExecutorExample{
    public void getScheduledThreadPool() throws InterruptedException {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
        executor.schedule(() -> System.out.println("Scheduled 1 tasks with initial delay of 500ms ->Hello World"),
                500, TimeUnit.MILLISECONDS);

        CountDownLatch lock = new CountDownLatch(3);
        executor = Executors.newScheduledThreadPool(5);
        ScheduledFuture<?> future = executor.scheduleAtFixedRate(() -> {
            System.out.println("Scheduled 3 tasks @100ms per task --> Hello World" + lock.getCount());
            lock.countDown();
        }, 500, 100, TimeUnit.MILLISECONDS);

        lock.await(1000, TimeUnit.MILLISECONDS);
        future.cancel(true);
    }
}

class ForkJoinPoolExample{
    /*
    * ForkJoinPool is the central part of the fork/join framework introduced in Java 7. It solves a common problem of
      spawning multiple tasks in recursive algorithms. We'll run out of threads quickly by using a simple ThreadPoolExecutor,
      as every task or subtask requires its own thread to run.
    * In a fork/join framework, any task can spawn (fork) a number of subtasks and wait for their completion using the join method.
      The benefit of the fork/join framework is that it does not create a new thread for each task or subtask, instead
      implementing the work-stealing algorithm. This framework is thoroughly described in our Guide to the Fork/Join Framework in Java.
    * */
    public void getForkJoinPool(){
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        //forkJoinPool.invoke();
    }

}