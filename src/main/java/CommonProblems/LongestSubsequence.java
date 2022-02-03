package CommonProblems;

import java.util.HashMap;
import java.util.Map;

/*
* Longest Arithmetic Subsequence of Given Difference
* https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/
* https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/discuss/741381/Java-HashMap-DP-O(n)
*Given an integer array arr and an integer difference, return the length of the longest subsequence in arr which is an
* arithmetic sequence such that the difference between adjacent elements in the subsequence equals difference.
A subsequence is a sequence that can be derived from arr by deleting some or no elements without changing the order of the remaining elements.
* Example 1:
Input: arr = [1,2,3,4], difference = 1
Output: 4
Explanation: The longest arithmetic subsequence is [1,2,3,4].
* Example 2:
Input: arr = [1,3,5,7], difference = 1
Output: 1
Explanation: The longest arithmetic subsequence is any single element.
* Example 3:
Input: arr = [1,5,7,8,5,3,4,2,1], difference = -2
Output: 4
Explanation: The longest arithmetic subsequence is [7,5,3,1].
* */
public class LongestSubsequence {
    /*
    * every time we loop a new num, just check the length of subsequence ending with num - diff;
    * Space Complexity: O(N)
    * Time Complexity: O(N)
    * */
    public static int longestSubsequence(int[] arr, int diff) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 1;
        //Check through all i - diff and keep updating
        for (int num : arr) {
            int prev = map.getOrDefault(num - diff, 0);
            map.put(num, prev + 1);
            res = Math.max(map.get(num), res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr =new int[]{1,2,3,4};
        int difference = 1;
        System.out.println(longestSubsequence(arr, difference));
    }
}
