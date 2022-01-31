package search;

/*
* https://leetcode.com/problems/sqrtx/solution/
Given a non-negative integer x, compute and return the square root of x.
Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.
Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5
* */
public class SquareRootExample {
    public static void main(String[] args) {
        int result = getSqrt(2147395599);
        System.out.println(result);
    }
    /*
    * Algorithm:
        If x < 2, return x.
        Set the left boundary to 2, and the right boundary to x / 2.
        While left <= right:
        Take num = (left + right) / 2 as a guess. Compute num * num and compare it with x:
        If num * num > x, move the right boundary right = pivot -1
        Else, if num * num < x, move the left boundary left = pivot + 1
        Otherwise num * num == x, the integer square root is here, let's return it
        Return right
    * */
    public static int getSqrt(int x){
        if(x < 2){
            return x;
        }
        int right = x/2;
        int left = 2;
        int middle = 2;
        while (left <= right){
            middle = left + (right - left)/2;
            long tempVal = (long) middle * middle;
            if(tempVal>x){
                right = middle - 1;
            }
            else if (tempVal< x){
                left = middle + 1;
            }
            else return middle;
        }
        return right;
    }
    /*
    Complexity Analysis:
    Time complexity : O(logN).
    Let's compute time complexity with the help of master theorem.
    The equation represents dividing the problem up into aa subproblems of size time. Here at step there is only one
    subproblem a = 1, its size is a half of the initial problem b = 2, and all this happens in a constant time d = 0.
    That means that  and hence we're dealing with case 2 that results in O(logN) time complexity.

    Space complexity : O(1) since it's a constant space solution.
    * */


    //With built-in functions
    public int mySqrt(int x) {
        if (x < 2) return x;

        int left = (int)Math.pow(Math.E, 0.5 * Math.log(x));
        int right = left + 1;
        return (long)right * right > x ? left : right;
    }
    /*
    * Complexity Analysis:
        Time complexity : O(1).
        Space complexity : O(1).
    * */
}

