package datastructures.dstype.hashtable;

import java.util.*;

/*
Intersection of Two Arrays
Problem Statement:
Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be
unique and you may return the result in any order.

* */
public class IntersectionOfTwoArrays {
    public static int[] intersectionOfArrays(int[] nums1, int[] nums2){
        Set<Integer> baseNums = new HashSet<>();
        Set<Integer> intersectionNums = new HashSet<>();
        for(int num1: nums1){
            baseNums.add(num1);
        }
        for(int num2:nums2){
            intersectionNums.add(num2);
        }
        intersectionNums.retainAll(baseNums);
        int[] commonNums = new int[intersectionNums.size()];
        int idx = 0;
        for(int num: intersectionNums){
            commonNums[idx] = num;
            idx++;
        }
        return commonNums;
    }

    //Problem Statement
    /*
     Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must
     appear as many times as it shows in both arrays and you may return the result in any order.
    * */
    public int[] intersectionOfArraysII(int[] nums1, int[] nums2){
        HashMap<Integer, Integer> numsMap = new HashMap<Integer, Integer>();
        List<Integer> resultList = new ArrayList<>();
        for(int num:nums1){
            numsMap.putIfAbsent(num, 0);
            numsMap.put(num, numsMap.get(num) + 1);
        }
        for(int num:nums2){
            if(numsMap.containsKey(num)){
                if(numsMap.get(num)>0){
                    resultList.add(num);
                    numsMap.put(num, numsMap.get(num) - 1);
                }
            }
        }
        int[] finalResult = new int[resultList.size()];
        for(int index=0;index<resultList.size();index++){
            finalResult[index] = resultList.get(index);
        }
        return finalResult;
    }
}
