package salesforce;

import java.util.*;

/**
    Input: strs = ["eat","tea","tan","ate","nat","bat"]
    Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
    
    Time Complexity: O(NK)O(NK), where NN is the length of strs, and KK is the maximum length of a string in strs. Counting each string is linear in the size of the string, and we count every string.

    Space Complexity: O(NK)O(NK), the total information content stored in ans.
 */
public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c - 'a']++;

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
//                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            System.out.println(key);
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }
    
    public static void main(String args[]){
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> result =  groupAnagrams(strs);
        System.out.println(result.size());
    }
}
