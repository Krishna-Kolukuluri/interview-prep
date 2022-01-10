package CommonProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/*
https://leetcode.com/problems/sort-characters-by-frequency/solution/
Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is
the number of times it appears in the string.

Return the sorted string. If there are multiple answers, return any of them.
* */
public class SortCharsByFrequency {
    public static void main(String[] args) {

    }
    private static String frequencySort(String s){
        if (s == null || s.isEmpty()) return s;
        HashMap<Character, Integer> map = new HashMap<>();
        for(Character c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        int maxFrequency = Collections.max(map.values());

        //Buckets list for each position.
        List<List<Character>> buckets= new ArrayList<>();
        for(int index =0; index<=maxFrequency;index++){
            buckets.add(new ArrayList<Character>());
        }
        for(Character key: map.keySet()){
            buckets.get(map.get(key)).add(key);
        }
        //Building reverseString with descending frequency.
        StringBuilder sb = new StringBuilder();
        for(int index=buckets.size() -1; index>=1; index--){
            for(Character ch: buckets.get(index)){
                for(int chCount=0; chCount<index; chCount++){
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
    }
}
/*
*
Complexity Analysis

Let nn be the length of the input String. The kk (number of unique characters in the input String that we considered for
the last approach makes no difference this time).

Time Complexity : O(n).
Like before, the HashMap building has a cost of O(n).
The bucket sorting is O(n), because inserting items has a cost of O(k) (each entry from the HashMap), and building the
buckets initially has a worst case of O(n) (which occurs when k = 1k=1). Because k ≤ nk≤n, we're left with O(n).
So in total, we have O(n).
It'd be impossible to do better than this, because we need to look at each of the nn characters in the input String at least once.

Space Complexity : O(n).
Same as above. The bucket Array also uses O(n) space, because its length is at most nn, and there are kk items across all the buckets.
* */