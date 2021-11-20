package datastructures.dstype.hashtable;

import java.util.*;

/*
Group Anagrams
Problem Statement:
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
typically using all the original letters exactly once.

* */
public class GroupAnagrams {
    public static void main(String[] args) {
        groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
    }

    public static List<List<String>> groupAnagrams(String[] strs){
        HashMap<String, List<String>> groups = new HashMap<>();
        for(String str:strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String tempString = new String(chars);
            groups.putIfAbsent(tempString, new ArrayList<>());
            List<String> tempStrings = groups.get(tempString);
            tempStrings.add(str);
            groups.put(tempString, tempStrings);
        }
        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry:groups.entrySet()){
            result.add(entry.getValue());
        }
        return result;
    }
    /*
    Complexity Analysis

    Time Complexity: O(NKlogK), where N is the length of strs, and K is the maximum length of a string
    in strs. The outer loop has complexity O(N) as we iterate through each string. Then, we sort each string in
    O(KlogK) time.

    Space Complexity: O(NK), the total information content stored in ans.
    * */
}
