package datastructures.dstype.stringType;
/*
Given an integer, convert it to a roman numeral.
Constraints: 1 <= num <= 3999
* */
public class NumberToRomanExample {
}
class NumberToRoman{
    //Constant Space i.e. number of Roman literals(Special cases) i.e. takes hit with Time complexity
    //But, due to number different entire roman literals are not more than few tens in total its still considered as O(1)
    //Space complexity.
    //Time complexity is still linear proportionate to number of roman literals and input number to be converted
    //Which is stilled considered as ~O(1) time complexity.
    private String[] romanLiterals = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    private int[] romanEquivalentNumbers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    public String convert(int num){
        StringBuilder sb = new StringBuilder();
        for(int index=0; index<romanEquivalentNumbers.length && num > 0; index++){
            while (romanEquivalentNumbers[index] <= num){
                num -= romanEquivalentNumbers[index];
                sb.append(romanLiterals[index]);
            }
        }
        return sb.toString();
    }
    /*
    Complexity Analysis

        Time complexity : O(1).

        As there is a finite set of roman numerals, there is a hard upper limit on how many times the loop can iterate.
        This upper limit is 15 times, and it occurs for the number 3888, which has a representation of MMMDCCCLXXXVIII.
        Therefore, we say the time complexity is constant, i.e. O(1).

        Space complexity : O(1).
        The amount of memory used does not change with the size of the input integer, and is therefore constant.
    * */


    //Below approach is better time complexity at the expense of additional space.
    private final String[] thousands = {"", "M", "MM", "MMM"};
    private final String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    private final String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    private final String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    public String convertFast(int num){
        return thousands[num/1000] + hundreds[(num%1000)/100] + tens[(num%100)/10] + ones[num%10];
    }
    /*
    *
    Complexity Analysis

        Time complexity : O(1).

        The same number of operations is done, regardless of the size of the input. Therefore, the time complexity is constant.

        Space complexity : O(1).

        While we have Arrays, they are the same size, regardless of the size of the input. Therefore, they are constant
        for the purpose of space-complexity analysis.
    * */
}
