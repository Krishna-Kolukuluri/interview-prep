package designpatterns.creational;

public class SingletonWithStaticClasses {
    private SingletonWithStaticClasses(){
    }

    private static class SingletonStatic{
        private static final SingletonWithStaticClasses SINGLETON_WITH_STATIC_CLASSES = new SingletonWithStaticClasses();
    }

    public static SingletonWithStaticClasses getInstance(){
        return SingletonStatic.SINGLETON_WITH_STATIC_CLASSES;
    }
}
