package search;
/*
* https://leetcode.com/problems/search-insert-position/solution/
* Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return
* the index where it would be if it were inserted in order.
You must write an algorithm with O(log n) runtime complexity.
* */
public class SearchInsertPosition {
    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,3,5,6},5));
        System.out.println(searchInsert(new int[]{1,3,5,6},2));
    }
    /*
    * Complexity Analysis
    * Time complexity : O(logN).
    * Space complexity : O(1) since it's a constant space solution.
    * */
    private static int searchInsert(int[] nums, int target){
        int pivot, left = 0, right = nums.length - 1;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            if (nums[pivot] == target) return pivot;
            if (target < nums[pivot]) right = pivot - 1;
            else left = pivot + 1;
        }
        return left;
    }
}
