package recursion;
/*
* https://leetcode.com/problems/powx-n/
*Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
*
Example 1:
Input: x = 2.00000, n = 10
Output: 1024.00000
*
Example 2:
Input: x = 2.10000, n = 3
Output: 9.26100
*
Example 3:
Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
*
* */
public class Power {
    public static void main(String[] args){
        System.out.println(power(2.000, 10));
    }

    //Tail recursion, no further calculations are being done after power function return statement for each recursive call
    // which helps to reuse stack space for recursive function calls by directly returning value to original caller.
    private static double power(double base, int pow){
        if(pow == 0) {
            return 1.0;
        }
        //Handling -ve number powers i.e. dividing instead of multiplying.
        if(pow < 0){
            return 1/base * power(1/base, -(pow + 1));
        }
        return pow%2 == 0? power(base * base, pow/2): base * power(base * base, pow/2);
    }

    /*
    *Complexity Analysis
        Time complexity : O(logn). Each time we apply the formula (x ^ n) ^ 2 = x^(2∗n), n is reduced by half.
                          Thus we need at O(logn) computations to get the result.
        Space complexity :O(logn). For each computation, we need to store the result of x ^ {n / 2}. We need to do the
                          computation for O(logn) times, so the space complexity is O(logn).
    * */
    private double fastPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return fastPow(x, N);
    }

    private static double mathPowerFunc(double base, int pow){
        return Math.pow(base, pow);
    }
}
