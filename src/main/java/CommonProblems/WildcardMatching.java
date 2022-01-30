package CommonProblems;
/*
* https://leetcode.com/problems/wildcard-matching/solution/
Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:
'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

Example 1:
Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".

Example 2:
Input: s = "aa", p = "*"
Output: true
Explanation: '*' matches any sequence.

Example 3:
Input: s = "cb", p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
*
* */
public class WildcardMatching {
    /*
    * Dynamic Programming
    * */
    public static boolean isMatch(String s, String p) {
        int sLen = s.length(), pLen = p.length();

        // base cases
        if (p.equals(s)) {
            return true;
        }

        if (pLen > 0 && p.chars().allMatch(c -> c == '*')) {
            return true;
        }

        if (p.isEmpty() || s.isEmpty()) {
            return false;
        }

        // init all matrix except [0][0] element as False
        boolean[][] d = new boolean[pLen + 1][sLen + 1];
        d[0][0] = true;

        // DP compute
        for (int pIdx = 1; pIdx < pLen + 1; pIdx++) {
            // the current character in the pattern is '*'
            if (p.charAt(pIdx - 1) == '*') {
                int sIdx = 1;

                // d[p_idx - 1][s_idx - 1] is a string-pattern match
                // on the previous step, i.e. one character before.
                // Find the first idx in string with the previous math.
                while ((!d[pIdx - 1][sIdx - 1]) && (sIdx < sLen + 1)) {
                    sIdx++;
                }

                // If (string) matches (pattern),
                // when (string) matches (pattern)* as well
                d[pIdx][sIdx - 1] = d[pIdx - 1][sIdx - 1];

                // If (string) matches (pattern),
                // when (string)(whatever_characters) matches (pattern)* as well
                while (sIdx < sLen + 1) {
                    d[pIdx][sIdx++] = true;
                }

                // the current character in the pattern is '?'
            } else if (p.charAt(pIdx - 1) == '?') {
                for (int sIdx = 1; sIdx < sLen + 1; sIdx++) {
                    d[pIdx][sIdx] = d[pIdx - 1][sIdx - 1];
                }

                // the current character in the pattern is not '*' or '?'
            } else {
                for (int sIdx = 1; sIdx < sLen + 1; sIdx++) {
                    // Match is possible if there is a previous match
                    // and current characters are the same
                    d[pIdx][sIdx] = d[pIdx - 1][sIdx - 1] &&
                            (p.charAt(pIdx - 1) == s.charAt(sIdx - 1));
                }
            }
        }

        return d[pLen][sLen];
    }
    /*
    * Complexity Analysis:
        Time complexity: O(S⋅P) where SS and PP are lengths of the input string and the pattern respectively.
        Space complexity: O(S⋅P) to store the matrix.
    * */

    public static void main(String[] args) {
        System.out.println(isMatch("cb", "?a"));
        System.out.println(isMatch("aa", "*"));
        System.out.println(isMatch("aa", "a"));
    }
}
