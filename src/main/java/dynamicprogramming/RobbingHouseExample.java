package dynamicprogramming;

import java.util.HashMap;

/*
*
* House Robber
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and
it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can
rob tonight without alerting the police.
*
* */


public class RobbingHouseExample {
    public static void main(String[] args) {
        RobbingHouse robbingHouse = new RobbingHouse();
        int[] houses = new int[]{2,7,9,3,1};
        int result = robbingHouse.rob(houses);
        System.out.println(result);
        RobbingHouseBottomUp robbingHouseBottomUp = new RobbingHouseBottomUp();
        int btResult = robbingHouseBottomUp.rob(houses);
        System.out.println(btResult);
    }
}
//Memoization or Top-Down implementation (recursion with Dynamic Programming).
class RobbingHouse{
    HashMap<Integer, Integer> totalMoneyStates;
    int[] nums;
    public RobbingHouse(){
        totalMoneyStates = new HashMap<>();
    }
    public int rob(int[] nums){
        this.nums = nums;
        return totalMoney(nums.length - 1);
    }
    public int totalMoney(int houseIndex){
        if(houseIndex == 0){
            return nums[0];
        }
        if(houseIndex == 1){
            return Math.max(nums[0], nums[1]);
        }
        if(!totalMoneyStates.containsKey(houseIndex)){
            int maxState = Math.max(totalMoney(houseIndex -1),
                                    totalMoney(houseIndex-2)+nums[houseIndex]);//Recurrence relation
            totalMoneyStates.put(houseIndex, maxState);
        }
        return totalMoneyStates.get(houseIndex);
    }
}

class RobbingHouseBottomUp{
    public RobbingHouseBottomUp(){

    }
    public int rob(int[] nums){
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        int[] moneyStates = new int[nums.length];
        moneyStates[0] = nums[0];
        moneyStates[1] = Math.max(nums[0], nums[1]);
        for(int index=2;index<nums.length;index++){
            moneyStates[index] = Math.max(moneyStates[index-1], moneyStates[index-2]+nums[index]);//Recurrence relation
        }
        return moneyStates[nums.length-1];
    }
}
