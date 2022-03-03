package patterns.general;

import java.util.HashMap;
import java.util.Map;

/*
* https://leetcode.com/problems/valid-anagram/
* Given two strings s and t, return true if t is an anagram of s, and false otherwise.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the
original letters exactly once.
*
Example 1:
Input: s = "anagram", t = "nagaram"
Output: true
*
Example 2:
Input: s = "rat", t = "car"
Output: false
* */
public class ValidAnagram {
    /*
    * Complexity analysis:
    Time complexity : O(n). Time complexity is O(n) because accessing the counter table is a constant time operation.
    Space complexity : O(1). Although we do use extra space, the space complexity is O(1) because the table's size stays
                        constant no matter how large nn is.
    Follow up:
    What if the inputs contain unicode characters? How would you adapt your solution to such case?
    Answer:
    Use a hash table instead of a fixed size counter. Imagine allocating a large size array to fit the entire range of
    unicode characters, which could go up to more than 1 million. A hash table is a more generic solution and could adapt
    to any range of characters.
    * */
    public static boolean isAnagram(String s, String t){
        if(s.length() != t.length()){
            return false;
        }
        HashMap<Character, Integer> sMap = new HashMap<>();
        for(int i=0;i<s.length();i++){
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0)+1);
            sMap.put(t.charAt(i), sMap.getOrDefault(t.charAt(i), 0)-1);
        }
        for(Map.Entry<Character, Integer> entry: sMap.entrySet()){
            if(entry.getValue() != 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));
    }
}
