package ds.dstype.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Problem Statement:
/*
We can shift a string by shifting each of its letters to its successive letter.

For example, "abc" can be shifted to be "bcd".
We can keep shifting the string to form a sequence.

For example, we can keep shifting "abc" to form the sequence: "abc" -> "bcd" -> ... -> "xyz".
Given an array of strings strings, group all strings[i] that belong to the same shifting sequence. You may return the
answer in any order.
* */
public class GroupShiftedStrings {
    public static void main(String[] args) {

    }
    public List<List<String>> groupShiftedStrings(String[] strings){
        HashMap<Integer, List<String>> groups = new HashMap<>();
        for(String str: strings){
            int charCount = str.length();
            groups.putIfAbsent(charCount, new ArrayList<>());
            List<String> tempList = groups.get(charCount);
            tempList.add(str);
            groups.put(charCount, tempList);
        }
        List<List<String>> resultList = new ArrayList<>();
        for(Map.Entry<Integer, List<String>> entry: groups.entrySet()){
            resultList.add(entry.getValue());
        }
        return resultList;
    }
}
