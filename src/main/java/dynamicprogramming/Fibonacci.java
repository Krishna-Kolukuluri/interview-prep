package dynamicprogramming;

import java.math.BigInteger;
import java.util.HashMap;

public class Fibonacci {
    public static void main(String[] args) {
        FibMemoize fibMemoize = new FibMemoize();
        System.out.println(fibMemoize.calculateFibonacciNumber(1000));
    }
}

class FibMemoize{
    HashMap<Integer, BigInteger> memoize = new HashMap<>();
    public BigInteger calculateFibonacciNumber(int num){
        if(num < 2){
            return BigInteger.valueOf(num);
        }
        if(memoize.containsKey(num)){
            return memoize.get(num);
        }
        BigInteger fibNum = calculateFibonacciNumber(num - 1).add(calculateFibonacciNumber(num - 2));
        memoize.put(num, fibNum);
        return fibNum;
    }
}
