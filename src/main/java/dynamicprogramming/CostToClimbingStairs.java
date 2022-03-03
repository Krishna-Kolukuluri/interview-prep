package dynamicprogramming;

import java.util.HashMap;

/*
* https://leetcode.com/problems/min-cost-climbing-stairs/
* You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost,
* you can either climb one or two steps.
You can either start from the step with index 0, or the step with index 1.
Return the minimum cost to reach the top of the floor.
*
Example 1:
Input: cost = [10,15,20]
Output: 15
Explanation: You will start at index 1.
- Pay 15 and climb two steps to reach the top.
The total cost is 15.
*
Example 2:
Input: cost = [1,100,1,1,1,100,1,1,100,1]
Output: 6
Explanation: You will start at index 0.
- Pay 1 and climb two steps to reach index 2.
- Pay 1 and climb two steps to reach index 4.
- Pay 1 and climb two steps to reach index 6.
- Pay 1 and climb one step to reach index 7.
- Pay 1 and climb two steps to reach index 9.
- Pay 1 and climb one step to reach the top.
The total cost is 6.
* */
public class CostToClimbingStairs {
    public static void main(String[] args) {
        MinCostToClimbStairs minCostToClimbStairs = new MinCostToClimbStairs();
        int[] costs = new int[]{10,15,20};
        int minCost  = minCostToClimbStairs.minCostClimbingStairs(costs);
        System.out.println(minCost);
        costs = new int[]{1,100,1,1,1,100,1,1,100,1};
        minCostToClimbStairs = new MinCostToClimbStairs();
        minCost  = minCostToClimbStairs.minCostClimbingStairs(costs);
        System.out.println(minCost);
    }
}
class MinCostToClimbStairs{
    HashMap<Integer, Integer> costMap;
    int[] cost;
    public MinCostToClimbStairs(){
        costMap = new HashMap<>();
    }
    public int minCostClimbingStairs(int[] cost){
        this.cost = cost;
        return minimumCost(cost.length);
    }
    public int minimumCost(int stepIndex){
        // Base case, we are allowed to start at either step 0 or step 1
        if(stepIndex <= 1){
            return 0;
        }
        // Check if we have already calculated minimumCost(i)
        if(!costMap.containsKey(stepIndex)){
            int oneStepBelowTop = cost[stepIndex-1]+ minimumCost(stepIndex-1);
            int twoStepBelowTop = cost[stepIndex-2] + minimumCost(stepIndex -2);
            int minOfOneAndTwo = Math.min(oneStepBelowTop,twoStepBelowTop);
            costMap.put(stepIndex, minOfOneAndTwo);
        }
        return costMap.get(stepIndex);
    }
}
