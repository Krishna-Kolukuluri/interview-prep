package search;
/*
There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length)
such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums,
or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.
* */
public class SortedRotatedArraySearch {
    public static void main(String[] args) {
        int result =  search(new int[]{4,5,6,7,0,1,2}, 0);
        System.out.println(result);

        result = search(new int[]{4,5,6,7,0,1,2}, 3);
        System.out.println(result);
    }

    public static int search(int[] nums, int target){
        int length = nums.length;
        if(length == 1){
            return nums[0] == target?0:-1;
        }
        int rotatedIndex = findRotateIndex(nums, 0, length -1);
        if(nums[rotatedIndex] == target){
            return rotatedIndex;
        }
        if(rotatedIndex == 0){
            return getTargetIndex(nums,target, 0, length - 1);
        }
        if(target< nums[0]){
            return getTargetIndex(nums, target, rotatedIndex, length - 1);
        }
        return getTargetIndex(nums, target, 0, rotatedIndex);
    }

    public static int getTargetIndex(int[] nums, int target, int left, int right){
        int middle = 0;
        while (left <= right){
            middle = left + (right - left)/2;
            if(nums[middle] == target){
                return middle;

            }else if(nums[middle] < target){
                left = middle + 1;

            }else {
                right = middle - 1;
            }
        }
        return -1;
    }
    public static int findRotateIndex(int[] nums, int left, int right){
        if(nums[left] < nums[right]){
            return 0;
        }
        while(left <= right){
            int middle = left + (right - left)/2;
            if(nums[middle] > nums[middle + 1]){
                return middle + 1;
            }
            else if(nums[middle] < nums[left]){
                right = middle -1;
            }
            else{
                left = middle + 1;
            }
        }
        return 0;
    }
}

/*
Complexity Analysis
Time complexity : O(logN).
Space complexity : O(1).
* */
