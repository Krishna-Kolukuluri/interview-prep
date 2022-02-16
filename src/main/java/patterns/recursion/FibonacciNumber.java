package patterns.recursion;

import java.util.HashMap;
import java.util.Map;

/*
* https://leetcode.com/problems/fibonacci-number/
* The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is
* the sum of the two preceding ones, starting from 0 and 1. That is,
F(0) = 0, F(1) = 1
F(n) = F(n - 1) + F(n - 2), for n > 1.
Given n, calculate F(n).
* Example 1:
Input: n = 2
Output: 1
Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
* Example 2:
Input: n = 3
Output: 2
Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
* Example 3:
Input: n = 4
Output: 3
Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
* Constraints:
0 <= n <= 30
* */
public class FibonacciNumber {
    public static void main(String[] args) {
        System.out.println(fibonacciNumber(3));
        System.out.println(fibonacciNumber(4));
        System.out.println(fibonacciNumber(5));
        System.out.println(fibonacciNumber(6));
        System.out.println(fibonacciNumber(7));
        System.out.println(fibonacciNumber(8));
        System.out.println(fibonacciNumber(9));
        System.out.println(fibonacciNumber(28));
        System.out.println(fibonacciNumber(29));
        System.out.println(fibonacciNumber(30));
    }
    static Map<Integer, Integer> fibMap = new HashMap<>();
    public static int fibonacciNumber(int n){
        fibMap.put(0, 0);
        fibMap.put(1, 1);
        return fib(n);
    }

    public static int fib(int n){
        if(fibMap.containsKey(n)){
            return fibMap.get(n);
        }
        fibMap.put(n, fib(n -1) + fib(n -2));
        return fibMap.get(n);
    }
}
