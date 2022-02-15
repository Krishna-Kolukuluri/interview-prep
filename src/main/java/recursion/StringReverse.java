package recursion;
/*
* https://leetcode.com/problems/reverse-string/
* Write a function that reverses a string. The input string is given as an array of characters s.
You must do this by modifying the input array in-place with O(1) extra memory.
*
Example 1:
Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
*
Example 2:
Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]
* */
public class StringReverse {
    public static void main(String[] args) {
        String originalString = "Krishna_Kolukuluri";
        printReverse(originalString.toCharArray(), 0);
    }

    private static void printReverse(char[] charArray, int index){
        if(index>= charArray.length || charArray == null){
            return;
        }
        printReverse(charArray, index + 1);
        System.out.println(charArray[index]);
    }

    private static char[] reverseString(char[] chars){
        int startIndex = 0;
        int endIndex = chars.length - 1;
        while (startIndex < endIndex){
            char temp = chars[startIndex];
            chars[startIndex] = chars[endIndex];
            chars[endIndex] = temp;
            startIndex++;
            endIndex--;
        }
        return chars;
    }
}
