package patterns.general;
/*
* https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/
* Find Winner on a Tic Tac Toe Game
* Tic-tac-toe is played by two players A and B on a 3 x 3 grid. The rules of Tic-Tac-Toe are:
Players take turns placing characters into empty squares ' '.
The first player A always places 'X' characters, while the second player B always places 'O' characters.
'X' and 'O' characters are always placed into empty squares, never on filled ones.
The game ends when there are three of the same (non-empty) character filling any row, column, or diagonal.
The game also ends if all squares are non-empty.
No more moves can be played if the game is over.
Given a 2D integer array moves where moves[i] = [rowi, coli] indicates that the ith move will be played on grid[rowi][coli]. return the winner of the game if it exists (A or B). In case the game ends in a draw return "Draw". If there are still movements to play return "Pending".

You can assume that moves is valid (i.e., it follows the rules of Tic-Tac-Toe), the grid is initially empty, and A will play first.
* */
public class FindTicTacToeGameWinner {

    /*
    *
    * Complexity Analysis:
        Let n be the length of the board and m be the length of input moves.
        Time complexity: O(m)
        For every move, we update the value for a row, column, diagonal, and anti-diagonal. Each update takes constant time.
        We also check if any of these lines satisfies the winning condition which also takes constant time.

        Space complexity: O(n)
        We use two arrays of size n to record the value for each row and column, and two integers of constant space to
        record to value for diagonal and anti-diagonal.
    *
    * */
    public static String tictactoe(int[][] moves){
        int n = 3;
        // Use rows and cols to record the value on each row and each column.
        // diag1 and diag2 to record value on diagonal or anti-diagonal.
        int[] rows = new int[n];
        int[] cols = new int[n];
        int diag = 0;
        int antiDiag = 0;

        // Two players having value of 1 and -1, player_1 with value = 1 places first.
        int player = 1;
        for(int[] move : moves){
            int row = move[0];
            int col = move[1];
            rows[row] += player;
            cols[col] += player;

            if(row == col){
                diag += player;
            }
            if(row + col == n -1){
                antiDiag += player;
            }
            // Check if this move meets any of the winning conditions.
            if (Math.abs(rows[row]) == n || Math.abs(cols[col]) == n ||
                    Math.abs(diag) == n || Math.abs(antiDiag) == n){
                return player == 1 ? "A" : "B";
            }
            // If no one wins so far, change to the other player alternatively.
            // That is from 1 to -1, from -1 to 1.
            player *= -1;
        }

        // If all moves are completed and there is still no result, we shall check if
        // the grid is full or not. If so, the game ends with draw, otherwise pending.
        return moves.length == n * n ? "Draw" : "Pending";
    }

    public static void main(String[] args) {
        int[][] moves = new int[][]{{0,0},{2,0},{1,1},{2,1},{2,2}};
        System.out.println(tictactoe(moves));
    }
}
