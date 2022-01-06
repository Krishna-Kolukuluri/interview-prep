package CommonProblems;

import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.util.HashMap;
import java.util.Map;

/*
*
Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the
single element and return it.

You must implement a solution with a linear runtime complexity and use only constant extra space.
* */

public class SingleNumberII {

    public static void main(String[] args) {
        int[] nums = {0,1,0,1,0,1,99};
        System.out.println(singleNumber_LinearSpace(nums));
        System.out.println(singleNumber_ConstantSpace(nums));
    }

    /*
    Complexity:
    Time: O(N)
    Space: O(N) i.e. O(N/3) for storing distinct elements.but this is not good enough as the question seeking constant
    space utilization i.e. O(1). only possible with bitwise operations(look at second solution in this class.
    * */
    public static int singleNumber_LinearSpace(int[] nums){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> keyValue: map.entrySet()){
            if(keyValue.getValue() == 1){
                return keyValue.getKey();
            }
        }
        return -1;
    }

    /*
    Bitmask Technique: to solve this in O(1) space complexity.
    If one builds an array bitmask with the help of XOR operator, following bitmask ^= x strategy, the bitmask would keep only
    the bits which appear odd number of times. That was discussed in details in the article Single Number II.
    * */
    /*
    Complexity:
    Time: O(N)
    Space: O(1) not allocating any extra space.only possible with bitwise operations i.e. ~(bitwise not(~)), ^(bitwise XOR(^))
           and &(bitwise and(&)) operations on each number from the array.
    * */
    public static int singleNumber_ConstantSpace(int[] nums){
        int seenOnce = 0, seenTwice = 0;

        for (int num : nums) {
            /***** Bitwise Operations ***/
            //https://leetcode.com/problems/single-number-ii/solution/
            //XOR of zero and a bit results in that bit
            //XOR of two equal bits (even if they are zeros) results in a zero

            // first appearance:
            // add num to seen_once
            // don't add to seen_twice because of presence in seen_once

            // second appearance:
            // remove num from seen_once
            // add num to seen_twice

            // third appearance:
            // don't add to seen_once because of presence in seen_twice
            // remove num from seen_twice
            seenOnce = ~seenTwice & (seenOnce ^ num);
            seenTwice = ~seenOnce & (seenTwice ^ num);
        }

        return seenOnce;
    }
}
