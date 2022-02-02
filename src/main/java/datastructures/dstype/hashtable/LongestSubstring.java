package datastructures.dstype.hashtable;

import java.util.*;

/*
Problem Statement:
Given a string s, find the length of the longest substring without repeating characters
* */
//Space Complexity: O(N) + O(N) = O(2N)
//Time Complexity: O(N)
public class LongestSubstring {
    public int lengthOfLongestSubString(String s){
        HashSet<Character> set = new HashSet<>();
        Queue<Character> queue = new LinkedList<>();

        String subString = "";
        int curMax = 0;
        for(char c: s.toCharArray()){
            if(set.contains(c)){
                if(curMax < set.size()){
                    curMax = set.size();
                }
                while(!queue.isEmpty()){
                    char tempChar = queue.peek();
                    set.remove(queue.peek());
                    queue.poll();
                    if(tempChar == c){
                        break;
                    }
                }
            }
            queue.offer(c);
            set.add(c);
        }
        if(curMax < set.size()){
            curMax = set.size();
        }
        return curMax;
    }

    /*
    *
    Approach 3: Sliding Window Optimized
    The above solution requires at most 2n steps. In fact, it could be optimized to require only n steps. Instead of using a
    set to tell if a character exists or not, we could define a mapping of the characters to its index. Then we can skip the
    characters immediately when we found a repeated character.

    The reason is that if s[j] have a duplicate in the range [i,j) with index j we don't need to increase i little by little.
    We can skip all the elements in the range [i,j] and let i to be j+ 1 directly.
    * */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
    /*
    Complexity Analysis:
    Time complexity : O(n). Index jj will iterate nn times.
    Space complexity (HashMap) : O(min(m,n)). Same as the previous approach.
    Space complexity (Table): O(m). mm is the size of the charset.
    * */
}
