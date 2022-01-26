package amazon.arrayandstrings;

import java.util.*;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    // Input: strs = ["eat","tea","tan","ate","nat","bat"]
    // Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
    public List<List<String>> groupAnagrams(String[] strs) {
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

}
