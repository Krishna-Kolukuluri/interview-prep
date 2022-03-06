package patterns.general;

import java.util.HashMap;
import java.util.Map;

/*
* https://leetcode.com/problems/ransom-note/solution/
* Given two strings ransomNote and magazine, return true if ransomNote can be constructed from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.
* Example 1:
Input: ransomNote = "a", magazine = "b"
Output: false
* Example 2:
Input: ransomNote = "aa", magazine = "ab"
Output: false
* Example 3:
Input: ransomNote = "aa", magazine = "aab"
Output: true
*
* */
public class RansomNote {
    /*
    * We'll say mm is the length of the magazine, and nn is the length of the ransom note.
    * Time Complexity : O(m).
    * Space Complexity : O(k) / O(1)
    * For this problem, because kk is never more than 26, which is a constant, it'd be reasonable to say that this
    * algorithm requires O(1) space.
    * */
    public static boolean canConstruct(String ransomNote, String magazine){
        if(magazine.length()<ransomNote.length()){
            return false;
        }
        Map<Character, Integer> charCounts = new HashMap<>();
        for(char c: magazine.toCharArray()){
            charCounts.put(c, charCounts.getOrDefault(c,0) + 1);
        }
        for(char c: ransomNote.toCharArray()){
            if(charCounts.containsKey(c)){
                if(charCounts.get(c) == 0){
                    return false;
                }
                charCounts.put(c, charCounts.get(c) - 1);
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "aab";
        System.out.println(canConstruct(ransomNote, magazine));
        ransomNote = "a";
        magazine = "b";
        System.out.println(canConstruct(ransomNote, magazine));
    }
}
