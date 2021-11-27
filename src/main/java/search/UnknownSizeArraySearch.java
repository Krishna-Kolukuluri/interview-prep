package search;
/*
This is an interactive problem.

You have a sorted array of unique elements and an unknown size. You do not have an access to the array but you can use
the ArrayReader interface to access it. You can call ArrayReader.get(i) that:

returns the value at the ith index (0-indexed) of the secret array (i.e., secret[i]), or
returns 231 - 1 if the i is out of the boundary of the array.
You are also given an integer target.

Return the index k of the hidden array where secret[k] == target or return -1 otherwise.
You must write an algorithm with O(log n) runtime complexity.
* */
public class UnknownSizeArraySearch {
    public static void main(String[] args) {
        ArrayReader arrayReader = new ArrayReader(new int[]{-1,0,3,5,9,12});
        int result = search(arrayReader, 9);
        System.out.println(result);

    }

    public static int search(ArrayReader reader, int target){
        if(reader.get(0) == target){
            return 0;
        }
        //Search left and right boundaries
        int left = 0;
        int right = 1;
        while (reader.get(right) < target){
            left = right;
            right <<= 1; // --> left shift == right * 2
        }

        //boundaries are set (left and right)
        //Start binary search
        while(left <= right){
            int pivot = left + ((right - left)>>1); // right shift == (right - left)/2
            int num = reader.get(pivot);
            if(num == target){
                return pivot;
            }
            if(num > target){
                right = pivot -1;
            }
            else {
                left = pivot + 1;
            }
        }
        return - 1;
    }
}
/*
Complexity Analysis
Time complexity : O(logT), where T is an index of target value.
Space complexity : O(1) since it's a constant space solution.
* */

class ArrayReader{
    public ArrayReader(int[] nums){
        this.nums = nums;
    }
    private int[] nums;
    public int get(int index){
        return nums[index];
    }
}
