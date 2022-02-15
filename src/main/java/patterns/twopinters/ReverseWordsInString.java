package patterns.twopinters;
/*
* https://leetcode.com/problems/reverse-words-in-a-string-iii/
* Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
*
Example 1:
Input: s = "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
*
Example 2:
Input: s = "God Ding"
Output: "doG gniD"
*
* */
public class ReverseWordsInString {
    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }
    public static String reverseWords(String s){
        StringBuilder result = new StringBuilder();
        String[] words = s.split(" ");
        int wordCount = words.length;
        int count = 0;
        for(String word: words){
            int left = 0;
            int right = word.length() - 1;
            char[] chars = word.toCharArray();
            while (left<right){
                char leftTemp = chars[right];
                chars[right] = chars[left];
                chars[left] = leftTemp;
                left++;
                right--;
            }
            result.append(String.valueOf(chars));
            if(count < wordCount - 1){
                result.append(" ");
                count++;
            }
        }
        return result.toString();
    }
}
