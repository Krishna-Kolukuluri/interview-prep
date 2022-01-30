package CommonProblems;
/*
* https://leetcode.com/problems/multiply-strings/
* Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
* Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.
*
* Example 1:
Input: num1 = "2", num2 = "3"
Output: "6"
* Example 2:
Input: num1 = "123", num2 = "456"
Output: "56088"
* */
public class MultiplyStrings {

    /*
    *
    * Here NN and MM are the number of digits in num1 and num2 respectively.
    Time complexity: O(M⋅N).
    During multiplication, we perform N operations for each of the M digits of the second number, so we need M⋅N time for it.
    Space complexity: O(M+N).
    The space used to store the output is not included in the space complexity. However, because strings are immutable
    * in Python, Java, and Javascript, a temporary data structure, using O(M+N) space, is required to store the answer while it is updated.
    *
    * */
    public static String multiply(String num1, String num2){
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        StringBuilder firstNumber = new StringBuilder(num1);
        StringBuilder secondNumber = new StringBuilder(num2);

        // Reverse both the numbers.
        firstNumber.reverse();
        secondNumber.reverse();

        // To store the multiplication result of each digit of secondNumber with firstNumber.
        int N = firstNumber.length() + secondNumber.length();
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < N; ++i) {
            answer.append(0);
        }

        for (int place2 = 0; place2 < secondNumber.length(); place2++) {
            int digit2 = secondNumber.charAt(place2) - '0';

            // For each digit in secondNumber multiply the digit by all digits in firstNumber.
            for (int place1 = 0; place1 < firstNumber.length(); place1++) {
                int digit1 = firstNumber.charAt(place1) - '0';

                // The number of zeros from multiplying to digits depends on the
                // place of digit2 in secondNumber and the place of the digit1 in firstNumber.
                int currentPos = place1 + place2;

                // The digit currently at position currentPos in the answer string
                // is carried over and summed with the current result.
                int carry = answer.charAt(currentPos) - '0';
                int multiplication = digit1 * digit2 + carry;

                // Set the ones place of the multiplication result.
                answer.setCharAt(currentPos, (char)(multiplication % 10 + '0'));

                // Carry the tens place of the multiplication result by
                // adding it to the next position in the answer array.
                int value = (answer.charAt(currentPos + 1) - '0') + multiplication / 10;
                answer.setCharAt(currentPos + 1, (char)(value + '0'));
            }
        }

        // Pop excess 0 from the rear of answer.
        if (answer.charAt(answer.length() - 1) == '0') {
            answer.deleteCharAt(answer.length() - 1);
        }

        answer.reverse();
        return answer.toString();
    }
    /*
    * Algorithm:
        * Reverse both numbers.
        * Initialize answer with N + MN+M zeros.
        * For each digit at position i in secondNumber:
          * For each digit at position j in firstNumber:
             * Multiply the digit from secondNumber by the digit from firstNumber and add previously carried value to the
                 multiplication result. The previously carried value can be found at position i + j in the answer.
        *      Take the remainder of multiplication with 10 to get the ones place digit of the multiplication result.
        *      Put the last digit at current position (position i + j) in answer.
        *      Divide the multiplication by 10 to get the new value for carry and add it to answer at the next position.
               Note, the next position is located at (i + j + 1).
        * If the last digit in answer is zero, before reversing answer, we must pop the zero from answer. Otherwise,
          there would be a leading zero in the final answer.
        * Reverse answer and return it.
    *
    * */
    public static void main(String[] args) {
        System.out.println(multiply("123", "456"));
    }
}
