package search;
/*
A peak element is an element that is strictly greater than its neighbors.

Given an integer array nums, find a peak element, and return its index. If the array contains multiple peaks,
return the index to any of the peaks.

You may imagine that nums[-1] = nums[n] = -∞.

You must write an algorithm that runs in O(log n) time.

* */
public class PeakElementSearch {
    public static void main(String[] args) {
        int result =  findPeakElement(new int[]{1,2,3,1});
        System.out.println(result);
    }
    public static int findPeakElement(int[] nums){
        int left = 0;
        int right = nums.length -1;
        int pivot = 0;
        return getPeakElementIndex(nums, left, right);
    }
    public static int getPeakElementIndex(int[] nums, int left, int right){
        if(left == right){
            return left;
        }
        int pivot = left + (right - left)/2;
        if(nums[pivot] > nums[pivot + 1]){
            return getPeakElementIndex(nums, left, pivot);
        }
        return getPeakElementIndex(nums, pivot+1, right);
    }
}
