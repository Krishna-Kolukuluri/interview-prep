package ds.dstype.hashtable;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/*
Problem Statement:
Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
* */
public class FirstUniqueCharacterInString {
    public static void main(String[] args) {
        firstUniqueCharIndex("leetcode");
    }
    //HashMap doesn't maintain insertion order
    //LinkedHashMap maintains insertion order
    public static int firstUniqueCharIndex(String s){
        HashMap<Character, Integer> charsCount = new HashMap<>();
        for(char c: s.toCharArray()){
            charsCount.putIfAbsent(c, 0);
            charsCount.put(c,charsCount.get(c)+1);
        }
        for(int index=0; index<s.length();index++){
            if(charsCount.get(s.charAt(index)) == 1){
                return index;
            }
        }
        return -1;
    }
}
