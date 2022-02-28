package patterns.recursion;

import java.util.HashMap;

/*
*
* A string s is nice if, for every letter of the alphabet that s contains, it appears both in uppercase and lowercase.
* For example, "abABB" is nice because 'A' and 'a' appear, and 'B' and 'b' appear. However, "abA" is not because 'b' appears, but 'B' does not.

Given a string s, return the longest substring of s that is nice. If there are multiple, return the substring of the
* earliest occurrence. If there are none, return an empty string.

Example 1:
Input: s = "YazaAay"
Output: "aAa"
Explanation: "aAa" is a nice string because 'A/a' is the only letter of the alphabet in s, and both 'A' and 'a' appear.
"aAa" is the longest nice substring.
*
Example 2:
Input: s = "Bb"
Output: "Bb"
Explanation: "Bb" is a nice string because both 'B' and 'b' appear. The whole string is a substring.
Example 3:

Input: s = "c"
Output: ""
Explanation: There are no nice substrings.
* */
public class LongestNiceSubString {
    /*

    if String length == 0 return s
  1. create 2 HM inside method, mark countOf lowercase and uppercase.
  2. iterate through array at first occurance of char where counterpart is absent
  3. recursion (substring of main string (0,i))
     recursion (substring of main string (i+1,l))
     return longest String of above.
  4. if no such letter found return String
*/
    public static String longestNiceSubstring(String s) {
        if(s.length() == 0 ||s.length() == 1) return "";

        HashMap<Character,Integer> charCMap= new HashMap<Character, Integer>();
        char[] ch = s.toCharArray();
        for(char c : ch ){
            charCMap.put(c, 1);
        }

        int breakIndex = -1;
        for(char c : s.toCharArray()){
            //(char)91 = '['
            //Less than 91 all upper case letters
            if(c < (char)91){
                if(charCMap.get(c) != charCMap.get(toLowerCase(c))) {
                    breakIndex = s.indexOf(c);
                    break;
                }
            } else {
                if(charCMap.get(c) != charCMap.get(toUpperCase(c))) {
                    breakIndex = s.indexOf(c);
                    break;
                }
            }
        }
        if(breakIndex == -1){
            return s;
        }
        String left = longestNiceSubstring(s.substring(0,breakIndex));
        String right = longestNiceSubstring(s.substring(breakIndex+1, s.length()));
        if(left.length() < right.length()){
            return right;
        }
        return left;
    }

    public static char toLowerCase(char c){
        //char + 32 is lower case char
        return (char)(c+32);
    }

    public static char toUpperCase(char c){
        //char - 32 is upper case char
        return (char)(c-32);
    }

    public static void main(String[] args) {
        String s = "YazaAay";
        System.out.println(longestNiceSubstring(s));
    }
}
