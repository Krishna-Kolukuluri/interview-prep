package dynamicprogramming;

import java.util.HashMap;

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
