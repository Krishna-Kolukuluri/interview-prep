package recursion;

import java.util.HashMap;

public class FibonacciNumber {
    HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();
    //Memoization with recursion
    public int fib(int n) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        int result;
        if (n < 2) {
            result = n;
        } else {
            result = fib(n-1) + fib(n-2);
        }
        // keep the result in cache.
        cache.put(n, result);
        return result;
    }

    public int fibIter(int n) {

        if(n==0||n==1)
            return n;
        int[] fibNum = new int[n+1];
        fibNum[0] = 0;
        fibNum[1] = 1;

        for(int i=2; i<=n; i++)
            fibNum[i] = fibNum[i-1]+fibNum[i-2];

        return fibNum[n];
    }
}
