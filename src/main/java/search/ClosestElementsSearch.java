package search;

import java.util.ArrayList;
import java.util.List;

/*
Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result
should also be sorted in ascending order.

An integer a is closer to x than an integer b if:

|a - x| < |b - x|, or
|a - x| == |b - x| and a < b

* */
public class ClosestElementsSearch {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        int target = 3;
        int numOfElements = 4;
        List<Integer> result = findClosestElements(nums, numOfElements, target);
        for(int num: result){
            System.out.println(num);
        }
    }
    public static List<Integer> findClosestElements(int[] nums, int k, int x){
        List<Integer> result = new ArrayList<>();
        if(nums.length == k){
            for(int num: nums){
                result.add(num);
            }
            return result;
        }
        int left = 0;
        int right = nums.length - k;
        while (left < right){
            int pivot = left + (right - left)/2;
            if(x - nums[pivot] > nums[pivot + k] - x){
                left = pivot + 1;
            }
            else{
                right = pivot;
            }
        }
        for(int index=left; index<left+k;index++){
            result.add(nums[index]);
        }
        return result;
    }
}
