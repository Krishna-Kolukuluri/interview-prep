package concepts;

import recursion.ListNode;

import java.util.*;
import java.util.concurrent.*;

/*
* https://www.baeldung.com/java-thread-safety
* */
public class ThreadSafeDataStructures {
    public static void main(String[] args) {
        //Collections.synchronizedList
        //Collections.synchronizedCollection
        List<Object> test = Collections.synchronizedList(new ArrayList<>());
        Collection<Integer> syncCollection = Collections.synchronizedCollection(new ArrayList<>());
        Thread thread1 = new Thread(() -> syncCollection.addAll(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Thread thread2 = new Thread(() -> syncCollection.addAll(Arrays.asList(7, 8, 9, 10, 11, 12)));
        thread1.start();
        System.out.println(syncCollection);
        thread2.start();
        System.out.println(syncCollection);

        Map<String,String> concurrentMap = new ConcurrentHashMap<>();
        concurrentMap.put("1", "one");
        concurrentMap.put("2", "two");
        concurrentMap.put("3", "three");
    }
}
