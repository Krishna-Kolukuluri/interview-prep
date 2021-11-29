package dynamicprogramming;

import java.util.HashMap;

public class NthTribonacciNumberExample {
    public static void main(String[] args) {
        TribonacciNumber tribonacciNumber = new TribonacciNumber();
        int trib4 =  tribonacciNumber.tribonacci(5);
        System.out.println(trib4);
    }
}
class TribonacciNumber{
    HashMap<Integer, Integer> tribMap;
    public TribonacciNumber(){
        tribMap = new HashMap<>();
    }
    public int tribonacci(int n){
        if(n <=1){
            return n;
        }
        if(n == 2){
            return 1;
        }
        if(!tribMap.containsKey(n)){
            tribMap.put(n, tribonacci(n-1)+tribonacci(n-2)+tribonacci(n-3));
        }
        return tribMap.get(n);
    }
}
