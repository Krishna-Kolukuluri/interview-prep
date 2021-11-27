package search;
/*
Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search
target in nums. If target exists, then return its index. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.
* */
public class BinarySearchExample {
    public static void main(String[] args) {
        int targetIndex = find(new int[]{-1,0,3,5,9,12}, 9);
        System.out.println(targetIndex);
        targetIndex = find(new int[]{-1,0,3,5,9,12}, 2);
        System.out.println(targetIndex);

        targetIndex = find(new int[]{5}, 5);
        System.out.println(targetIndex);
    }
    public static int find(int[] nums, int target){
        int left = 0;
        int right= nums.length-1;
        int middle;
        while(left<=right){
            middle = left + (right - left)/2;
            if(nums[middle] == target){
                return middle;
            }
            if(target < nums[middle]){
                left = middle;
                right = middle - 1;
            }
            else{
                left = middle + 1;
            }
        }
        return -1;
    }
}
/*
Complexity Analysis:
Time complexity : O(logN).
Let's compute time complexity with the help of master theorem.
The equation represents dividing the problem up into aa subproblems of size time. Here at step there is only one
subproblem a = 1, its size is a half of the initial problem b = 2, and all this happens in a constant time d = 0.
That means that  and hence we're dealing with case 2 that results in O(logN) time complexity.

Space complexity : O(1) since it's a constant space solution.
* */