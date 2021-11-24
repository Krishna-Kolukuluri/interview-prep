package designpatterns.creational;

//Not a good implementation prior to Java 6, from Java 6--> memory issues are no longer an issue with this implementation.
public class SingletonExample {
    //Singleton pattern double check implementation which is thread safe reduced performance bottleneck.
    private static SingletonExample singletonExample;
    private SingletonExample(){
    }
    public static SingletonExample getInstance(){
        if(singletonExample == null){
            synchronized (SingletonExample.class){
                if(singletonExample == null){
                    singletonExample = new SingletonExample();
                }
            }
        }
        return singletonExample;
    }
}
