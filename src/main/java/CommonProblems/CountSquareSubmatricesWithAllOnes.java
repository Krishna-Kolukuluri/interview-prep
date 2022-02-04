package CommonProblems;


/*
* https://leetcode.com/problems/count-square-submatrices-with-all-ones/
* https://leetcode.com/problems/count-square-submatrices-with-all-ones/discuss/441306/JavaC%2B%2BPython-DP-solution
* Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.
* Example 1:
Input: matrix =
[
  [0,1,1,1],
  [1,1,1,1],
  [0,1,1,1]
]
Output: 15
Explanation:
There are 10 squares of side 1.
There are 4 squares of side 2.
There is  1 square of side 3.
Total number of squares = 10 + 4 + 1 = 15.
* */
public class CountSquareSubmatricesWithAllOnes {
    /*
    * Explanation:
        dp[i][j] means the size of biggest square with A[i][j] as bottom-right corner.
        dp[i][j] also means the number of squares with A[i][j] as bottom-right corner.

        If A[i][j] == 0, no possible square.
        If A[i][j] == 1,
        we compare the size of square dp[i-1][j-1], dp[i-1][j] and dp[i][j-1].
        min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1 is the maximum size of square that we can find.

        Complexity
        Time O(MN)
        Space O(1)
    *
    * */
    public static int countSquares(int[][] matrix){
        int mat[][] = new int[matrix.length + 1][matrix[0].length + 1];
        int sum = 0;
        for(int i = 1; i <= matrix.length; i++){
            for(int j = 1; j <= matrix[0].length; j++){
                if(matrix[i - 1][j - 1] != 0){
                    mat[i][j] = Math.min(Math.min(mat[i - 1][j], mat[i][j - 1]), mat[i - 1][j - 1]) + 1;
                    sum += mat[i][j];
                }
            }
        }
        return sum;
    }
    /*
    *
        Workin on the first example:
        ===========================
        Matrix =
        [0,1,1,1],
        [1,1,1,1],
        [0,1,1,1]
        ===========================
        mat after algorithm =
        [0,0,0,0,0],
        [0,0,1,1,1],
        [0,1,1,2,2],
        [0,0,1,2,3]
        ===========================
        After summing all indicies, now we get the correct answer!
    * */

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0,1,1,1}, {1,1,1,1},{0,1,1,1}};
        System.out.println(countSquares(matrix));
    }
}
