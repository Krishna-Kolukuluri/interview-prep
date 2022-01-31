package CommonProblems;

/*
* https://leetcode.com/problems/search-a-2d-matrix/
* Write an efficient algorithm that searches for a value target in an m x n integer matrix.
* This matrix has the following properties:
    * Integers in each row are sorted from left to right.
    * The first integer of each row is greater than the last integer of the previous row.
*
* Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
  Output: true
*
* Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
  Output: false
* */
public class Search2DMatrix {
    /*
    * Algorithm:
        The algorithm is a standard binary search :
        Initialise left and right indexes left = 0 and right = m x n - 1.
        While left <= right :
        Pick up the index in the middle of the virtual array as a pivot index : pivot_idx = (left + right) / 2.
        The index corresponds to row = pivot_idx // n and col = pivot_idx % n in the initial matrix, and hence one could
        get the pivot_element. This element splits the virtual array in two parts.
        Compare pivot_element and target to identify in which part one has to look for target.
    * */
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0)
            return false;
        int n = matrix[0].length;

        // binary search
        int left = 0, right = m * n - 1;
        int pivotIdx, pivotElement;
        while (left <= right) {
            pivotIdx = (left + right) / 2;
            pivotElement = matrix[pivotIdx / n][pivotIdx % n];
            if (target == pivotElement)
                return true;
            else {
                if (target < pivotElement)
                    right = pivotIdx - 1;
                else
                    left = pivotIdx + 1;
            }
        }
        return false;
    }
    /*
    * Complexity Analysis
        Time complexity : O(log(mn)) since it's a standard binary search.
        Space complexity : O(1).
    * */

    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;
        System.out.println(searchMatrix(matrix, target));
    }
}
