package amazon.arrayandstrings;

import java.util.HashMap;

public class LongestSubstringWithoutRepeat {
    public static void main(String args[]) {
        System.out.println(longSubStr("abbcabca"));
    }
    static String longSubStr(String s){
        HashMap<Character,Integer> substr = new HashMap<>();
        int start = 0,start1=0,currentLength=0,maxLen=0;
        int j=0;
        for(j=0;j<s.length();j++){
            if(substr.containsKey(s.charAt(j))){
               if(substr.get(s.charAt(j))>=start1){
                   currentLength = j-start1;
                   if(maxLen<currentLength){
                       maxLen=currentLength;
                       start=start1;
                   }
                   start1 = substr.get(s.charAt(j))+1;
               }
               substr.replace(s.charAt(j), j);
            }else{
                substr.put(s.charAt(j),j);  
            }
        }
        if (maxLen < j - start1)
        {
            maxLen = j - start1;
            start = start1;
        }
        return s.substring(start,
                start +
                maxLen);
    }
}
