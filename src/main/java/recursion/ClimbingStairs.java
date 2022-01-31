package recursion;
//https://leetcode.com/problems/climbing-stairs/
//You are climbing a staircase. It takes n steps to reach the top.
//Each time you can either climb 1 or 2 steps(at most 2 steps i.e. m = 2). In how many distinct ways can you climb to the top?
// f(n) = f(n-1) + f(n-2) which is fibonacci series f(n) + 1;
//If m = 3 then f(n) = f(n-1) + f(n-2) + f(n-3)

import java.util.HashMap;

public class ClimbingStairs {
    //Dynamic Programming
    public int climbStairsIter(int n) {
        // base cases
        //m = 2 at most 2 stairs at a time i.e. 0 or 1 or 2 stairs at time.
        if(n < 2){
            return n;
        }
        int one_steps = 1;
        int two_steps = 1;
        int all_ways = 0;

        for(int i=2; i<n; i++){
            all_ways = one_steps + two_steps;
            one_steps = two_steps;
            two_steps = all_ways;
        }
        return all_ways;
    }

    //Recursive Programming
    //O(n) time complexity
    //O(m^n) time complexity --> without cache here m = 2 as 1 or 2 steps
    //With cache O(n)
    HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();
    public int climbStairsRec(int n){
        if(cache.containsKey(n)){
            return cache.get(n);
        }
        if(n<0){
            return 0;
        } else if(n == 0){
            return 1;
        }
        int noOfWaysForN = climbStairsRec(n-1) + climbStairsRec(n-2);
        cache.put(n, noOfWaysForN);
        return noOfWaysForN;
    }


    public int climbStairs(int n) {
        int memo[] = new int[n + 1];
        return climb_Stairs(0, n, memo);
    }
    /*
    * climbStairs(i,n)=(i+1,n)+climbStairs(i+2,n)
    * */
    public int climb_Stairs(int i, int n, int memo[]) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (memo[i] > 0) {
            return memo[i];
        }
        memo[i] = climb_Stairs(i + 1, n, memo) + climb_Stairs(i + 2, n, memo);
        return memo[i];
    }
    /*
    * Complexity Analysis:
        Time complexity : O(n). Size of recursion tree can go upto n.
        Space complexity : O(n). The depth of recursion tree can go upto n.
    * */



    /*
    * Fib(n)=Fib(n−1)+Fib(n−2)
    * */
    public int climbStairsFibApproach(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
    /*
    * Complexity Analysis
        Time complexity : O(n). Single loop upto nn is required to calculate n^{th} fibonacci number.
        Space complexity : O(1). Constant space is used.
    * */
}
