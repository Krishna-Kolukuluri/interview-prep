package recursion.backtracking;

import java.util.HashSet;
import java.util.Set;

/*
*
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return the number of distinct solutions to the n-queens puzzle.
*
Input: n = 4
Output: 2
Explanation: There are two distinct solutions to the 4-queens puzzle as shown.
* */
public class NQueensII {
    public static void main(String[] args) {
        Queen queen = new Queen();
        System.out.println(queen.totalQueens(9));
        System.out.println(queen.totalQueens(4));
        System.out.println(queen.totalQueens(10));
    }
}
class Queen{
    private int size;
    public Queen(){
    }
    public int totalQueens(int n){
        this.size = n;
        Set<Integer> queensOnColsPos = new HashSet<>();
        Set<Integer> queensOnDiagPos = new HashSet<>();
        Set<Integer> queensOnAntiDiagPos  = new HashSet<>();
        return backtrack(0,queensOnColsPos,queensOnDiagPos,queensOnAntiDiagPos);
    }

    private int backtrack(int row, Set<Integer> queensOnColsPos, Set<Integer> queensOnDiagPos,Set<Integer> queensOnAntiDiagPos){
        //Base case when backtracking finds a valid positions for all N queens on the board with current board state
        if(row == size){
            return 1;
        }
        int  totalSolutions = 0;
        for(int col= 0; col<size;col++){
            /*
            For each square on a given diagonal, the difference between the row and column indexes (row - col) will be
            constant. Think about the diagonal that starts from (0, 0) - the ith square has coordinates (i, i),
            so the difference is always 0.
            * */
            int diag = row - col;

            /*
            *
            For each square on a given anti-diagonal, the sum of the row and column indexes (row + col) will be constant.
            If you were to start at the highest square in an anti-diagonal and move downwards, the row index increments
            by 1 (row + 1), and the column index decrements by 1 (col - 1). These cancel each other out.
            * */
            int antiDiag = row + col;
            if(queensOnColsPos.contains(col) || queensOnDiagPos.contains(diag)
                    || queensOnAntiDiagPos.contains(antiDiag)){
                continue;
            }
            //Adding current placement of queen to each set.
            queensOnColsPos.add(col);
            queensOnDiagPos.add(diag);
            queensOnAntiDiagPos.add(antiDiag);
            //Exploring all possible options from current board state to find possible candidate states
            totalSolutions += backtrack(row+1, queensOnColsPos,queensOnDiagPos, queensOnAntiDiagPos);

            //At the end of exploring all possible options, remove queen from current backtracking call so that same cell
            // can be included in other possible candidate solutions board states
            // Actual backtracking of applied state changes to board.
            queensOnColsPos.remove(col);
            queensOnDiagPos.remove(diag);
            queensOnAntiDiagPos.remove(antiDiag);
        }

        return totalSolutions;
    }
}
/*
*
Complexity Analysis

Time complexity: O(N!), where N is the number of queens (which is the same as the width and height of the board).

Unlike the brute force approach, we place a queen only on squares that aren't attacked. For the first queen, we have N
* options. For the next queen, we won't attempt to place it in the same column as the first queen, and there must be at
* least one square attacked diagonally by the first queen as well. Thus, the maximum number of squares we can consider
* for the second queen is N−2. For the third queen, we won't attempt to place it in 2 columns already occupied by
* the first 2 queens, and there must be at least two squares attacked diagonally from the first 2 queens. Thus, the
* maximum number of squares we can consider for the third queen is N - 4. This pattern continues, giving an approximate
* time complexity of N! at the end.

Space complexity: O(N), where NN is the number of queens (which is the same as the width and height of the board).

Extra memory used includes the 3 sets used to store board state, as well as the recursion call stack. All of this scales
* linearly with the number of queens.
*
* */
