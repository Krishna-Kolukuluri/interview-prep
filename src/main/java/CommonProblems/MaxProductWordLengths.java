package CommonProblems;

import java.util.HashMap;
import java.util.Map;

/*
*
Given a string array words, return the maximum value of length(word[i]) * length(word[j]) where the two words do not
share common letters. If no such two words exist, return 0.
*
Input: words = ["abcw","baz","foo","bar","xtfn","abcdef"]
Output: 16
Explanation: The two words can be "abcw", "xtfn".
* */
public class MaxProductWordLengths {
    public int bitNumber(char ch){
        return (int)ch - (int)'a';
    }

    //https://leetcode.com/problems/maximum-product-of-word-lengths/solution/

    public int maxProduct(String[] words) {
        Map<Integer, Integer> hashmap = new HashMap();

        int bitmask = 0, bitNum = 0;
        for (String word : words) {
            bitmask = 0;
            for (char ch : word.toCharArray()) {
                // add bit number bitNumber in bitmask
                bitmask |= 1 << bitNumber(ch);
            }
            // there could be different words with the same bitmask
            // ex. ab and aabb
            hashmap.put(bitmask, Math.max(hashmap.getOrDefault(bitmask, 0), word.length()));
        }

        int maxProd = 0;
        for (int x : hashmap.keySet())
            for (int y : hashmap.keySet())
                if ((x & y) == 0) maxProd = Math.max(maxProd, hashmap.get(x) * hashmap.get(y));

        return maxProd;
    }
}
