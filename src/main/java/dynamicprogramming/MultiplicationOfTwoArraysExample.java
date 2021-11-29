package dynamicprogramming;

import java.util.HashMap;
/*
*
*
You are given two integer arrays nums and multipliers of size n and m respectively, where n >= m. The arrays are 1-indexed.

You begin with a score of 0. You want to perform exactly m operations. On the ith operation (1-indexed), you will:

Choose one integer x from either the start or the end of the array nums.
Add multipliers[i] * x to your score.
Remove x from the array nums.
Return the maximum score after performing m operations.
*
* */
public class MultiplicationOfTwoArraysExample {
    public static void main(String[] args) {
        MaxScoreOfMultiOperationsTD maxScoreOfMulti = new MaxScoreOfMultiOperationsTD();
        int[] nums = new int[]{1,2,3};
        int[] multipliers = new int[]{3,2,1};
        int sumOfAllMaxScores = maxScoreOfMulti.maximumScore(nums, multipliers);
        System.out.println(sumOfAllMaxScores);
    }
}
class MaxScoreOfMultiOperationsTD{
    //HashMap implementation works but time Limit are exceeding.
    //User 2D array to store states for memoization
    private HashMap<String, Integer> scoreMap;
    private int[][] scoreArray;
    private int[] nums;
    private int[] multipliers;
    private int m;
    private int n;
    public MaxScoreOfMultiOperationsTD(){

    }
    public int maximumScore(int[] nums, int[] multipliers){
        this.scoreMap = new HashMap<>();
        this.nums = nums;
        this.multipliers = multipliers;
        m = multipliers.length;
        n = nums.length;
        this.scoreArray = new int[m][m];
        //this.scoreMap = new HashMap<>();
        return calculateScore(0, 0);
    }
    public int calculateScore(int mulOperationCount, int leftIndex){
        if(mulOperationCount == m){
            return 0;
            //Base case
        }
        int rightIndex = n - 1 -(mulOperationCount - leftIndex);
        int multiplier = this.multipliers[mulOperationCount];
        if(scoreArray[mulOperationCount][leftIndex] == 0){
            int leftScore = multiplier * this.nums[leftIndex] + calculateScore(mulOperationCount+1, leftIndex+1);
            int rightScore = multiplier * this.nums[rightIndex] + calculateScore(mulOperationCount+1, leftIndex);
            int maxScore = Math.max(leftScore, rightScore);
            //scoreMap.put(mulOperationCount +"-" + leftIndex, maxScore);
            scoreArray[mulOperationCount][leftIndex] = maxScore;
        }
        return scoreArray[mulOperationCount][leftIndex];
    }
}
/*
*
The time and space complexity of both implementations is O(m^2) where m is the length of multipliers
*
* */