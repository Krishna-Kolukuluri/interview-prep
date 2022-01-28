package CommonProblems;
/*
*
* https://leetcode.com/problems/container-with-most-water/
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the
ith line are (i, 0) and (i, height[i]).
Find two lines that together with the x-axis form a container, such that the container contains the most water.
Return the maximum amount of water a container can store.
Notice that you may not slant the container.
*
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water
(blue section) the container can contain is 49.
* */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] heights = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(heights));
    }

    //Two pointer approach.
    private static int maxArea(int[] heights){
        int maxArea = 0, l =0 , r = heights.length - 1;
        while(l < r){
            maxArea = Math.max(maxArea, (Math.min(heights[l], heights[r])* (r -l)));
            if(heights[l] < heights[r]){
                l++;
            }
            else{
                r--;
            }
        }
        return maxArea;
    }
    /*
    Complexity Analysis
    Time complexity : O(n). Single pass.
    Space complexity : O(1). Constant space is used.
    * */
}
