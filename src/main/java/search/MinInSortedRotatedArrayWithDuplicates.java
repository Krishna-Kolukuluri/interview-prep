package search;
/*
Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array
nums = [0,1,4,4,5,6,7] might become:
[4,5,6,7,0,1,4] if it was rotated 4 times.
[0,1,4,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
Given the sorted rotated array nums that may contain duplicates, return the minimum element of this array.
You must decrease the overall operation steps as much as possible.
* */
public class MinInSortedRotatedArrayWithDuplicates {
    public static void main(String[] args) {
        int[] nums = new int[]{10,1,10,10,10};
        int min = findMin(nums);
        System.out.println(min);
    }
    public static int findMin(int[] nums){
        int left = 0;
        int right = nums.length - 1;
        while(left<right){
            int pivot = left + ((right -left)>>1);
            if(nums[pivot]< nums[right]){
                right = pivot;
            }
            else if(nums[pivot] > nums[right]){
                left = pivot+1;
            }else {
                right  -= 1;
            }
        }
        return nums[left];
    }
}
/*
Complexity Analysis

Time complexity: on average (log_{2}{N}) where N is the length of the array, since in general it is a binary search
algorithm. However, in the worst case where the array contains identical elements (i.e. case #3 nums[pivot]==nums[high]),
the algorithm would deteriorate to iterating each element, as a result, the time complexity becomes O(N).

Space complexity : O(1), it's a constant space solution.

* */
