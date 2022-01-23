package datastructures.dstype.stringType;
/*
Given a character array s, reverse the order of the words.
A word is defined as a sequence of non-space characters. The words in s will be separated by a single space.
Your code must solve the problem in-place, i.e. without allocating extra space.
*
Example 1:
Input: s = ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
*
Example 2:
Input: s = ["a"]
Output: ["a"]
* */
public class ReverseWordInStringIII {
    public static void main(String[] args) {
        char[] s = new char[]{'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
        reverseWords(s);
        System.out.println(s);

    }
    public static void reverse(char[] s, int left, int right) {
        while (left < right) {
            char tmp = s[left];
            s[left++] = s[right];
            s[right--] = tmp;
        }
    }

    public static void reverseEachWord(char[] s) {
        int n = s.length;
        int start = 0, end = 0;

        while (start < n) {
            // go to the end of the word
            while (end < n && s[end] != ' ') ++end;
            // reverse the word
            reverse(s, start, end - 1);
            // move to the next word
            start = end + 1;
            ++end;
        }
    }

    public static void reverseWords(char[] s) {
        // reverse the whole string
        reverse(s, 0, s.length - 1);

        // reverse each word
        reverseEachWord(s);
    }
}
/*
Complexity Analysis
Time complexity: O(N), it's two passes along the string.
Space complexity: O(1), it's a constant space solution.
* */
