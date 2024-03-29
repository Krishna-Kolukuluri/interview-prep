package CommonProblems;
/*
* https://leetcode.com/problems/strobogrammatic-number/
* Given a string num which represents an integer, return true if num is a strobogrammatic number.
A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
Example 1:
Input: num = "69"
Output: true
*
Example 2:
Input: num = "88"
Output: true
*
Example 3:
Input: num = "962"
Output: false
Constraints:
1 <= num.length <= 50
num consists of only digits.
num does not contain any leading zeros except for zero itself.
* */
public class StrobogrammaticNumber {
    public static void main(String[] args) {
        System.out.println(isStrobogrammatic("69"));
    }
    public static boolean isStrobogrammatic(String num) {

        // Note that using a String here and appending to it would be
        // poor programming practice.
        StringBuilder rotatedStringBuilder = new StringBuilder();

        // Remember that we want to loop backwards through the string
        for (int i = num.length() - 1; i >= 0; i--) {
            char c = num.charAt(i);
            if (c == '0' || c == '1' || c == '8') {
                rotatedStringBuilder.append(c);
            } else if (c == '6') {
                rotatedStringBuilder.append('9');
            } else if (c == '9') {
                rotatedStringBuilder.append('6');
            } else { // This must be an invalid digit.
                return false;
            }
        }

        String rotatedString = rotatedStringBuilder.toString();
        return num.equals(rotatedString);
    }
}
