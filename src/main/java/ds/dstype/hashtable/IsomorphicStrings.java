package ds.dstype.hashtable;

import java.util.*;

//Problem Statement
/*
Given two strings s and t, determine if they are isomorphic.
Two strings s and t are isomorphic if the characters in s can be replaced to get t.
All occurrences of a character must be replaced with another character while preserving the order of characters.
No two characters may map to the same character, but a character may map to itself.
* */
public class IsomorphicStrings {
    public static void main(String[] args) {
        isIsomorphic("badc", "baba");
    }
    public static boolean isIsomorphic(String s, String t){
        HashMap<Character,  Character> sChars = new HashMap<>();

        if(s.length() != t.length()){
            return false;
        }
        for(int index=0; index<s.length();index++){
            if(!sChars.containsKey(s.charAt(index))){
                if(sChars.containsValue(t.charAt(index))){
                    return false;
                }
                sChars.put(s.charAt(index), t.charAt(index));
            }else {
                char srcChar = s.charAt(index);
                char targetChar = sChars.get(srcChar);
                if(targetChar != t.charAt(index)){
                    return false;
                }
            }
        }
        return true;
    }
}
