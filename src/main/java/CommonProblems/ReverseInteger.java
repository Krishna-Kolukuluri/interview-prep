package CommonProblems;
/*
* Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the
* signed 32-bit integer range [-231, 231 - 1], then return 0.
* Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
*
Example 1:
Input: x = 123
Output: 321
*
Example 2:
Input: x = -123
Output: -321
*
Example 3:
Input: x = 120
Output: 21
* */
public class ReverseInteger {
    public static void main(String[] args) {
        int x = 123;
        System.out.println(reverse(x));
        x = 1534236469;
        System.out.println(reverse(x));
        x = -2147483648;
        System.out.println(reverse(x));
    }

    private static int reverse(int x){
        int sign = 1;
        if(x < 0){
            sign = -1;
        }
        StringBuilder xVal = new StringBuilder(String.valueOf(x * sign));
        int result = 0;
        try {
            result = Integer.valueOf(xVal.reverse().toString()) * sign;
        }
        catch (NumberFormatException  numberFormatException){
            System.out.println("input is outside int range");
        }
        return result;
    }
}
