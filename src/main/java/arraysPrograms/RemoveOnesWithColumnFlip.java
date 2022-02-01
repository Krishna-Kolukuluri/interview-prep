package arraysPrograms;
/*
* https://leetcode.com/problems/remove-all-ones-with-row-and-column-flips/
* https://leetcode.com/problems/remove-all-ones-with-row-and-column-flips/discuss/1730071/Java-oror-Explained-oror-Easy-to-understand
* You are given an m x n binary matrix grid.
In one operation, you can choose any row or column and flip each value in that row or column (i.e., changing all 0's to 1's, and all 1's to 0's).
Return true if it is possible to remove all 1's from grid using any number of operations or false otherwise.
* Example 1:
Input: grid = [[0,1,0],[1,0,1],[0,1,0]]
Output: true
Explanation: One possible way to remove all 1's from grid is to:
- Flip the middle row
- Flip the middle column
* Example 2:
Input: grid = [[1,1,0],[0,0,0],[0,0,0]]
Output: false
Explanation: It is impossible to remove all 1's from grid.
* */
public class RemoveOnesWithColumnFlip {
    /*
    * Read first ROW and if you find any value to be 1, then flip the whole COLUMN
    * Read first COLUMN and if you find any value to be 1, then flip the whole ROW
    * NOW, read all the grid[i][j] and if you find any value to be 1, that means we cannot get complete 0 grid because
    * if we flip now, then some other 0 will flip to 1 and the cycle will continue
    * TC : O(M * N)
    * SC : O(1)
    * */
    public boolean removeOnes(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        //Check if any rows contains 1, then flip that entire row
        for(int i = 0; i < m; i++) {
            if(grid[i][0] == 1) {
                flip(grid, i, m, n, true);
            }
        }
        //Check if any column contains 1, then flip that entire column
        for(int j = 0; j < n; j++) {
            if(grid[0][j] == 1) {
                flip(grid, j, m, n, false);
            }
        }
        //After flipping, if gird still contains 1's which indicates that It's not feasible to flip any rows or columns to change entire gird to 0's
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) return false;
            }
        }
        return true;
    }
    private void flip(int[][] grid, int idx, int m, int n, boolean isRow) {
        if(isRow) {
            for(int i = 0; i < n; i++) {
                grid[idx][i] = 1 - grid[idx][i];
            }
        } else {
            for(int j = 0; j < m; j++) {
                grid[j][idx] = 1 - grid[j][idx];
            }
        }
    }
}
