package datastructures.dstype.stringType;
/*
Given an input string s, reverse the order of the words.
A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
Return a string of the words in reverse order concatenated by a single space.
Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should
only have a single space separating the words. Do not include any extra spaces.
* */
public class ReverseWordsInString {
    public static void main(String[] args) {
        System.out.println(reverseWordsOrder("Let's take LeetCode contest")); // contest LeetCode take Let's
    }
    public static String reverseWordsOrder(String s){
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int index=words.length -1;index>=0;index--){
            if(!words[index].equals("")){
                sb.append(" ").append(words[index]);
            }
        }
        return sb.toString().trim();
    }
}
/*
Time complexity: O(N), where N is a number of characters in the input string.
Space complexity: O(N), to store the result of split by spaces.
* */
