package patterns.general;
/*
* https://leetcode.com/problems/length-of-last-word/
* Given a string s consisting of some words separated by some number of spaces, return the length of the last word in the string.

A word is a maximal substring consisting of non-space characters only.
Example 1:
Input: s = "Hello World"
Output: 5
Explanation: The last word is "World" with length 5.
*
Example 2:
Input: s = "   fly me   to   the moon  "
Output: 4
Explanation: The last word is "moon" with length 4.
*
Example 3:
Input: s = "luffy is still joyboy"
Output: 6
Explanation: The last word is "joyboy" with length 6.
*
* */
public class LengthOfLastWord {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
    }
/*    public static int lengthOfLastWord(String s){
        String[] words = s.split(" ");
        int length  = 0;
        for(int i = words.length - 1; i>=0; i--){
            if(!words[i].isEmpty()){
                length =  words[i].length();
                break;
            }
        }
        return length;
    }*/

    public static int lengthOfLastWord(String s) {
        s = s.trim();  // trim the trailing spaces in the string
        return s.length() - s.lastIndexOf(" ") - 1;
    }
}
