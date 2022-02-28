package patterns.binarysearch;
/*
* https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/
* Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise, return the number of
* negative numbers in grid.
* Example 1:
Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
Output: 8
Explanation: There are 8 negatives number in the matrix.
* Example 2:
Input: grid = [[3,2],[1,0]]
Output: 0
*
* */
public class CountNumbersInSortedMatrix {
    public static int countNegatives(int[][] grid){
        int rowLen = grid.length;
        int colLen = grid[0].length;
        int row = 0;
        int col = colLen - 1;
        int result = 0;
        while(row<rowLen && col>=0){
            if(grid[row][col]<0){
                result += (rowLen - row);
                col--;
            }else{
                row++;
            }
        }
        return result;
    }
    /*
    * TC:
    * */
    public static void main(String[] args) {
        int[][] grid = new int[][]{{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
        System.out.println(countNegatives(grid));
    }
}
