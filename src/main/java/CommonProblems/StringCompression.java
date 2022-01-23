package CommonProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
*
Given an array of characters chars, compress it using the following algorithm:

Begin with an empty string s. For each group of consecutive repeating characters in chars:

If the group's length is 1, append the character to s.
Otherwise, append the character followed by the group's length.
The compressed string s should not be returned separately, but instead, be stored in the input character array chars.
Note that group lengths that are 10 or longer will be split into multiple characters in chars.

After you are done modifying the input array, return the new length of the array.

You must write an algorithm that uses only constant extra space.
*
Input: chars = ["a","a","b","b","c","c","c"]
Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".
*
Input: chars = ["a"]
Output: Return 1, and the first character of the input array should be: ["a"]
Explanation: The only group is "a", which remains uncompressed since it's a single character.
*
Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
Output: Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
Explanation: The groups are "a" and "bbbbbbbbbbbb". This compresses to "ab12".
* */
public class StringCompression {
    public static void main(String[] args) {
        StringCompress stringCompress = new StringCompress();
        char[] chars = new char[]{'a','a','b','b','c','c','c'};
        System.out.println(stringCompress.compress(chars));
        chars = new char[]{'a'};
        System.out.println(stringCompress.compress(chars));
        chars = new char[]{'a','a','b','b','c','c','c'};
        System.out.println(stringCompress.compress(chars));
        chars = new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        System.out.println(stringCompress.compress(chars));
    }

}

class StringCompress{
    public int compress(char[] chars){
        int compCharCount = 0;

        int charCount = 1;

        for (int i = 1; i<chars.length; i++){
            if(chars[i] == chars[i-1]){
                charCount++;
            }
            else{
                chars[compCharCount] = chars[i-1];
                compCharCount++;
                compCharCount = assignCountDigits(compCharCount, charCount, chars);
                charCount = 1;
            }
        }
        chars[compCharCount] = chars[chars.length - 1];
        compCharCount++;
        compCharCount = assignCountDigits(compCharCount, charCount, chars);
        System.out.println(chars);
        return compCharCount;
    }

    private int assignCountDigits(int compCharCount, int charCount, char[] chars){
        if(charCount>1){
            //Without using built in String functions
            List<Character> digits = toCharArray(charCount);
            for(int j=0; j<digits.size(); j++){
                chars[compCharCount] = digits.get(j);
                compCharCount++;
            }
            //With using built in string functions for toChar
/*            char[] digits = String.valueOf(charCount).toCharArray();
            for(int j=0; j<digits.length; j++){
                chars[compCharCount] = digits[j];
                compCharCount++;
            }*/
        }
        return compCharCount;
    }

    private List<Character> toCharArray(int charCount){
        List<Character> digits = new ArrayList<>();
        while(charCount != 0){
            digits.add((char)((charCount%10)+'0'));
            charCount = charCount/10;
        }
        Collections.reverse(digits);
        return digits;
    }
}
