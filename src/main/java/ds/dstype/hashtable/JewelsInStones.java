package ds.dstype.hashtable;

import java.util.HashSet;

/*
Jewels and Stones
Problem Statement:
You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you have.
Each character in stones is a type of stone you have. You want to know how many of the stones you have are also jewels.

Letters are case sensitive, so "a" is considered a different type of stone from "A".
* */
//Time Complexity: O(N) + O(M)
//Space Complexity: O(N)
public class JewelsInStones {
    public int numJewelsInStones(String jewels, String stones){
        HashSet<Character> set = new HashSet<>();
        for(char j: jewels.toCharArray() ){
            set.add(j);
        }
        int numOfJewels = 0;
        for(char s: stones.toCharArray()){
            if(set.contains(s)){
                numOfJewels += 1;
            }
        }
        return numOfJewels;
    }
}
