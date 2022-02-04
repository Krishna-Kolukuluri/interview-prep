package CommonProblems;

/*
* Random Pick with Weight
* https://leetcode.com/problems/random-pick-with-weight/
* https://leetcode.com/problems/random-pick-with-weight/solution/
* You are given a 0-indexed array of positive integers w where w[i] describes the weight of the ith index.
You need to implement the function pickIndex(), which randomly picks an index in the range [0, w.length - 1] (inclusive)
and returns it. The probability of picking an index i is w[i] / sum(w).
For example, if w = [1, 3], the probability of picking index 0 is 1 / (1 + 3) = 0.25 (i.e., 25%), and the probability of
picking index 1 is 3 / (1 + 3) = 0.75 (i.e., 75%).
* */
public class RandomPickWithWeight {
}
class RandomWithWeight{
    private int[] prefixSums;
    private int totalSum;
    public RandomWithWeight(int[] w){
        this.prefixSums = new int[w.length];

        int prefixSum = 0;
        for (int i = 0; i < w.length; ++i) {
            prefixSum += w[i];
            this.prefixSums[i] = prefixSum;
        }
        this.totalSum = prefixSum;
    }
    //Linear search
    /*
    * Complexity Analysis:
        Let NN be the length of the input list.
        Time Complexity:
        For the constructor function, the time complexity would be O(N), which is due to the construction of the prefix sums.
        For the pickIndex() function, its time complexity would be O(N) as well, since we did a linear search on the prefix sums.
        Space Complexity:
        For the constructor function, the space complexity would be O(N), which is again due to the construction of the prefix sums.
        For the pickIndex() function, its space complexity would be O(1), since it uses constant memory.
        Note, here we consider the prefix sums that it operates on, as the input of the function.
    * */
    public int pickIndex() {
        double target = this.totalSum * Math.random();
        int i = 0;
        // run a linear search to find the target zone
        for (; i < this.prefixSums.length; ++i) {
            if (target < this.prefixSums[i])
                return i;
        }
        // to have a return statement, though this should never happen.
        return i - 1;
    }

    //Binary Search
    /*
    *Complexity Analysis:
        Let N be the length of the input list.
        Time Complexity:
        For the constructor function, the time complexity would be O(N), which is due to the construction of the prefix sums.
        For the pickIndex() function, this time its time complexity would be O(logN), since we did a binary search on the prefix sums.
        Space Complexity:
        For the constructor function, the space complexity remains O(N), which is again due to the construction of the prefix sums.
        For the pickIndex() function, its space complexity would be O(1), since it uses constant memory. Note, here we
        consider the prefix sums that it operates on, as the input of the function.
            * */
    public int pickIndex(int dummy) {
        double target = this.totalSum * Math.random();

        // run a binary search to find the target zone
        int low = 0, high = this.prefixSums.length;
        while (low < high) {
            // better to avoid the overflow
            int mid = low + (high - low) / 2;
            if (target > this.prefixSums[mid])
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }
}