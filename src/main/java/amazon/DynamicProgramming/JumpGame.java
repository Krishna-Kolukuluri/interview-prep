package amazon.DynamicProgramming;

/*
* https://leetcode.com/problems/jump-game/
* You are given an integer array nums. You are initially positioned at the array's first index, and each element in the
* array represents your maximum jump length at that position.
* Return true if you can reach the last index, or false otherwise.
*
* Example 1:
Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
*
* Example 2:
Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
* */
public class JumpGame {
    /*
    * Dynamic Programming Bottom-up
    * https://leetcode.com/problems/jump-game/ <-- look here for explaination
    * */
    enum Index {
        GOOD, BAD, UNKNOWN
    }
    public static boolean canJumpDP(int[] nums) {
        //Initialize memo table
        Index[] memo = new Index[nums.length];
        //Assign default values to each index in memo
        for (int i = 0; i < memo.length; i++) {
            memo[i] = Index.UNKNOWN;
        }
        //Assign good to last index in the array, as it can be reached from itself
        memo[memo.length - 1] = Index.GOOD;
        //Start from right and check if any of previous indexes are good based on how far current index jump can reach
        // And mark current index based on finding if any of reachable previous indexes to the right of current index are in Good state.
        for (int i = nums.length - 2; i >= 0; i--) {
            int furthestJump = Math.min(i + nums[i], nums.length - 1);
            for (int j = i + 1; j <= furthestJump; j++) {
                if (memo[j] == Index.GOOD) {
                    memo[i] = Index.GOOD;
                    break;
                }
            }
        }
        //Return final result
        return memo[0] == Index.GOOD;
    }
    /*
    * Complexity Analysis:
        Time complexity : O(n^2). For every element in the array, say i, we are looking at the next nums[i] elements to
        its right aiming to find a GOOD index. nums[i] can be at most nn, where nn is the length of array nums.
        Space complexity : O(n). This comes from the usage of the memo table.
    * */



    /*
    * Greedy Approach --> Best possible time and space complexity
    *Iterating right-to-left, for each position we check if there is a potential jump that reaches a GOOD index
    * (currPosition + nums[currPosition] >= leftmostGoodIndex). If we can reach a GOOD index, then our position is
    * itself GOOD. Also, this new GOOD position will be the new leftmost GOOD index. Iteration continues until the
    * beginning of the array. If first position is a GOOD index then we can reach the last index from the first position.
    * */
    public static boolean canJumpGreedy(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
    /*
    * Complexity Analysis:
        Time complexity : O(n). We are doing a single pass through the nums array, hence nn steps,
        where n is the length of array nums.
        Space complexity : O(1). We are not using any extra memory.
    * */


    public static void main(String args[]){
        System.out.println(canJumpDP(new int[]{3,5,2,1,4,1,6,2}));
    }
}
