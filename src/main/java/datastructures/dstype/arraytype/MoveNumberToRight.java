package datastructures.dstype.arraytype;
/*
* https://leetcode.com/problems/move-zeroes/
* Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note: that you must do this in-place without making a copy of the array.
* Example 1:
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
*
* Example 2:
Input: nums = [0]
Output: [0]
* */
public class MoveNumberToRight {
    public static void main(String[] args) {
        int[] arr = new int[]{0,1,0,3,12};
        arr = moveZeros(arr);
        for(int val:arr){
            System.out.println(val);
        }
    }

    static int[] moveZeros(int[] arr){
        int len = arr.length;
        int writePointer = 0;
        int numToMove = 0;
        for(int readPointer = 0; readPointer< len; readPointer++){
            if(arr[readPointer] != numToMove){
                arr[writePointer++] = arr[readPointer];
            }
        }
        while (writePointer < len){
            arr[writePointer++] = numToMove;
        }
        return arr;
    }
}
