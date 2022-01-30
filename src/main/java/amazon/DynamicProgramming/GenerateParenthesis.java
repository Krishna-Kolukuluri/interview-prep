package amazon.DynamicProgramming;

import java.util.*;
/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Example 1:
Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]

Example 2:
Input: n = 1
Output: ["()"]
* */
public class GenerateParenthesis {
    public static void main(String args[]){
        List<String> p = generateParenthesis(3);
        System.out.println(p);
    }
    
    //Closure Algorithm: O(4^n/sqrt n)
    public static List<String> generateParenthesis_Closure(int n) {
        List<String> ans = new ArrayList<>();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; ++c){
                for (String left: generateParenthesis_Closure(c)){
                    for (String right: generateParenthesis_Closure(n-1-c)){
                        ans.add("(" + left + ")" + right);
                    }
                }
            }
        }
        return ans;
    }
    
    //Brute Force
    public static List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }
    public static void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (valid(current))
                result.add(new String(current));
        } else {
            current[pos] = '(';
            generateAll(current, pos+1, result);
            current[pos] = ')';
            generateAll(current, pos+1, result);
        }
    }
    public static boolean valid(char[] current) {
        int balance = 0;
        for (char c: current) {
            if (c == '(') balance++;
            else balance--;
            if (balance < 0) return false;
        }
        return (balance == 0);
    }
    /*
    * Complexity Analysis
        Time Complexity : O(2^{2n} * n). For each of 2^{2n} sequences, we need to create and validate the sequence, which takes O(n) work.
        Space Complexity : O(2^{2n} * n). Naively, every sequence could be valid.
    * */
}
