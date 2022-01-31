package CommonProblems;
/*
* https://leetcode.com/problems/search-a-2d-matrix-ii/
* Write an efficient algorithm that searches for a value target in an m x n integer matrix.
* This matrix has the following properties:
    Integers in each row are sorted in ascending from left to right.
    Integers in each column are sorted in ascending from top to bottom.
*
* Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
  Output: true
*
* Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
  Output: false
* */
public class Search2DMatrixII {
    /*
    * Search Space Reduction
    * Algorithm
        * First, we initialize a (row,col) pointer to the bottom-left of the matrix.[1] Then, until we find target and
            return true (or the pointer points to a (row, col)(row,col) that lies outside of the dimensions of the matrix),
            we do the following: if the currently-pointed-to value is larger than target we can move one row "up".
            Otherwise, if the currently-pointed-to value is smaller than target, we can move one column "right".
            It is not too tricky to see why doing this will never prune the correct answer; because the rows are sorted
            from left-to-right, we know that every value to the right of the current value is larger. Therefore, if the
            current value is already larger than target, we know that every value to its right will also be too large.
            A very similar argument can be made for the columns, so this manner of search will always find target in the
            matrix (if it is present).
    * */
    public boolean searchMatrix(int[][] matrix, int target) {
        // start our "pointer" in the bottom-left
        int row = matrix.length-1;
        int col = 0;

        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] > target) {
                row--;
            } else if (matrix[row][col] < target) {
                col++;
            } else { // found it
                return true;
            }
        }

        return false;
    }
    /*
    * Complexity Analysis:
        Time complexity : O(n+m)
        The key to the time complexity analysis is noticing that, on every iteration (during which we do not return true)
        either row or col is is decremented/incremented exactly once. Because row can only be decremented mm times and col
        can only be incremented nn times before causing the while loop to terminate, the loop cannot run for more than n+m
        iterations. Because all other work is constant, the overall time complexity is linear in the sum of the dimensions of the matrix.

        Space complexity : O(1)
        Because this approach only manipulates a few pointers, its memory footprint is constant.
    * */
}
