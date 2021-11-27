package search;
/*
Find Minimum in Rotated Sorted Array
Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:

[4,5,6,7,0,1,2] if it was rotated 4 times.
[0,1,2,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums of unique elements, return the minimum element of this array.

You must write an algorithm that runs in O(log n) time.
* */
public class MinimumInRotatedSortedArraySearch {
    public static void main(String[] args) {

    }
    public static int findRotatedIndex(int nums[]){
        int left = 0;
        int right = nums.length - 1;
        int pivot = 0;
        if(nums[left] < nums[right] || right == 0){
            return nums[left];
        }
        while (left<=right){
            pivot = left + (right - left)/2;
            if(nums[pivot] > nums[pivot + 1]){
                return nums[pivot + 1];
            }
            else if(nums[pivot] < nums[left]){
                right = pivot -1;
            }
            else {
                left = pivot + 1;
            }
        }
        return nums[0];
    }
}
