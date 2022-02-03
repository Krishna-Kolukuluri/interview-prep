package arraysPrograms;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
* https://leetcode.com/problems/shuffle-an-array/
*
* Given an integer array nums, design an algorithm to randomly shuffle the array. All permutations of the array should
* be equally likely as a result of the shuffling.

Implement the Solution class:
Solution(int[] nums) Initializes the object with the integer array nums.
int[] reset() Resets the array to its original configuration and returns it.
int[] shuffle() Returns a random shuffling of the array.
* */
public class ShuffleArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        RandomShuffle randomShuffle = new RandomShuffle(arr);
        System.out.println(Arrays.toString(randomShuffle.reset()));
        System.out.println(Arrays.toString(randomShuffle.shuffle()));
        System.out.println(Arrays.toString(randomShuffle.reset()));
        System.out.println(Arrays.toString(randomShuffle.shuffle()));
        System.out.println(Arrays.toString(randomShuffle.shuffle()));
    }
}
class RandomShuffle{
    private int[] original;
    public RandomShuffle(int[] nums){
        original = nums;
    }

    public int[] reset(){
        return original;
    }

    public Integer[] shuffle(){
        List<Integer> shuffled = Arrays.asList(Arrays.stream(Arrays.copyOf(original, original.length)).boxed().toArray(Integer[]::new));
        Collections.shuffle(shuffled);
        return shuffled.toArray(new Integer[0]);
    }
}
