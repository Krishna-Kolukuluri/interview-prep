package CommonProblems;

import java.util.ArrayList;
import java.util.List;

/*
*
A nonogram is a logic puzzle, similar to a crossword, in which the player is given a blank grid and has to color it
* according to some instructions. Specifically, each cell can be either black or white, which we will represent as 'B'
* for black and 'W' for white.

+------------+
| W W W W |
| B W W W |
| B W B B |
| W W B W |
| B B W W |
+------------+

For each row and column, the instructions give the lengths of contiguous runs of black ('B') cells. For example, the
* instructions for one row of [ 2, 1 ] indicate that there must be a run of two black cells, followed later by another
* run of one black cell, and the rest of the row filled with white cells.

These are valid solutions: [ W, B, B, W, B ] and [ B, B, W, W, B ] and also [ B, B, W, B, W ]
This is not valid: [ W, B, W, B, B ] since the runs are not in the correct order.
This is not valid: [ W, B, B, B, W ] since the two runs of Bs are not separated by Ws.
*
* */
//Time Complexity: O(N * M) + O(N * M) ~= O(N * M); N is number of rows and M is number of columns.
//Space Complexity: worst case scenario all rows and all columns contains only 'B', with instructions as [1,1,1,1,1,1...1]
//like M i.e. columns and N time rows. so, O(M) + O(N) for space complexity to store additional lists for comparison.
public class NonogramExample {
    public boolean validateNonogram(char[][] grid, List<List<Integer>> rowInstructions,
                                    List<List<Integer>> colInstructions){
        boolean rowValid = false;
        boolean colValid = false;
        for(int r=0;r<grid.length;r++){
            List<Integer> rowList = new ArrayList<>();
            int count  = 0;
            for(int c =0 ; c<grid[r].length; c++){
                if(grid[r][c] == 'B'){
                    count++;
                }else if(count>0){
                    rowList.add(count);
                    count = 0;
                }
            }
            if(count > 0){
                rowList.add(count);
            }
            if(!rowInstructions.get(r).equals(rowList)){
                return false;
            }
        }
        rowValid = true;

        for(int c=0; c<grid[0].length;c++){
            List<Integer> colList = new ArrayList<>();
            int count = 0;
            for(int r=0; r<grid.length;r++){
                if(grid[r][c] == 'B'){
                    count++;
                }
                else if(count > 0){
                    colList.add(count);
                    count = 0;
                }
            }
            if(count > 0){
                colList.add(count);
            }
            if(!colInstructions.get(c).equals(colList)){
                return false;
            }
        }
        colValid = true;

        return rowValid && colValid;
    }
}
