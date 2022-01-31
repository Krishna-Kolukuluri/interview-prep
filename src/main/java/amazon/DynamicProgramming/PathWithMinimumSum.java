package amazon.DynamicProgramming;
/* https://leetcode.com/problems/minimum-path-sum/
* Given m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
Note: You can only move either down or right at any point in time.
* Example 1:
Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
* Example 2:
Input: grid = [[1,2,3],[4,5,6]]
Output: 12
* */
public class PathWithMinimumSum {
    /*
    * Algorithm: Dynamic Programming 2D
        * We use an extra matrix dpdp of the same size as the original matrix. In this matrix, dp(i, j)dp(i,j) represents
            * the minimum sum of the path from the index (i, j)(i,j) to the bottom rightmost element. We start by initializing
            * the bottom rightmost element of dpdp as the last element of the given matrix. Then for each element starting
            * from the bottom right, we traverse backwards and fill in the matrix with the required minimum sums. Now, we
            * need to note that at every element, we can move either rightwards or downwards. Therefore, for filling in the
            * minimum sum, we use the equation: dp(i, j)=grid(i,j)+min(dp(i+1,j),dp(i,j+1))
        taking care of the boundary conditions.
    * */
    public static int minPathSum(int[][] grid){
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if(i == grid.length - 1 && j != grid[0].length - 1)
                    dp[i][j] = grid[i][j] +  dp[i][j + 1];
                else if(j == grid[0].length - 1 && i != grid.length - 1)
                    dp[i][j] = grid[i][j] + dp[i + 1][j];
                else if(j != grid[0].length - 1 && i != grid.length - 1)
                    dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
                else
                    dp[i][j] = grid[i][j];
            }
        }
        return dp[0][0];
    }
    /*
    * Complexity Analysis
        Time complexity : O(mn). We traverse the entire matrix once.
        Space complexity : O(mn). Another matrix of the same size is used.
    *
    * */

    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(grid));
    }
}
