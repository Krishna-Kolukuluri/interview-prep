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
        /*
        * This means that the methods can be accessed by only one thread at a time, while other threads will be blocked until the method is unlocked by the first thread.
          Thus, synchronization has a penalty in performance, due to the underlying logic of synchronized access.
        * */
        List<Object> test = Collections.synchronizedList(new ArrayList<>());
        Collection<Integer> syncCollection = Collections.synchronizedCollection(new ArrayList<>());
        Thread thread1 = new Thread(() -> syncCollection.addAll(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Thread thread2 = new Thread(() -> syncCollection.addAll(Arrays.asList(7, 8, 9, 10, 11, 12)));
        thread1.start();
        System.out.println(syncCollection);
        thread2.start();
        System.out.println(syncCollection);

        /*
        * Unlike their synchronized counterparts, concurrent collections achieve thread-safety by dividing their data into segments.
        * In a ConcurrentHashMap, for instance, several threads can acquire locks on different map segments, so multiple threads can access the Map at the same time.
        * Concurrent collections are much more performant than synchronized collections, due to the inherent advantages of concurrent thread access.
        * It's worth mentioning that synchronized and concurrent collections only make the collection itself thread-safe and not the contents.
        * */
        Map<String,String> concurrentMap = new ConcurrentHashMap<>();
        concurrentMap.put("1", "one");
        concurrentMap.put("2", "two");
        concurrentMap.put("3", "three");
    }
}
