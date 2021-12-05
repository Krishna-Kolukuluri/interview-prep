package dynamicprogramming;
/*
*
Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
*
* */
public class MaximalSquare {
    public static void main(String[] args) {
        SquareArea squareArea = new SquareArea();
        char[][] matrix = new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        int area = squareArea.maximalSquareArea(matrix);
        System.out.println(area);
    }
}

class SquareArea{
    public SquareArea(){

    }

    public int maximalSquareArea(char[][] matrix){
        int rows = matrix.length;
        int cols = rows>0? matrix[0].length:0;
        //resultMatrix
        int[][] result = new int[rows+1][cols+1];
        int maxSideLength = 0;
        for(int row=1;row<=rows;row++){
            for(int col=1;col<= cols;col++){
                if(matrix[row-1][col-1] == '1'){
                    result[row][col] = Math.min(Math.min(result[row][col-1],result[row-1][col]), result[row-1][col-1]) +1;
                    maxSideLength = Math.max(maxSideLength, result[row][col]);
                }
            }
        }
        return maxSideLength * maxSideLength;
    }

}
/*
*
Complexity Analysis
Time complexity : O(mn). Single pass.

Space complexity : O(mn). Another matrix of same size is used for dp.
*
* */