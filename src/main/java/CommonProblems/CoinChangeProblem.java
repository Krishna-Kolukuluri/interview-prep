package CommonProblems;
/*
*
You are given an integer array coins representing coins of different denominations and an integer amount representing a
total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any
combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.
*
Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
*
Input: coins = [2], amount = 3
Output: -1
* */
public class CoinChangeProblem {
    public static void main(String[] args) {
        int[] coins = new int[]{1,2,5};
        int amount = 11;
        CoinChange coinChange =  new CoinChange();

        System.out.println(coinChange.minimumCoinsEquivalentOfAmount(coins, amount));
    }
}
class CoinChange{
    /*
    Dynamic Programming - Top Down
    * */
    public int minimumCoinsEquivalentOfAmount(int[] coins, int amount){
        return coinChange(coins, amount, new int[amount]);
    }

    private int coinChange(int[] coins, int remAmount, int[] coinCount){
        if(remAmount<0){
            return -1;
        }
        if(remAmount == 0){
            return 0;
        }
        if(coinCount[remAmount-1]!=0){
            return coinCount[remAmount-1];
        }
        int min = Integer.MAX_VALUE;
        for(int coin: coins){
            int res = coinChange(coins, remAmount - coin, coinCount);
            if(res>=0 && res < min){
                min = res + 1;
            }
        }
        coinCount[remAmount - 1] = (min == Integer.MAX_VALUE)? -1: min;
        return coinCount[remAmount - 1];
    }
}
/*
*
Complexity Analysis

Time complexity : O(S*n). where S is the amount, n is denomination count. In the worst case the recursive tree of the
algorithm has height of SS and the algorithm solves only SS subproblems because it caches precalculated solutions in a
table. Each subproblem is computed with nn iterations, one by coin denomination. Therefore there is O(S*n) time complexity.

Space complexity : O(S), where SS is the amount to change We use extra space for the memoization table.
* */