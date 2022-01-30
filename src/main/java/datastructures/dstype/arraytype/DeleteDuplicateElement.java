package datastructures.dstype.arraytype;
/*
* https://leetcode.com/problems/remove-duplicates-from-sorted-array/solution/
*
Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element
appears only once. The relative order of the elements should be kept the same.
Since it is impossible to change the length of the array in some languages, you must instead have the result be placed
in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the
first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
Return k after placing the final result in the first k slots of nums.
Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
* */
public class DeleteDuplicateElement {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2};

        int[] numSquares = removeDuplicates(nums);
        for(int num:numSquares){
            System.out.println("numSquares ='" + num +"'");
        }
    }

    static int[] removeDuplicates(int[] nums){
        int count = 0;

        for(int index=0; index<nums.length;index++){
            if(index < nums.length -1 && nums[index] == nums[index + 1]){
                continue;
            }
            nums[count++] = nums[index];
        }

        return nums;
    }

    public int removeDuplicatesInplace(int[] nums) {

        // Check for edge cases.
        if (nums == null) {
            return 0;
        }

        // Use the two pointer technique to remove the duplicates in-place.
        // The first element shouldn't be touched; it's already in its correct place.
        int writePointer = 1;
        // Go through each element in the Array.
        for (int readPointer = 1; readPointer < nums.length; readPointer++) {
            // If the current element we're reading is *different* to the previous
            // element...
            if (nums[readPointer] != nums[readPointer - 1]) {
                // Copy it into the next position at the front, tracked by writePointer.
                nums[writePointer] = nums[readPointer];
                // And we need to now increment writePointer, because the next element
                // should be written one space over.
                writePointer++;
            }
        }

        // This turns out to be the correct length value.
        return writePointer;
    }
    /*
    * Complexity analysis
        Time complextiy : O(n). Assume that nn is the length of array. Each of i and j traverses at most nn steps.
        Space complexity : O(1).
    * */
}
