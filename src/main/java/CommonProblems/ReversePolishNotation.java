package CommonProblems;

import java.util.Stack;

/*
* https://leetcode.com/problems/evaluate-reverse-polish-notation/
* https://leetcode.com/problems/evaluate-reverse-polish-notation/solution/
* Evaluate the value of an arithmetic expression in Reverse Polish Notation.
Valid operators are +, -, *, and /. Each operand may be an integer or another expression.
Note that division between two integers should truncate toward zero.
It is guaranteed that the given RPN expression is always valid. That means the expression would always evaluate to a result,
and there will not be any division by zero operation.
*
* Example 1:
Input: tokens = ["2","1","+","3","*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
*
Example 2:
Input: tokens = ["4","13","5","/","+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6
*
Example 3:
Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
Output: 22
Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22
* */
public class ReversePolishNotation {
    public static int evalRPN(String[] tokens){
        Stack<Integer> stack = new Stack<>();
        for(String token: tokens){
            if(stack.size() >=2 && (token.equals("+") || token.equals("-") || token.equals("/") || token.equals("*"))){
                Integer secondOperand = stack.pop();
                Integer firstOperand = stack.pop();
                int result = 0;
                switch (token){
                    case "+":
                        result = firstOperand + secondOperand;
                        stack.add(result);
                        break;
                    case "-":
                        result = firstOperand - secondOperand;
                        stack.add(result);
                        break;
                    case "*":
                        result = firstOperand * secondOperand;
                        stack.add(result);
                        break;
                    case "/":
                        result = firstOperand / secondOperand;
                        stack.add(result);
                        break;
                    default:
                        continue;
                }

            }else{
                stack.add(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
    /*
    * Complexity Analysis
        Let nn be the length of the list.
        Time Complexity : O(n).
        We do a linear search to put all numbers on the stack, and process all operators. Processing an operator requires removing
        2 numbers off the stack and replacing them with a single number, which is an O(1) operation. Therefore, the total cost
        is proportional to the length of the input array. Unlike before, we're no longer doing expensive deletes from the middle of an Array or List.

        Space Complexity : O(n).
        In the worst case, the stack will have all the numbers on it at the same time. This is never more than half the
        length of the input array.
    *
    * */

    public static void main(String[] args) {
        String[] tokens = new String[]{"2","1","+","3","*"};
        System.out.println(evalRPN(tokens));

        tokens = new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(tokens));
    }
}
