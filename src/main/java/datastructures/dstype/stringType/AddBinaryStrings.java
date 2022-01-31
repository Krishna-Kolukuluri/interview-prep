package datastructures.dstype.stringType;

import java.math.BigInteger;

/* https://leetcode.com/problems/add-binary/
Given two binary strings a and b, return their sum as a binary string.
*/
public class AddBinaryStrings {
    public static void main(String[] args) {

    }
    /*
    *
    Algorithm:
        Convert a and b into integers x and y, x will be used to keep an answer, and y for the carry.
        While carry is nonzero: y != 0:
        Current answer without carry is XOR of x and y: answer = x^y.
        Current carry is left-shifted AND of x and y: carry = (x & y) << 1.
        Job is done, prepare the next loop: x = answer, y = carry.
        Return x in the binary form.
        * 1 bit left-shift << equal to (x & y)*2
        * 1 bit right-shift >> equal to (x & y)/2
    *
    * */
    public String addBinary(String a, String b) {
        BigInteger x = new BigInteger(a, 2);
        BigInteger y = new BigInteger(b, 2);
        BigInteger zero = new BigInteger("0", 2);
        BigInteger carry, answer;
        while (y.compareTo(zero) != 0) {
            answer = x.xor(y);
            carry = x.and(y).shiftLeft(1);
            x = answer;
            y = carry;
        }
        return x.toString(2);
    }
    /*
    Performance Discussion:
        Here we deal with input numbers which are greater than 2^{100}. That forces to use slow BigInteger in Java, and hence
        the performance gain will be present for the Python solution only. Provided here Java solution could make its best with
        Integers or Longs, but not with BigIntegers.

        Complexity Analysis:
        Time complexity : O(N+M), where NN and MM are lengths of the input strings a and b.
        Space complexity : O(max(N,M)) to keep the answer.
    * */




    /*
    Algorithm:
        That's a good old classical algorithm, and there is no conversion from binary string to decimal and back here. Let's
        consider the numbers bit by bit starting from the lowest one and compute the carry this bit will add.

        Start from carry = 0. If number a has 1-bit in this lowest bit, add 1 to the carry. The same for number b: if number
        b has 1-bit in the lowest bit, add 1 to the carry. At this point the carry for the lowest bit could be equal to (00)2,
        (01)2 or (10)2.
        Now append the lowest bit of the carry to the answer, and move the highest bit of the carry to the next order bit.
        Repeat the same steps again, and again, till all bits in a and b are used up. If there is still nonzero carry to add,
        dd it. Now reverse the answer string and the job is done.
    * */
    public String addBinaryStrings(String a, String b){
        int n = a.length(), m = b.length();
        if (n < m) return addBinaryStrings(b, a);
        int L = Math.max(n, m);

        StringBuilder sb = new StringBuilder();
        int carry = 0, j = m - 1;
        for(int i = L - 1; i > -1; --i) {
            if (a.charAt(i) == '1') ++carry;
            if (j > -1 && b.charAt(j--) == '1') ++carry;

            if (carry % 2 == 1) sb.append('1');
            else sb.append('0');

            carry /= 2;
        }
        if (carry == 1) sb.append('1');
        sb.reverse();

        return sb.toString();
    }
    /*
    Complexity Analysis:
    Time complexity: O(max(N,M)), where NN and MM are lengths of the input strings a and b.

    Space complexity: O(max(N,M)) to keep the answer.
    * */
}
