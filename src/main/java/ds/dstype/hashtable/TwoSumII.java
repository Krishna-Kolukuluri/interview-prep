package ds.dstype.hashtable;

/*
Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that
they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2]
where 1 <= index1 < index2 <= numbers.length.

Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.

The tests are generated such that there is exactly one solution. You may not use the same element twice.
* */
//Approach : Two Pointer as array is sorted non descending order
//Sorting take O(logn) time complexity to unordered array operations.
public class TwoSumII {
    public int[] twoSumSortedArray(int[] numbers, int target){
        int startIdx = 0;
        int lastIdx = numbers.length - 1;
        while(startIdx < lastIdx){
            int tempSum = numbers[startIdx] + numbers[lastIdx];
            if(tempSum == target){
                return new int[]{startIdx+1, lastIdx+1};
            }
            else if(tempSum > target){
                lastIdx--;
            }else{
                startIdx++;
            }
        }
        return null;
    }
}
