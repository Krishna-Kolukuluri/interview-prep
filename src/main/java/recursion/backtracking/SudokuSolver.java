package recursion.backtracking;

import java.util.HashSet;
import java.util.Set;

/*
*

Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
The '.' character indicates empty cells.
*
* Constraints:

board.length == 9
board[i].length == 9
board[i][j] is a digit or '.'.
It is guaranteed that the input board has only one solution.
*
Input: board = [['5','3','.','.','7','.','.','.','.'],
                * ['6','.','.','1','9','5','.','.','.'],
                * ['.','9','8','.','.','.','.','6','.'],
                * ['8','.','.','.','6','.','.','.','3'],
                * ['4','.','.','8','.','3','.','.','1'],
                * ['7','.','.','.','2','.','.','.','6'],
                * ['.','6','.','.','.','.','2','8','.'],
                * ['.','.','.','4','1','9','.','.','5'],
                * ['.','.','.','.','8','.','.','7','9']]
Output: [['5','3','4','6','7','8','9','1','2'],
        * ['6','7','2','1','9','5','3','4','8'],
        * ['1','9','8','3','4','2','5','6','7'],
        * ['8','5','9','7','6','1','4','2','3'],
        * ['4','2','6','8','5','3','7','9','1'],
        * ['7','1','3','9','2','4','8','5','6'],
        * ['9','6','1','5','3','7','2','8','4'],
        * ['2','8','7','4','1','9','6','3','5'],
        * ['3','4','5','2','8','6','1','7','9']]
Explanation: The input board is shown above and the only valid solution is shown below:
* */
/*
One tip to enumerate sub-boxes: let's use box_index = (row / 3) * 3 + column / 3 where '/' is an integer division.
* */

/*
*
*                            Intuition                            *
Now everything is ready to write down the backtrack function backtrack(row = 0, col = 0).

Start from the upper left cell row = 0, col = 0. Proceed till the first free cell.

Iterate over the numbers from 1 to 9 and try to put each number d in the (row, col) cell.

If number d is not yet in the current row, column and box :

Place the d in a (row, col) cell.
Write down that d is now present in the current row, column and box.
If we're on the last cell row == 8, col == 8 :
That means that we've solved the sudoku.
Else
Proceed to place further numbers.
Backtrack if the solution is not yet here : remove the last number from the (row, col) cell.
* */
public class SudokuSolver {

    static char[][] board =  new char[][]{{'5','3','.','.','7','.','.','.','.'},
                                    {'6','.','.','1','9','5','.','.','.'},
                                    {'.','9','8','.','.','.','.','6','.'},
                                    {'8','.','.','.','6','.','.','.','3'},
                                    {'4','.','.','8','.','3','.','.','1'},
                                    {'7','.','.','.','2','.','.','.','6'},
                                    {'.','6','.','.','.','.','2','8','.'},
                                    {'.','.','.','4','1','9','.','.','5'},
                                    {'.','.','.','.','8','.','.','7','9'}};

    public static void main(String[] args) {
        Sudoku sudoku = new Sudoku();
        System.out.println(sudoku.solveSudoku(board));
    }

}
class Sudoku{
    private int boxSize = 3;
    private int rowSize = boxSize * boxSize;
    private char[][] board;
    private int[][] cols = new int[rowSize][rowSize + 1];
    private int[][] rows = new int[rowSize][rowSize  + 1];
    private int[][] boxes = new int[rowSize][ rowSize + 1];
    private boolean isSudokuSolved = false;

    public boolean solveSudoku(char[][] board){
        this.board = board;
        //Initiate rows, cols and boxes
        for(int row =0; row<rowSize; row++){
            for(int col=0; col>rowSize; col++){
                char num = board[row][col];
                if(num != '.'){
                    int number  = Character.getNumericValue(num);
                    placeNumber(number, row, col);
                }
            }
        }

        //Start backtracking to find valid solution to sudoku
        backtrack(0,0);

        return isSudokuSolved;
    }
    private boolean canPlaceNumber(int number, int row, int col){
        //Check if number can be placed in (row,col) cell on board.
        //Get sub-box(3x3) number/index
        int index = (row/boxSize) * boxSize + col/boxSize;
        return rows[row][number] + cols[col][number] + boxes[index][number] == 0;
    }
    private void placeNumber(int number, int row, int col){
         //place number in (row,col) cell on board.
         //Get sub-box(3x3) number/index
         int index = (row/boxSize) * boxSize + col/boxSize;
         rows[row][number]++;
         cols[col][number]++;
         boxes[index][number]++;
         board[row][col] = (char)(number + '0');
    }
    private void removeNumber(int number, int row, int col){
         //remove number in (row,col) cell on board.
         //Get sub-box(3x3) number/index
         int index = (row/boxSize) * boxSize + col/boxSize;
         rows[row][number]--;
         cols[col][number]--;
         boxes[row][col]--;
         board[row][col] = '.';
    }
    private void placeNextNumber(int row, int col){
        /*
        Call backtrack function in recursion
        to continue to place numbers
        till the moment we have a solution
        */
         // if we're in the last cell
         // that means we have the solution
         if(row == rowSize - 1 && col == rowSize - 1){
             isSudokuSolved = true;
         }
         else {
             //if we are in the end of the row go to next row.
             if(col == rowSize - 1){
                 backtrack(row+1, col);
             }
             else{
                 //go to next column
                 backtrack(row, col+1);
             }
         }
    }
    private void backtrack(int row, int col){
        //If cell is empty
        if(board[row][col] == '.'){
            //iterate over all numbers from 1 to 9
            for(int number = 1; number<10; number++){
                if(canPlaceNumber(number, row, col)){
                    placeNumber(number, row, col);
                    placeNextNumber(row, col);
                    //If sudoku is solved, there is no need to backtrack. Since single unique solution is promised.
                    if(!isSudokuSolved){
                        removeNumber(number, row, col);
                    }
                }
            }
        }
        else{
            placeNextNumber(row, col);
        }
    }
}