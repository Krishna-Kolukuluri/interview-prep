package designpatterns.creational.singleton;
/*
Singleton pattern restricts the instantiation of a class and ensures that only one instance of the class exists in the java virtual machine.

This is the most widely used approach for Singleton class as it doesn’t require synchronization.
* */
public class BillPughSingleton {
    private BillPughSingleton(){
    }

    private static class SingletonHelper {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance(){
        return SingletonHelper.INSTANCE;
    }
}
