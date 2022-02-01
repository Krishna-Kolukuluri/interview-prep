package arraysPrograms;

import java.util.Arrays;

/*
* https://leetcode.com/problems/maximum-number-of-points-with-cost/
* https://leetcode.com/problems/maximum-number-of-points-with-cost/discuss/1721549/Java-explained-two-approaches
*
* You are given an m x n integer matrix points (0-indexed). Starting with 0 points, you want to maximize the number of
* points you can get from the matrix.
* To gain points, you must pick one cell in each row. Picking the cell at coordinates (r, c) will add points[r][c] to your score.
* However, you will lose points if you pick a cell too far from the cell that you picked in the previous row. For every
* two adjacent rows r and r + 1 (where 0 <= r < m - 1), picking cells at coordinates (r, c1) and (r + 1, c2) will subtract abs(c1 - c2) from your score.

Return the maximum number of points you can achieve.
*
abs(x) is defined as:
x for x >= 0.
-x for x < 0.
*
* Input: points = [[1,2,3],[1,5,1],[3,1,1]]
Output: 9
Explanation:
The blue cells denote the optimal cells to pick, which have coordinates (0, 2), (1, 1), and (2, 0).
You add 3 + 5 + 3 = 11 to your score.
However, you must subtract abs(2 - 1) + abs(1 - 0) = 2 from your score.
Your final score is 11 - 2 = 9.
*
* Input: points = [[1,5],[2,3],[4,2]]
Output: 11
Explanation:
The blue cells denote the optimal cells to pick, which have coordinates (0, 1), (1, 1), and (2, 0).
You add 5 + 3 + 4 = 12 to your score.
However, you must subtract abs(1 - 1) + abs(1 - 0) = 1 from your score.
Your final score is 12 - 1 = 11.
* */
public class MaximumNumberOfPointsWithCost {
    /*
    * Dynamic Programming Top-Down
    * Simple intuitive approach of top-down dp would give you TLE even if you convert this to bottom-up as the time
    * complexity ids going to be O(nmm) as we are checking m columns for each element.
    * Time Complexity : O(N * M * M)
    * Space Complexity: O(N*M)
    * Time limit exceeding for larger test cases
    * */
    public static long maxPoints(int[][] points) {
        int n=points.length,m=points[0].length;
        long[][] dp=new long[n+1][m+1];
        for(long[] arr:dp)
            Arrays.fill(arr,Long.MIN_VALUE);
        long ans=Long.MIN_VALUE;
        for(int i=0;i<m;i++)
            ans=Math.max(ans,solve(0,i,n,m,points,dp));
        return ans;
    }
    private static long solve(int row,int col,int n,int m,int[][] points,long[][] dp){
        if(row==n)
            return 0;
        if(dp[row][col]!=Long.MIN_VALUE)
            return dp[row][col];
        long ans=Long.MIN_VALUE;
        for(int i=0;i<m;i++)
            ans=Math.max(ans,points[row][col]-Math.abs(col-i)+solve(row+1,i,n,m,points,dp));
        return dp[row][col]=ans;
    }



    /*
    * Dynamic Programming Bottom-up
    * we have to limit the no. of comparisons for each element. so first we will copy the elements of the first row in
    * array(i.e. prev[] here) .Now starting from the first row, we will first traverse from the left to find the left max
    * and then traverse from the right to get the right max and store the max(left,right) in the prev array.
    left traversal:
    keep a variable left=0 now for the element at j th index compare the left-1( minus 1 because we are taking an
    * element from the prev column) and points[i][j]. max(left-1,prev[j])+points[i][j] will be stored in the temp array.
    right traversal:
    do the same for the right traversal and update the prev array with the maximum element got from each traversal.
    At last give the maximum of the prev array.
    Do dry run the code for better understanding.
    * */
    public static long maxPointsBU(int[][] points) {
        int n=points.length,m=points[0].length;
        long ans=Long.MIN_VALUE;
        long[] prev=new long[m];
        for(int i=0;i<m;i++)
            prev[i]=points[0][i];
        for(int i=1;i<n;i++){
            long[] dp=new long[m];
            long left=0;
            for(int j=0;j<m;j++){
                long temp=Math.max(prev[j],left-1);
                dp[j]=temp+points[i][j];
                left=temp;
            }
            long right=0;
            for(int j=m-1;j>=0;j--){
                long temp=Math.max(prev[j],right-1);
                dp[j]=Math.max(dp[j],temp+points[i][j]);
                right=temp;
                prev[j]=dp[j];
            }

        }
        ans=Arrays.stream(prev).max().getAsLong();
        return ans;
    }

    public static void main(String[] args) {
        int[][] points = {{1,2,3},{1,5,1},{3,1,1}};
        System.out.println(maxPoints(points));
        points = new int[][] {{1,5},{2,3},{4,2}};
        System.out.println(maxPoints(points));

        System.out.println("======");
        System.out.println(maxPointsBU(points));
    }
}
