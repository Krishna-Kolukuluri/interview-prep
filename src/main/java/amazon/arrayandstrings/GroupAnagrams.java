package amazon.arrayandstrings;

import java.util.*;
import java.util.List;
import java.util.Map;
/*
* https://leetcode.com/problems/group-anagrams/
* Given an array of strings strs, group the anagrams together. You can return the answer in any order.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
Example 1:
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
*
Example 2:
Input: strs = [""]
Output: [[""]]
*
Example 3:
Input: strs = ["a"]
Output: [["a"]]
* */
public class GroupAnagrams {
    /*
    * Complexity Analysis
        Time Complexity: O(NKlogK), where N is the length of strs, and K is the maximum length of a string in strs.
        The outer loop has complexity O(N) as we iterate through each string. Then, we sort each string in O(KlogK) time.
        Space Complexity: O(NK), the total information content stored in ans.
    * */
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0)
            return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key))
                ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }
}
