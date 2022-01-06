package CommonProblems;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*
*
Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly
twice. Find the two elements that appear only once. You can return the answer in any order.

You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.
*
* */
public class SingleNumberIII {

    public static void main(String[] args) {
        int[] nums = {1,2,1,3,2,5};
        System.out.println(Arrays.asList(singleNumber_LinearSpace(nums)));
    }


    /*
    Complexity:
    Time: O(N)
    Space: O(N) i.e. O(N/3) for storing distinct elements.but this is not good enough as the question seeking constant
    space utilization i.e. O(1). only possible with bitwise operations(look at second solution in this class.
    * */
    public static Integer[] singleNumber_LinearSpace(int[] nums){
        HashMap<Integer, Integer> map = new HashMap<>();
        Integer[] result = new Integer[2];
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int index = 0;
        for(Map.Entry<Integer, Integer> keyVal : map.entrySet()){
            if(keyVal.getValue() == 1){
                result[index] = keyVal.getKey();
                index++;
            }
        }
        return result;
    }

    /*
    Bitmask Technique: to solve this in O(1) space complexity.
    If one builds an array bitmask with the help of XOR operator, following bitmask ^= x strategy, the bitmask would keep only
    the bits which appear odd number of times. That was discussed in details in the article Single Number II.
    * */
    public static int[] singleNumber_ConstantSpace(int[] nums){
        //https://leetcode.com/problems/single-number-iii/solution/
        // difference between two numbers (x and y) which were seen only once
        int bitmask = 0;
        for (int num : nums) bitmask ^= num;

        // rightmost 1-bit diff between x and y
        int diff = bitmask & (-bitmask);

        int x = 0;
        // bitmask which will contain only x
        for (int num : nums) if ((num & diff) != 0) x ^= num;

        return new int[]{x, bitmask^x};
    }
}
