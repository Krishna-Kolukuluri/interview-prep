package dynamicprogramming;

import java.util.HashMap;

/*
*
total Number of ways to climb Nth step if only allowed to climb 1 or 2 steps at a time.
*
* */
public class ClimbingStairs {
    public static void main(String[] args) {
        ClimbingSteps climbingSteps = new ClimbingSteps();
        int result = climbingSteps.getNumOfWays(5);
        System.out.println(result);
    }
}
class ClimbingSteps{
    HashMap<Integer, Integer> states;
    public ClimbingSteps(){
        states = new HashMap<>();
    }
    public int getNumOfWays(int step){
        if(step <= 2){
            return step;
        }
        if(!states.containsKey(step)){
            states.put(step, getNumOfWays(step-1) + getNumOfWays(step -2));
        }
        return states.get(step);
    }
}
/*
*
Time Complexity: O(N) with memoization. without Memoization it is O(2^N) as each recursion call makes two other calls.
Space Complexity: O(N) as it gets to store states for all N steps.
*
* */
