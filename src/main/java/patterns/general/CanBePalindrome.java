package patterns.general;
/*
* https://leetcode.com/problems/valid-palindrome-ii/
* Given a string s, return true if the s can be palindrome after deleting at most one character from it.
Example 1:
Input: s = "aba"
Output: true
*
Example 2:
Input: s = "abca"
Output: true
Explanation: You could delete the character 'c'.
*
Example 3:
Input: s = "abc"
Output: false
* */
public class CanBePalindrome {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;
        while (left<=right){
            if (s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            }
            else{
                return isPalindrome(s,left,right-1) || isPalindrome(s,left+1,right);
            }
        }
        return true;
    }

    private boolean isPalindrome(String str, int left, int right){
        while (left <= right){
            if (str.charAt(left) == str.charAt(right)){
                left++;
                right--;
            }
            else
                return false;
        }

        return true;
    }
}
