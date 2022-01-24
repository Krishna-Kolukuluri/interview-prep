package designpatterns.creational.singleton;
//Singleton pattern restricts the instantiation of a class and ensures that only one instance of the class exists in the java virtual machine.
//Not a good implementation prior to Java 6, from Java 6--> memory issues are no longer an issue with this implementation.
public class ThreadSafeSingleton {
    //Singleton pattern double check implementation which is thread safe reduced performance bottleneck.
    private static ThreadSafeSingleton singletonExample;
    private ThreadSafeSingleton(){
    }
    //Tread Safe Singleton pattern implementation
    public static ThreadSafeSingleton getInstance(){
        if(singletonExample == null){
            synchronized (ThreadSafeSingleton.class){
                if(singletonExample == null){
                    singletonExample = new ThreadSafeSingleton();
                }
            }
        }
        return singletonExample;
    }
}
