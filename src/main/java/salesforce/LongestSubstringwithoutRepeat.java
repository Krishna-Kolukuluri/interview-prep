package salesforce;

/**
Given a string s, find the length of the longest substring without repeating characters.

Example 1:
    Input: s = "abcabcbb"
    Output: 3
    Explanation: The answer is "abc", with the length of 3.

Example 2:
    Input: s = "bbbbb"
    Output: 1
    Explanation: The answer is "b", with the length of 1.

Example 3:
    Input: s = "pwwkew"
    Output: 3
    Explanation: The answer is "wke", with the length of 3.
    Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
    
    We use HashSet to store the characters in current window [i, j)[i,j) (j = ij=i initially). 
    Then we slide the index jj to the right. If it is not in the HashSet, we slide jj further. 
    Doing so until s[j] is already in the HashSet. At this point, we found the maximum size of 
    substrings without duplicate characters start with index ii. 
    If we do this for all ii, we get our answer.
    
    O(2n)
 */
public class LongestSubstringwithoutRepeat {
    
    public int lengthOfLongestSubstring(String s) {
        int[] chars = new int[128];

        int left = 0;
        int right = 0;

        int res = 0;
        while (right < s.length()) {
            char r = s.charAt(right);
            chars[r]++;

            while (chars[r] > 1) {
                char l = s.charAt(left);
                chars[l]--;
                left++;
            }

            res = Math.max(res, right - left + 1);

            right++;
        }
        return res;
    }

}
