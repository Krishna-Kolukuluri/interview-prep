package datastructures.dstype.hashtable;

import java.util.*;

public class Duplicates {
    public static void main(String[] args) {

    }
    /*
    Problem Statement:
    Given an integer array nums, return true if any value appears at least twice in the array, and return false if
    every element is distinct.
    * */
    public static boolean findDuplicates(int[] nums){
        Set<Integer> uniqueNums = new HashSet<>();
        for(int num: nums){
            if(!uniqueNums.contains(num)){
                uniqueNums.add(num);
            }else{
                return true;
            }
        }
        return false;
    }


    /*
    Contains Duplicate II
    Problem Statement:
    Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array
    such that nums[i] == nums[j] and abs(i - j) <= k.

    * */
    public static boolean findDuplicateWithKTarget(int[] nums, int k){
        HashMap<Integer, List<Integer>> resultMap = new HashMap<>();
        for(int index=0;index<nums.length;index++){
            if(resultMap.containsKey(nums[index])){
                for(Integer ind: resultMap.get(nums[index])){
                    if(Math.abs(ind - index) <= k){
                        return true;
                    }
                }
                List<Integer> indexList = resultMap.get(nums[index]);
                indexList.add(index);
                resultMap.put(nums[index], indexList);
            }
            else{
                List<Integer> indexList = new ArrayList<>();
                indexList.add(index);
                resultMap.put(nums[index], indexList);
            }
        }
        return false;
    }



    public static int findUniqueNum(int[] nums){
        Set<Integer> uniqueNums = new HashSet<>();
        Arrays.sort(nums);
        for(int num: nums){
            if(!uniqueNums.contains(num)){
                uniqueNums.add(num);
            }else{
                uniqueNums.remove(num);
            }
        }
        for(int num: uniqueNums){
            return num;
        }
        return 0;
    }
}
