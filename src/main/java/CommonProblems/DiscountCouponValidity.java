package CommonProblems;
/*
Determine whether a given discount coupon is valid or not
The validity of a coupon is determined by:
An empty discount coupon is valid
if a coupon A is valid, then a coupon C made by adding one character d to both the beginning of A and the end of A is also valid ( C = dAd is valid)
if two coupons A & B are valid, then the concatenation of B & A is also valid ( AB & BA are both valid )
Given n coupons, all lower case english characters, determine if a coupon is valid or not. Valid is denoted by 1, invalid by 0

coupons = ['abba', 'abca']
checking abba

An empty coupon is valid
Under the second rule, the same character can be added to the beginning and end of a valid coupon. Add b to get bb as valid
Using the same rule, add a to the beginning and end of 'bb' to get 'abba'.
it is valid

There are 3 rules for a valid string:

An empty string is valid
You can add same character to a valid string X, and create another valid string yXy
You can concatenate two valid strings X and Y, so XY will also be valid.
Ex: vv, xbbx, bbccdd, xyffyxdd are all valid.
*
*/

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class DiscountCouponValidity {
    public static void main(String[] args) {
        String[] coupons = {"vav", "xbbx", "bbccdd", "xyffyxdd","abca",""};
        List<Integer> results = Arrays.asList(isDiscountCouponValid(coupons));
        System.out.println(results);
    }
    private static Integer[] isDiscountCouponValid(String[] coupons){
        //Valid coupon is marked with 1
        //invalid coupon is marked with 0
        //Return validity of all coupons.
        Integer[] validityResults = new Integer[coupons.length];
        int index = 0;
        Stack<Character> couponChars = new Stack<>();
        for(String coupon: coupons){
            couponChars.clear();
            for(Character c: coupon.toCharArray()){
                if(!couponChars.isEmpty()){
                    if(couponChars.peek().equals(c)){
                        couponChars.pop();
                    }else{
                        couponChars.push(c);
                    }
                }else{
                    couponChars.push(c);
                }
            }
            if(couponChars.isEmpty()){
                validityResults[index] = 1;
            }
            else{
                validityResults[index] = 0;
            }
            index++;
        }
        return validityResults;
    }
}
