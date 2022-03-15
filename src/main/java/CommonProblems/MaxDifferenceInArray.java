package CommonProblems;
/*
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

Given an array arr[] of integers, find out the maximum difference between any two elements such that larger element appears after the smaller number.
*
Best Time to Buy and Sell Stock
You are given an array prices where prices[i] is the price of a given stock on the ith day.
You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
maxProfit
Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
Example 2:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.
* */
public class MaxDifferenceInArray {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 10, 6, 4, 8, 1};
        System.out.println(maxDifference(nums));
        nums = new int[]{7, 9, 5, 6, 3, 2};
        System.out.println(maxDifference(nums));
        nums = new int[]{7,1,5,3,6,4};
        System.out.println(maxDifference(nums));
        nums = new int[]{7,6,4,3,1};
        System.out.println(maxDifference(nums));

    }
    public static int maxDifference(int[] nums){
        int maxRight = nums[nums.length - 1];
        int maxDiff = 0;
        for(int i = nums.length - 2; i>=0; i--){
            if(nums[i] > maxRight){
                maxRight = nums[i];
            }
            else{
                int diff = maxRight - nums[i];
                maxDiff = Math.max(diff, maxDiff);
            }
        }
        return maxDiff;
    }
}
