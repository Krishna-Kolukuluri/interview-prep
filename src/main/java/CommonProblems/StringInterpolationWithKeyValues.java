package CommonProblems;

import java.util.*;
/*
*
*
You are given a string s that contains some bracket pairs, with each pair containing a non-empty key.

For example, in the string "(name)is(age)yearsold", there are two bracket pairs that contain the keys "name" and "age".
You know the values of a wide range of keys. This is represented by a 2D string array knowledge where each knowledge[i]
= [keyi, valuei] indicates that key keyi has a value of valuei.

You are tasked to evaluate all of the bracket pairs. When you evaluate a bracket pair that contains some key keyi, you will:

Replace keyi and the bracket pair with the key's corresponding valuei.
If you do not know the value of the key, you will replace keyi and the bracket pair with a question mark "?" (without
the quotation marks).
Each key will appear at most once in your knowledge. There will not be any nested brackets in s.

Return the resulting string after evaluating all of the bracket pairs.
*
* */
public class StringInterpolationWithKeyValues {
    public static void main(String[] args) {
        MapAndReplaceKeys mapAndReplaceKeys = new MapAndReplaceKeys();
        char open = '(';
        char close = ')';
        String str = "(name)is(age)yearsold";
        List<List<String>> knowledge = new ArrayList<>();
        knowledge.add(new ArrayList<>(Arrays.asList("name", "Krishna")));
        knowledge.add(new ArrayList<>(Arrays.asList("age", "35")));
        System.out.println(mapAndReplaceKeys.evaluate(str, knowledge, open, close));

        knowledge.add(new ArrayList<>(Arrays.asList("user", "Alex")));
        knowledge.add(new ArrayList<>(Arrays.asList("city", "Seattle")));
        knowledge.add(new ArrayList<>(Arrays.asList("month", "December")));
        String find = "mynameis#user#livesin#city#month";
        open = '#';
        System.out.println(mapAndReplaceKeys.evaluate(find, knowledge, open, open));

        find = "mynameis#user#livesin#city##month#";
        open = '#';
        System.out.println(mapAndReplaceKeys.evaluate(find, knowledge, open, open));
    }


}
class MapAndReplaceKeys{
    public String evaluate(String str, List<List<String>> knowledge, char open, char close){
        HashMap<String, String> keyValues = new HashMap<>();
        for(List<String> pair: knowledge){
            keyValues.put(pair.get(0), pair.get(1));
        }
        StringBuilder resultString = new StringBuilder();
        for(int index=0;index<str.length();index++){
            char c = str.charAt(index);
            if(c == open){
                int idx = index+1;
                while (idx<str.length() && str.charAt(idx) != close){
                    idx++;
                }
                resultString.append(keyValues.getOrDefault(str.substring(index+1, idx), "?"));
                index = idx;
            }
            else{
                resultString.append(c);
            }
        }
        return resultString.toString();
    }
}
