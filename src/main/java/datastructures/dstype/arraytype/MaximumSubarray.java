package datastructures.dstype.arraytype;
/*
* https://leetcode.com/problems/maximum-subarray/
* Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
* A subarray is a contiguous part of an array.
*
Example 1:
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
*
Example 2:
Input: nums = [1]
Output: 1
*
Example 3:
Input: nums = [5,4,-1,7,8]
Output: 23
*
* */
public class MaximumSubarray {
    /*
    * Algorithm: Dynamic Programming
    Initialize 2 integer variables. Set both of them equal to the first value in the array.

    currentSubarray will keep the running count of the current subarray we are focusing on.
    maxSubarray will be our final return value. Continuously update it whenever we find a bigger subarray.
    Iterate through the array, starting with the 2nd element (as we used the first element to initialize our variables).
    For each number, add it to the currentSubarray we are building. If currentSubarray becomes negative, we know it isn't
    worth keeping, so throw it away. Remember to update maxSubarray every time we find a new maximum.

    Return maxSubarray.

    Implementation:
    A clever way to update currentSubarray is using currentSubarray = max(num, currentSubarray + num). If currentSubarray
    is negative, then num > currentSubarray + num.
    * */
    public static int maxSubArrayDP(int[] nums){
        // Initialize our variables using the first element.
        int currentSubArray = nums[0];
        int maxSubArray = nums[0];
        // Start with the 2nd element since we already used the first one.
        for(int i=1; i<nums.length;i++){
            int num = nums[i];
            // If current_subarray is negative, throw it away. Otherwise, keep adding to it.
            currentSubArray = Math.max(num, currentSubArray+num);
            maxSubArray = Math.max(currentSubArray, maxSubArray);
        }
        return maxSubArray;
    }
    /*
    * Complexity Analysis:
        Time complexity: O(N), where N is the length of nums.
        We iterate through every element of nums exactly once.
        Space complexity: O(1)
        No matter how long the input is, we are only ever using 2 variables: currentSubarray and maxSubarray.
    * */


    /*
    * Algorithm: Divide & Conquer (Recursion).
        Now that we know how to find the best subarray containing elements from both sides of any given array, the algorithm is as follows:
        Define a helper function that we will use for recursion.

        This function will take an input left and right, which defines the bounds of the array. The return value of this
        function will be the best possible subarray for the array that fits between left and right.
        If left > right, we have an empty array. Return negative infinity.
        Find the midpoint of our array. This is (left + right) / 2, rounded down. Using this midpoint, find the best possible
        subarray that uses elements from both sides of the array with the algorithm detailed in the animation above.
        The best subarray using elements from both sides is only 1 of 3 possibilities. We still need to find the best
        subarray using only the left or right halves. So, call this function again, once with the left half, and once with the right half.
        Return the largest of the 3 values - the best left half sum, the best right half sum, and the best combined sum.
        Call our helper function with the entire input array (left = 0, right = length - 1). This is our final answer, so return it.
    *
    * */
    private static int[] numsArray;
    public static int maxSubArrayDC(int[] nums){
        numsArray = nums;
        // Our helper function is designed to solve this problem for
        // any array - so just call it using the entire input!
        return findBestSubarray(0, numsArray.length -1);
    }
    private static int findBestSubarray(int left, int right){
        // Base case - empty array.
        if(left>right){
            return Integer.MIN_VALUE;
        }
        //Finding middle index in nums array
        int mid = Math.floorDiv(left+right, 2);
        //Initialize temp variables to store sums
        int currVal = 0;
        int bestLeftSum = 0;
        int bestRightSum = 0;

        // Iterate from the middle to the beginning.
        for(int i =mid-1;i>=left;i--){
            currVal += numsArray[i];
            bestLeftSum = Math.max(currVal, bestLeftSum);
        }
        // Reset curr and iterate from the middle to the end.
        currVal = 0;
        for(int i=mid+1;i<=right;i++){
            currVal += numsArray[i];
            bestRightSum = Math.max(bestRightSum, currVal);
        }
        // The bestCombinedSum uses the middle element and the best
        // possible sum from each half.
        int bestCombinedSum = numsArray[mid] + bestLeftSum + bestRightSum;

        // Find the best subarray possible from both halves.
        int leftHalf = findBestSubarray(left, mid -1);
        int rightHalf = findBestSubarray(mid+1, right);

        // The largest of the 3 is the answer for any given input array.
        return Math.max(bestCombinedSum , Math.max(leftHalf, rightHalf));
    }
    /*
    * Complexity Analysis:
        Time complexity: O(N⋅logN), where N is the length of nums.
        On our first call to findBestSubarray, we use for loops to visit every element of nums. Then, we split the array
        in half and call findBestSubarray with each half. Both those calls will then iterate through every element in that
        half, which combined is every element of nums again. Then, both those halves will be split in half, and 4 more calls
        to findBestSubarray will happen, each with a quarter of nums. As you can see, every time the array is split, we
        still need to handle every element of the original input nums. We have to do this logN times since that's
        how many times an array can be split in half.

        Space complexity: O(logN), where N is the length of nums.
        The extra space we use relative to input size is solely occupied by the recursion stack. Each time the array gets
        split in half, another call of findBestSubarray will be added to the recursion stack, until calls start to get
        resolved by the base case - remember, the base case happens at an empty array, which occurs after logN calls.
    *
    * */
}
