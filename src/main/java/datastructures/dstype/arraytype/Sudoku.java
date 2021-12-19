package datastructures.dstype.arraytype;

import java.util.HashSet;

//Validate SudokuSolver board is valid.
//If Row, Column and 3x3 box i.e. (r/3,c/3) box are valid then only SudokuSolver board is in valid state.
public class Sudoku {
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


