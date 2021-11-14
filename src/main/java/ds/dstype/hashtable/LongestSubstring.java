package ds.dstype.hashtable;

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
}
