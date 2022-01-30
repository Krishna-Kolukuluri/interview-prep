package datastructures.dstype.arraytype;
/*
*https://leetcode.com/problems/valid-sudoku/
Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:
A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
*
* */
import java.util.HashSet;

//Validate SudokuSolver board is valid.
//If Row, Column and 3x3 box i.e. (r/3,c/3) box are valid then only SudokuSolver board is in valid state.
public class ValidSudoku {
    public boolean isSudokuBoardValid(char[][] board){
        // number of columns and number of rows in SudokuSolver board
        int N = 9;

        //Create Array of HashSet for each row, column and 9 blocks(3x3) blocks to keep track of numbers already seen in
        //Those rows, columns and blocks respectively.
        HashSet<Character>[] rows = new HashSet[N];
        HashSet<Character>[] cols = new HashSet[N];
        HashSet<Character>[] boxes = new HashSet[N];
        for(int idx=0;idx<9;idx++){
            rows[idx] = new HashSet<Character>();
            cols[idx] = new HashSet<Character>();
            boxes[idx] = new HashSet<Character>();
        }
        for(int row=0;row<N;row++){
            for(int col=0;col<N;col++){
                char val = board[row][col];
                //Check if row,col position is filled with number
                if(val == '.'){
                    continue;
                }
                //Check row for duplicates
                if(rows[row].contains(val)){
                    return false;
                }
                rows[row].add(val);
                //Check column for duplicates
                if(cols[col].contains(val)){
                    return false;
                }
                cols[col].add(val);
                //Check box for duplicate
                int idx = ((row/3) * 3) + (col/3);
                if(boxes[idx].contains(val)){
                    return false;
                }
                boxes[idx].add(val);
            }
        }
        return true;
    }
}
/*
Complexity Analysis

Let NN be the board length, which is 9 in this question. Note that since the value of NN is fixed, the time and space
complexity of this algorithm can be interpreted as O(1). However, to better compare each of the presented approaches,
we will treat NN as an arbitrary value in the complexity analysis below.

Time complexity: O(N^2) because we need to traverse every position in the board, and each of the four check steps is an O(1) operation.

Space complexity: O(N^2) because we need to create 3N arrays each with size N to store all previously seen numbers for all rows, columns, and boxes.
* */


