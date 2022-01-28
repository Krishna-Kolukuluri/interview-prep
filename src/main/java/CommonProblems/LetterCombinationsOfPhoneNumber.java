package CommonProblems;

import java.util.*;

/*
* Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
* Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
* */
public class LetterCombinationsOfPhoneNumber {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));

    }
    static Map<Character, String> letterMap = Map.of('2', "abc",
                                              '3', "def",
                                              '4', "ghi",
                                              '5', "jkl",
                                               '6', "mno",
                                               '7', "pqrs",
                                                '8', "tuv",
                                                '9', "wxyz");
    static String phoneDigits;
    static List<String> result = new ArrayList<>();
    private static List<String> letterCombinations(String digits){
        // If the input is empty, immediately return an empty answer array
        if(digits.length() == 0){
            return result;
        }
        // Initiate backtracking with an empty path and starting index of 0
        phoneDigits = digits;
        backtrack(0, new StringBuilder());
        return result;
    }

    private static void backtrack(int index, StringBuilder path){
        // If the path is the same length as digits, we have a complete combination
        if(path.length() == phoneDigits.length()){
            result.add(path.toString());
            return;
        }
        String letters = letterMap.get(phoneDigits.charAt(index));
        for(char letter : letters.toCharArray()){
            // Add the letter to our current path
            path.append(letter);
            // Move on to the next digit
            backtrack(index + 1, path);
            // Backtrack by removing the letter before moving onto the next
            path.deleteCharAt(path.length() - 1);
        }
    }
    /*
    * Complexity Analysis
    Time complexity: O(4^N . N) where N is the length of digits. Note that 4 in this expression is referring to the maximum
    value length in the hash map, and not to the length of the input.
    *
    Space complexity: O(N), where NN is the length of digits.
    * */
}
