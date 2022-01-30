package CommonProblems;
/*
* https://leetcode.com/problems/trapping-rain-water/
* Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
* Example 1:
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case,
6 units of rain water (blue section) are being trapped.
* Example 2:
Input: height = [4,2,0,3,2,5]
Output: 9
* */
public class TrappingRainWater {
    /*
    * Algorithm:
        Find maximum height of bar from the left end upto an index i in the array left_max.
        Find maximum height of bar from the right end upto an index i in the array right_max.
        Iterate over the \text{height}height array and update ans: Add min(left_max[i],right_max[i])−height[i] to ans
    * */
    /*
    * Complexity analysis:
        Time complexity: O(n).
        We store the maximum heights upto a point using 2 iterations of O(n) each.
        We finally update ans using the stored values in O(n).
        Space complexity: O(n) extra space.
        AdditionalO(n) space for left_max and right_max arrays
    * */
    public static int trapRainWater(int[] height){
        if(height.length == 0){
            return 0;
        }
        int units = 0;
        int size = height.length;
        int[] leftMax = new int[size];
        int[] rightMax = new int[size];
        leftMax[0] = height[0];
        for(int i = 1; i< size; i++){
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        }
        rightMax[size -1] = height[size - 1];
        for(int i = size - 2; i>=0; i--){
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        }
        for(int i= 1; i<size-1;i++){
            units += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return units;
    }

    public static void main(String[] args) {
        System.out.println(trapRainWater(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(trapRainWater(new int[]{4,2,0,3,2,5}));
    }
}
