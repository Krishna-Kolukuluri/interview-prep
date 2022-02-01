package datastructures.dstype.trietype;

import java.util.HashSet;
import java.util.Set;

/*
* https://leetcode.com/problems/number-of-matching-subsequences/
*
* Given a string s and an array of strings words, return the number of words[i] that is a subsequence of s.
A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted
without changing the relative order of the remaining characters.
For example, "ace" is a subsequence of "abcde".
* Example 1:
Input: s = "abcde", words = ["a","bb","acd","ace"]
Output: 3
Explanation: There are three strings in words that are a subsequence of s: "a", "acd", "ace".
* Example 2:
Input: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
Output: 2
*
* */
public class NumberOfMatchingSubsequences {
    /*
    * https://leetcode.com/problems/number-of-matching-subsequences/
    * https://leetcode.com/problems/number-of-matching-subsequences/discuss/1702887/Easy-to-understand-java-solution
    * or
    * https://leetcode.com/problems/number-of-matching-subsequences/discuss/1717153/Java-Trie
    * Use two sets to store the words that are matched and not matched.
    * isSubseq - computes if a word is a subsequence of another word in O(n) where n is length for string 's'
    * Time Complexity: O(M * N) M is number of words, N is length of input string 's'
    * Space Complexity: O(M) M is number of words
    * */
    static Set<String> matches = new HashSet<>();
    static Set<String> noMatches = new HashSet<>();
    public static int numMatchingSubseq(String s, String[] words) {
        int count = 0;
        for (String word: words) {
            if (matches.contains(word)) {
                count++;
            } else if (noMatches.contains(word)) {
                continue;
            } else {
                boolean found = isSubseq(s, 0, word, 0);
                if (found) {
                    matches.add(word);
                    count++;
                } else {
                    noMatches.add(word);
                }
            }
        }
        return count;
    }
    public static boolean isSubseq(String s, int stringIndex, String word, int wordIndex) {
        if (wordIndex == word.length()) {
            return true;
        }
        if (stringIndex >= s.length()) {
            return false;
        }
        if (word.charAt(wordIndex) == s.charAt(stringIndex)) {
            return isSubseq(s, stringIndex+1, word, wordIndex+1);
        }
        return isSubseq(s, stringIndex+1, word, wordIndex);
    }

    public static void main(String[] args) {
       String s = "abcde";
       String[] words = {"a","bb","acd","ace"};
        System.out.println(numMatchingSubseq(s, words));
    }
}
