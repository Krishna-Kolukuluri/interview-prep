package CommonProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
*
Given a string or List<String> s which represents an expression, evaluate this expression and return its value.
The integer division should truncate toward zero.
You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].
Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
*
Constraints:
1 <= s.length <= 3 * 105
s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.
s represents a valid expression.
All the integers in the expression are non-negative integers in the range [0, 231 - 1].
The answer is guaranteed to fit in a 32-bit integer.
* */
public class BasicCalculatorII {
    public static void main(String[] args) {
        List<String> input = new ArrayList<String>(Arrays.asList("20", "*", "3","*", "4","*","4"));
        System.out.println(calculate((input)));
    }
    public static int calculate(List<String> s) {
        int currentNumber = 0, lastNumber = 0, result = 0;
        char operation = '+';
        for (int i = 0; i < s.size(); i++) {
            for(int j =0; j<s.get(i).length(); j++ ){
                char currentChar = s.get(i).charAt(j);
                if (Character.isDigit(currentChar)) {
                    currentNumber = (currentNumber * 10) + (currentChar - '0');
                }
                if (!Character.isDigit(currentChar)  || i == s.size() - 1) {
                    if (operation == '+' || operation == '-') {
                        result += lastNumber;
                        lastNumber = (operation == '+') ? currentNumber : -currentNumber;
                    } else if (operation == '*') {
                        lastNumber = lastNumber * currentNumber;
                    } else if (operation == '/') {
                        lastNumber = lastNumber / currentNumber;
                    }
                    operation = currentChar;
                    currentNumber = 0;
                }
            }
        }
        result += lastNumber;
        return result;
    }
}
/*
*
Complexity Analysis:
Time Complexity: O(n), where nn is the length of the string s.
Space Complexity: O(1), as we use constant extra space to store lastNumber, result and so on.
*
* */