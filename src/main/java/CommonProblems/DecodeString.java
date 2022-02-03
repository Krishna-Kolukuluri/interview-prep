package CommonProblems;

import java.util.Stack;

/*
* Decode String
* https://leetcode.com/problems/decode-string/
* https://leetcode.com/problems/decode-string/solution/*
* Given an encoded string, return its decoded string.
The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times.
Note that k is guaranteed to be a positive integer.
You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc.
Furthermore, you may assume that the original data does not contain any digits and that digits are only for those
repeat numbers, k. For example, there will not be input like 3a or 2[4].
*
* Example 1:
Input: s = "3[a]2[bc]"
Output: "aaabcbc"
* Example 2:
Input: s = "3[a2[c]]"
Output: "accaccacc"
* Example 3:
Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"
* */
public class DecodeString {
/*
    * Algorithm:
        Iterate over the string s and process each character as follows:
        Case 1) If the current character is a digit (0-9), append it to the number k.
        Case 2) If the current character is a letter (a-z), append it to the currentString.
        Case 3) If current character is a opening bracket [, push k and currentString into countStack and stringStack respectively.
        Case 4) Closing bracket ]: We must begin the decoding process,
    * */
    public static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + ch - '0';
            } else if (ch == '[') {
                // push the number k to countStack
                countStack.push(k);
                // push the currentString to stringStack
                stringStack.push(currentString);
                // reset currentString and k
                currentString = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                StringBuilder decodedString = stringStack.pop();
                // decode currentK[currentString] by appending currentString k times
                for (int currentK = countStack.pop(); currentK > 0; currentK--) {
                    decodedString.append(currentString);
                }
                currentString = decodedString;
            } else {
                currentString.append(ch);
            }
        }
        return currentString.toString();
    }
    /*
    * Complexity Analysis:
        Assume, n is the length of the string s.
        Time Complexity: O(maxK⋅n), where maxK is the maximum value of k and nn is the length of a given string s.
        We traverse a string of size nn and iterate kk times to decode each pattern of form k[string]. This gives us worst
        case time complexity as O(maxK⋅n).
        Space Complexity: O(m+n), where mm is the number of letters(a-z) and n is the number of digits(0-9) in string s.
        In worst case, the maximum size of stringStack and countStack could be mm and nn respectively.
    * */

    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
        System.out.println(decodeString("3[a2[c]]"));
        System.out.println(decodeString("2[abc]3[cd]ef"));
    }
}
