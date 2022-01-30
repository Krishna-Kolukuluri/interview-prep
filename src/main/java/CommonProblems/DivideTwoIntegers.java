package CommonProblems;

import java.util.ArrayList;

/*
* https://leetcode.com/problems/divide-two-integers/solution/
* Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
  The integer division should truncate toward zero, which means losing its fractional part. For example, 8.345 would be
  truncated to 8, and -2.7335 would be truncated to -2.

*  Return the quotient after dividing dividend by divisor.

* Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range:
  [−231, 231 − 1]. For this problem, if the quotient is strictly greater than 231 - 1, then return 231 - 1, and if the
  quotient is strictly less than -231, then return -231.
*
* Example 1:
    Input: dividend = 10, divisor = 3
    Output: 3
    Explanation: 10/3 = 3.33333.. which is truncated to 3.

* Example 2:
    Input: dividend = 7, divisor = -3
    Output: -2
    Explanation: 7/-3 = -2.33333.. which is truncated to -2.
* */
public class DivideTwoIntegers {
    public static void main(String[] args) {
        System.out.println(divide(93706, 157));
    }
    /*
    * Adding Powers of Two
    Intuition    (157,314,628,1256,2512,5024,10048) <-- 157 * (2^0, 2^1, 2^2,2^3,2^4,2^5,2^6)
    In the previous approach, we did repeated exponential searches for the largest value that would fit into the current dividend.
    However, notice that each time we do a search, we repeatedly go through the same doubles to find the largest. For example,
    * consider the first and second step of our previous example: divide(93706, 157).
    * */

    /*
    * Complexity Analysis:
        Let nn be the absolute value of dividend.
        Time Complexity : O(log n).
        We take O(log n) time in the first loop to create our list of doubles (and powers of two).
        For the second loop, because there's O(log n) items in the list of doubles, it only takes OO(log n)time for this loop as well.
        Combined, our total time complexity is just O(log n+log n)=O(log n).

        Space Complexity : O(log n).
        The length of the list of doubles of the divisor is proportional to O(log n) so our space complexity is O(log n).
    * */
    public static int divide(int dividend, int divisor){
        int HALF_INT_MIN = -1073741824;// -2**30;
        // Special case: overflow.
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        /* We need to convert both numbers to negatives.
         * Also, we count the number of negatives signs. */
        int negatives = 2;
        if (dividend > 0) {
            negatives--;
            dividend = -dividend;
        }
        if (divisor > 0) {
            negatives--;
            divisor = -divisor;
        }

        ArrayList<Integer> doubles = new ArrayList<>();
        ArrayList<Integer> powersOfTwo = new ArrayList<>();

        /* Nothing too exciting here, we're just making a list of doubles of 1 and
         * the divisor. This is pretty much the same as Approach 2, except we're
         * actually storing the values this time. */
        int powerOfTwo = -1;
        while (divisor >= dividend) {
            doubles.add(divisor);
            powersOfTwo.add(powerOfTwo);
            // Prevent needless overflows from occurring...
            if (divisor < HALF_INT_MIN) {
                break;
            }
            divisor += divisor;
            powerOfTwo += powerOfTwo;
        }

        int quotient = 0;
        /* Go from the largest double to smallest, checking if the current double fits.
         * into the remainder of the dividend. */
        for (int i = doubles.size() - 1; i >= 0; i--) {
            if (doubles.get(i) >= dividend) {
                // If it does fit, add the current powerOfTwo to the quotient.
                quotient += powersOfTwo.get(i);
                // Update dividend to take into account the bit we've now removed.
                dividend -= doubles.get(i);
            }
        }

        /* If there was originally one negative sign, then
         * the quotient remains negative. Otherwise, switch
         * it to positive. */
        if (negatives != 1) {
            return -quotient;
        }
        return quotient;
    }


    /*
    * Complexity Analysis:
        Let nn be the absolute value of dividend.
        Time Complexity : O(log n).
        Same as Approach as divide  above, except instead of looping over a generated array, we simply perform an O(1)
        halving operation to get the next values we need.

        Space Complexity : O(1).
        We only use a fixed number of integer variables, so the space complexity is O(1).
    * */
    public int divideBigO1Space(int dividend, int divisor) {
        int HALF_INT_MIN = -1073741824;// -2**30;
        // Special case: overflow.
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        /* We need to convert both numbers to negatives.
         * Also, we count the number of negatives signs. */
        int negatives = 2;
        if (dividend > 0) {
            negatives--;
            dividend = -dividend;
        }
        if (divisor > 0) {
            negatives--;
            divisor = -divisor;
        }

        /* In the first loop, we simply find the largest double of divisor
         * that fits into the dividend.
         * The >= is because we're working in negatives. In essence, that
         * piece of code is checking that we're still nearer to 0 than we
         * are to INT_MIN. */
        int highestDouble = divisor;
        int highestPowerOfTwo = -1;
        while (highestDouble >= HALF_INT_MIN && dividend <= highestDouble + highestDouble) {
            highestPowerOfTwo += highestPowerOfTwo;
            highestDouble += highestDouble;
        }

        /* In the second loop, we work out which powers of two fit in, by
         * halving highestDouble and highestPowerOfTwo repeatedly.
         * We can do this using bit shifting so that we don't break the
         * rules of the question :-) */
        int quotient = 0;
        while (dividend <= divisor) {
            if (dividend <= highestDouble) {
                quotient += highestPowerOfTwo;
                dividend -= highestDouble;
            }
            /* We know that these are always even, so no need to worry about the
             * annoying "bit-shift-odd-negative-number" case. */
            highestPowerOfTwo >>= 1;
            highestDouble >>= 1;
        }

        /* If there was originally one negative sign, then
         * the quotient remains negative. Otherwise, switch
         * it to positive. */
        if (negatives != 1) {
            return -quotient;
        }
        return quotient;
    }
}
