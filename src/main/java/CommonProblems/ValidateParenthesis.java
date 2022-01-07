package CommonProblems;

import java.util.HashMap;
import java.util.Stack;

/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
*
Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}<>'.
* */
public class ValidateParenthesis {
    public static void main(String[] args) {
        String str = "()[]{}";
        System.out.println(isValid(str));
    }

    private static boolean isValid(String input){
        HashMap<Character, Character> charPairMap = new HashMap<>();
        charPairMap.put(')','(');
        charPairMap.put('}', '{');
        charPairMap.put(']','[');
        charPairMap.put('>','<');
        Stack<Character> tempCharPool = new Stack<>();
        for(Character c: input.toCharArray()){
            if(!tempCharPool.isEmpty()){
                Character pairChar = charPairMap.get(c);
                if(tempCharPool.peek().equals(pairChar)){
                    tempCharPool.pop();
                }
                else{
                    tempCharPool.push(c);
                }
            }else{
                tempCharPool.push(c);
            }
        }
        return tempCharPool.isEmpty();
    }
}
/*
Complexity analysis

Time complexity : O(n)O(n) because we simply traverse the given string one character at a time and push and pop operations
on a stack take O(1)O(1) time.
Space complexity : O(n)O(n) as we push all opening brackets onto the stack and in the worst case, we will end up pushing
all the brackets onto the stack. e.g. ((((((((((.
* */
