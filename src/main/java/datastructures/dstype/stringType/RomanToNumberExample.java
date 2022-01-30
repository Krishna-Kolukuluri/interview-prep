package datastructures.dstype.stringType;

import java.util.HashMap;

/*
* https://leetcode.com/problems/roman-to-integer/
Given a roman numeral, convert it to an integer.
Constraints:
1 <= s.length <= 15
s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
It is guaranteed that s is a valid roman numeral in the range [1, 3999].
* */
public class RomanToNumberExample {
}
class RomanToNumber{
    char[] romanLiterals = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
    HashMap<String, Integer> valueMap = new HashMap<>();
    public RomanToNumber(){
        valueMap.put("M", 1000);
        valueMap.put("D", 500);
        valueMap.put("C", 100);
        valueMap.put("L", 50);
        valueMap.put("X", 10);
        valueMap.put("V", 5);
        valueMap.put("I", 1);
        valueMap.put("IV", 4);
        valueMap.put("IX", 9);
        valueMap.put("XL", 40);
        valueMap.put("XC", 90);
        valueMap.put("CD", 400);
        valueMap.put("CM", 900);
    }
    //This approach takes hit time complexity for better space complexity.
    public int convert(String romanVal){
        int sum = 0;
        int index = 0;
        while (index < romanVal.length()){
            String currentLiteral = romanVal.substring(index, index + 1);
            int currentLiteralVal = valueMap.get(currentLiteral);
            int nextLiteralVal = 0;
            if(index + 1 < romanVal.length()){
                String nextLiteral = romanVal.substring(index+1, index +2);
                nextLiteralVal = valueMap.get(nextLiteral);
            }
            if(currentLiteralVal < nextLiteralVal){
                sum += (nextLiteralVal - currentLiteralVal);
                index += 2;
            }
            else{
                sum += currentLiteralVal;
                index++;
            }
        }
        return sum;
    }
    /*
    *
    Complexity Analysis
        Let n be the length of the input string (the total number of symbols in it).
        Time complexity : O(1).
        As there is a finite set of roman numerals, the maximum number possible number can be 3999, which in roman
        numerals is MMMCMXCIX. As such the time complexity is O(1).
        If roman numerals had an arbitrary number of symbols, then the time complexity would be proportional to the
        length of the input, i.e. O(n). This is assuming that looking up the value of each symbol is O(1).
        *
        Space complexity : O(1).
        Because only a constant number of single-value variables are used, the space complexity is O(1).
    *
    * */


    //This approach faster compared above version at expense of additional space.
    public int convertFast(String romanVal){
        int sum = 0;
        int index = 0;
        while (index < romanVal.length()){
            if (index < romanVal.length() - 1){
                String doubleLiterals = romanVal.substring(index, index + 2);
                if(valueMap.containsKey(doubleLiterals)){
                    sum += valueMap.get(doubleLiterals);
                    index += 2;
                    continue;
                }
            }
            String singleLiteral = romanVal.substring(index, index + 1);
            sum += valueMap.get(singleLiteral);
            index ++;
        }
        return sum;
    }
    /*
    *
    Complexity Analysis
        Time complexity : O(1).
        Same as Approach 1.

        Space complexity : O(1).
        Same as Approach 1.
    *
    * */
}

