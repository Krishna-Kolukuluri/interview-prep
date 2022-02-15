package patterns.general;

import java.util.HashMap;
import java.util.Map;

/*
* https://leetcode.com/problems/check-if-all-characters-have-equal-number-of-occurrences/
* Given a string s, return true if s is a good string, or false otherwise.
A string s is good if all the characters that appear in s have the same number of occurrences (i.e., the same frequency).
* Example 1:
Input: s = "abacbc"
Output: true
Explanation: The characters that appear in s are 'a', 'b', and 'c'. All characters occur 2 times in s.
*
Example 2:
Input: s = "aaabb"
Output: false
Explanation: The characters that appear in s are 'a' and 'b'.
'a' occurs 3 times while 'b' occurs 2 times, which is not the same number of times.
*
* */
public class GoodString {
    public static void main(String[] args) {

        System.out.println(areOccurrenceEqual("abacbc"));
    }

    public static boolean areOccurrenceEqual(String s){
        if(s.length()==0){
            return false;
        }
        Map<Character, Integer> charCounts = new HashMap<>();
        char[] chars = s.toCharArray();
        for(char c: chars){
            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
        }
        int count = charCounts.get(chars[0]);
        for(Integer val: charCounts.values()){
            if(count != val){
                return false;
            }
        }
        return true;
    }
}
