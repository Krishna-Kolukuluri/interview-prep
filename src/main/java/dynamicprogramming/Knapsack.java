package dynamicprogramming;
/*
Given two integer arrays to represent weights and profits of ‘N’ items, we need to find a subset of these items which
will give us maximum profit such that their cumulative weight is not more than a given number ‘C’. Write a function that
returns the maximum profit. Each item can only be selected once, which means either we put an item in the knapsack or skip it.
* */
public class Knapsack {
    public static void main(String[] args) {
        int[] profits = new int[]{1,6,10,16};
        int[] weights = new int[]{1,2,3,5};
        int capacity = 7;
        WeightProfitCapacity maxProfit = new WeightProfitCapacity(7, profits.length);
        System.out.println(maxProfit.calculateMaximProfit(weights, profits, capacity, 0));
    }

}
class WeightProfitCapacity{
    int[][] memoize;
    public WeightProfitCapacity(int capacity, int numOfProfits){
        memoize = new int[numOfProfits][capacity  + 1];
    }
    public int calculateMaximProfit(int[] weights, int[] profits, int capacity, int currentIndex){
        if(capacity < 0 || currentIndex >= profits.length){
            return 0;
        }
        if(memoize[currentIndex][capacity] != 0){
            return memoize[currentIndex][capacity];
        }

        int profitWithCurrentIndex = 0;
        if(weights[currentIndex] <= capacity){
            profitWithCurrentIndex = profits[currentIndex] + calculateMaximProfit(weights, profits,
                    capacity - weights[currentIndex], currentIndex  +1);
        }

        int profitWithoutCurrentIndex = calculateMaximProfit(weights, profits, capacity, currentIndex + 1);

        memoize[currentIndex][capacity] = Math.max(profitWithCurrentIndex, profitWithoutCurrentIndex);

        return memoize[currentIndex][capacity];
    }
}
/*
Time and Space Complexity: O(N * C)
N is total number of weights/Profits and C is capacity.
As algorithm is memoizing sub-problems, each problem will be solved exactly once, there will be N * C combination of
Sub-problems to solve.
* */