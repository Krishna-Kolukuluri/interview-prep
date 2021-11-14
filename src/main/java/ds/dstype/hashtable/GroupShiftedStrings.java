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
       List<List<String>> lists = groupShiftedStrings(new String[]{"abc","bcd","acef","xyz","az","ba","a","z","al"});
       System.out.println(lists.size());
    }
    //Time complexity: O(N) -- Main loop, O(M) max length of string in input array i.e. total O(N*M)
    //Space Complexity: O(N) for HashMap, O(M) for temp chars array  i.e. O(M+N).
    public static List<List<String>> groupShiftedStrings(String[] strings){
        HashMap<String, List<String>> groups = new HashMap<>();
        for(String str: strings){
            int charCount = str.length();
            String groupKey = getSequenceKey(str);
            groups.putIfAbsent(groupKey, new ArrayList<>());
            List<String> tempList = groups.get(groupKey);
            tempList.add(str);
            groups.put(groupKey, tempList);
        }
        List<List<String>> resultList = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry: groups.entrySet()){
            resultList.add(entry.getValue());
        }
        return resultList;
    }
    public static String getSequenceKey(String str){
        char[] chars = str.toCharArray();
        String distance  = "";
        char[] tempChars = new char[3];
        for(int index=0;index<chars.length - 1;index++){
            int localDiff = (chars[index+1] - chars[index]);
            if(localDiff<0){
                localDiff = localDiff + 26;
            }
            distance += localDiff;

        }
        return chars.length + "->" + distance;
    }
}
