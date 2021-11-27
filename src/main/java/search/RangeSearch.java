package search;
/*
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
If target is not found in the array, return [-1, -1].
You must write an algorithm with O(log n) runtime complexity.
* */
public class RangeSearch {
    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        int target = 8;
        int[] result = searchRange(nums, target);
        System.out.println("["+ result[0] + "," + result[1]+"]");
    }

    public static int[] searchRange(int[] nums, int target){
        int[] result = new int[]{-1,-1};
        if(nums.length == 0 ){
            return result;
        }
        int firstIndex = findBoundaryIndex(nums, target, true);
        if(firstIndex == -1){
            return result;
        }
        int lastIndex = findBoundaryIndex(nums, target, false);
        result[0] = firstIndex;
        result[1] = lastIndex;
        return result;
    }

    public static int findBoundaryIndex(int[] nums, int target, boolean isFirst){
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        while (left <= right){
            int pivot = left + (right - left)/2;
            if(nums[pivot] == target){
                if(isFirst){
                    if(pivot == left || nums[pivot - 1] != target){
                        return pivot;
                    }
                    right = pivot - 1;
                }else{
                    if(pivot == right || nums[pivot + 1] != target){
                        return pivot;
                    }
                    left = pivot + 1;
                }
            }
            else if(target > nums[pivot]){
                left = pivot + 1;
            }
            else {
                right = pivot - 1;
            }
        }
        return -1;
    }
}
