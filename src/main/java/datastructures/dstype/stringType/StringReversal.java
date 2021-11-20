package datastructures.dstype.stringType;

/*
Write a function that reverses a string. The input string is given as an array of characters s.

You must do this by modifying the input array in-place with O(1) extra memory.
* */
public class StringReversal {
    public void reverseString(char[] s) {
        reverseStringInplace(s);
    }
    private char[] reverseStringInplace(char[] chars){
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
