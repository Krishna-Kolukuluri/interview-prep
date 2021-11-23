package concepts;

import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class SynchronizationExample {
    public static void runThreads(){
        ExecutorService service = Executors.newFixedThreadPool(3);
        CustomSynchronization customSynchronization = new CustomSynchronization();
        IntStream.range(0,1000).forEach(count -> service.submit(customSynchronization::calculate));
        IntStream.range(0,1000).forEach(count -> service.submit(CustomSynchronization::syncStaticCalculate));
        IntStream.range(0,1000).forEach(count -> service.submit(CustomSynchronization::syncBlockStaticCalculate));
        IntStream.range(0,1000).forEach(count -> service.submit(customSynchronization::syncBlockCalculate));
        service.submit(customSynchronization::syncMultipleBlocksCalculate);
        try {
            service.awaitTermination(1000, TimeUnit.MILLISECONDS);
            System.out.println(customSynchronization.getSum());
            System.out.println(CustomSynchronization.staticSum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        runThreads();
    }
}

class CustomSynchronization{
    private int sum = 0;
    public static int staticSum = 0;
    public int getSum() {
        return sum;
    }
    public void setSum(int sum) {
        this.sum = sum;
    }

    //Instance method synchronization(per class instance object)
    public synchronized void calculate(){
        setSum(getSum() + 1);
    }

    //Static method synchronization(per class)
    public synchronized static void syncStaticCalculate(){
        staticSum += 1;
    }

    //Synchronizing block of code in instance method
    public void syncBlockCalculate(){
        synchronized (this){
            setSum(getSum() + 1);
        }
    }

    //Synchronizing block with static method
    public static void syncBlockStaticCalculate(){
        synchronized (CustomSynchronization.class){
            staticSum += 1;
        }
    }

    //Synchronize lock reentrancy i.e. a thread can acquire the same synchronized lock over and over again.
    public void syncMultipleBlocksCalculate(){
        Object lock = new Object();
        synchronized (lock){
            System.out.println("First time acquiring lock-->"+ lock + " object");
            synchronized (lock){
                System.out.println("Inside First->Second time acquiring lock-->"+ lock + " object");
                synchronized (lock){
                    System.out.println("Inside First-> Inside Second -> Third time acquiring lock-->"+ lock + " object");
                }
            }
        }
    }
}
