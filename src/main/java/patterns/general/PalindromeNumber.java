package patterns.general;
/*
* https://leetcode.com/problems/palindrome-number/solution/
* Given an integer x, return true if x is palindrome integer.

An integer is a palindrome when it reads the same backward as forward.

For example, 121 is a palindrome while 123 is not.
Example 1:
Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.
*
Example 2:
Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
* Example 3:
Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
Constraints:
-231 <= x <= 231 - 1
Follow up: Could you solve it without converting the integer to a string?
*
* */
public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(10));
        System.out.println(isPalindrome(101));
    }

    public static boolean isPalindrome(int x){
        // As discussed above, when x < 0, x is not a palindrome.
        // Also if the last digit of the number is 0, in order to be a palindrome,
        // the first digit of the number also needs to be 0.
        // Only 0 satisfy this property.
        if(x<0 || (x%10 ==0 && x!=0)){
            return false;
        }
        int reversedNumber = 0;
        while(x > reversedNumber){
            reversedNumber = reversedNumber*10 + x % 10;
            x = x/10;
        }
        // When the length is an odd number, we can get rid of the middle digit by revertedNumber/10
        // For example when the input is 12321, at the end of the while loop we get x = 12, revertedNumber = 123,
        // since the middle digit doesn't matter in palidrome(it will always equal to itself), we can simply get rid of it.
        return x == reversedNumber || x == reversedNumber/10;
    }
}
