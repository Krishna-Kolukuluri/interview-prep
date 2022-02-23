package patterns.bitmanipulation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
* https://leetcode.com/problems/palindrome-permutation/
* Given a string s, return true if a permutation of the string could form a palindrome.
* Example 1:
Input: s = "code"
Output: false
* Example 2:
Input: s = "aab"
Output: true
* Example 3:
Input: s = "carerac"
Output: true
* Constraints:
1 <= s.length <= 5000
s consists of only lowercase English letters.
*
* */
public class PalindromePermutation {
    public static void main(String[] args) {
        System.out.println(canPermutePalindrome("aab"));
    }

    /*
    * Complexity Analysis:
    Time complexity : O(n). We traverse over the given string ss with nn characters once. We also traverse over the map
                      which can grow up to a size of nn in case all characters in ss are distinct.

    Space complexity : O(1). The map can grow up to a maximum number of all distinct elements. However, the number of distinct
                       characters are bounded, so as the space complexity.
    * */
    private static boolean canPermutePalindrome(String s){
        HashMap<Character, Integer> charCounts = new HashMap<>();
        for(char c: s.toCharArray()){
            charCounts.put(c, charCounts.getOrDefault(c, 0)  + 1);
        }
        int count = 0;
        for(char key: charCounts.keySet()){
            count += charCounts.get(key)%2;
        }
        return count <= 1;
    }

    /*
    *
    * Complexity Analysis:
        Time complexity : O(n). We traverse over the string ss of length nn once only.
        Space complexity : O(1). A map of constant size(128) is used.
    * */
    public boolean canPermutePalindromeOnePass(String s) {
        /*
        * Instead of making use of the inbuilt Hashmap, we can make use of an array as a hashmap. For this, we make use
        * of an array map with length 128. Each index of this map corresponds to one of the 128 ASCII characters possible.
        * */
        int[] map = new int[128];
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            //s.charAt(i) <-- this gives integer value of the character ASCII integer value.
            map[s.charAt(i)]++;
            if (map[s.charAt(i)] % 2 == 0)
                count--;
            else
                count++;
        }
        return count <= 1;
    }

    public boolean canPermutePalindromeSet(String s) {
        Set<Character> set=new HashSet<Character>();
        for(int i=0; i<s.length(); ++i){
            if (!set.contains(s.charAt(i)))
                set.add(s.charAt(i));
            else
                set.remove(s.charAt(i));
        }
        /*
        * set.size()==0 corresponds to the situation when there are even number of any character in the string, and
        * set.size()==1 corresponds to the fact that there are even number of any character except one.
        * */
        return set.size()==0 || set.size()==1;
    }
}
