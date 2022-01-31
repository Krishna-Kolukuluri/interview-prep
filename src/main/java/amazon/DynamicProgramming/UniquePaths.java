package amazon.DynamicProgramming;

import java.util.Arrays;

/*
* https://leetcode.com/problems/unique-paths/
* There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]).
* The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either
* down or right at any point in time.
* Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
* The test cases are generated so that the answer will be less than or equal to 2 * 109.
*
*Example 2:
Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down
* */
public class UniquePaths {
    /*
    * "inner" cells (m, n)? To such cell one could move either from the cell on the left (m, n - 1), or from the cell
    * above (m - 1, n). That means that the total number of paths to move into (m, n) cell is uniquePaths(m - 1, n) + uniquePaths(m, n - 1).
    * i.e. uniquePaths(m, n) = uniquePaths(m - 1, n) + uniquePaths(m, n - 1). This is classic Dynamic Programming.
    * */
    /*
    * Algorithm:
        * Initiate 2D array d[m][n] = number of paths. To start, put number of paths equal to 1 for the first row and the
            first column. For the simplicity, one could initiate the whole 2D array by ones.
        * Iterate over all "inner" cells: d[col][row] = d[col - 1][row] + d[col][row - 1].
        * Return d[m - 1][n - 1].
    * */
    public static int uniquePaths(int m, int n){
       int[][] memo = new int[m][n];
       for(int[] arr: memo){
           Arrays.fill(arr, 1);
       }
       for(int row=1; row<m; row++){
           for(int col=1;col<n;col++){
               memo[row][col] = memo[row-1][col] + memo[row][col-1];
           }
       }
       return memo[m-1][n-1];
    }
    /*
    * Complexity Analysis:
        Time complexity: O(N×M).
        Space complexity: O(N×M).
    * */

    public static void main(String[] args) {
        System.out.println(uniquePaths(3,7));
        System.out.println(uniquePaths(10,10));
    }
}
