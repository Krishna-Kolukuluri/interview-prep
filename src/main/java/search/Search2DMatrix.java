package search;

import java.util.Arrays;

public class Search2DMatrix {

    public static void main(String[] args) {
        int[][] grid1 = {{ 5, 12, 17, 21, 23},
                { 1,  2,  4,  6,  8},
                {12, 14, 18, 19, 27},
                { 3,  7,  9, 15, 25}};
        System.out.println(searchMatrix_Wrong(grid1,3));
        System.out.println(searchMatrix_Right(grid1,900));

    }

    //Binary Search
    //    Time complexity : \mathcal{O}(\log(m n))O(log(mn)) since it's a standard binary search.

    //    Space complexity : \mathcal{O}(1)O(1).
    public static boolean searchMatrix_Wrong(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0)
            return false;
        int n = matrix[0].length;

        // binary search
        int left = 0, right = m * n-1;
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
    
    public static boolean searchMatrix_Right(int[][] matrix, int target) {
        int row = matrix.length-1;  //start from last row and first column
        int col = 0;
        
        while(col<matrix[0].length && row>=0)
        {
            if(matrix[row][col]> target)
            {
                row--;
            }
            else if(matrix[row][col]<target)
            {
                col++;
            }
            else
            {
                return true;
            }
        }
        
        return false;
    }
}
