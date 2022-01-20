package CommonProblems;
/*
https://leetcode.com/problems/word-search/solution/
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or
vertically neighboring. The same letter cell may not be used more than once.
*
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
* */
public class WordSearch {
    private static char[][] board;
    private static int ROWS;
    private static int COLS;

    public static void main(String[] args) {
        char[][] brd = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(canBuildWord(brd, "ABCCFSA"));
    }
    public static boolean canBuildWord(char[][] brd, String word){
        board = brd;
        ROWS = board.length;
        COLS =  board[0].length;
        for(int row=0;row<ROWS; row++){
            for(int col=0;col<COLS;col++){
                if(backtrack(row,col,word,0)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean backtrack(int row, int col, String word, int index){
        //Check bottom/base case
        if(index>= word.length()){
            return true;
        }
        //Check board boundaries
        if(row<0||row==ROWS||col<0|| col== COLS|| board[row][col] != word.charAt(index)){
            return false;
        }

        //explore current cell neighbors in Depth first search
        boolean result =  false;
        //mark cell and path prior to exploring neighbours with DFS
        board[row][col] = '#';
        int[] rowOffsets = {0,1,0,-1};
        int[] colOffsets = {1,0,-1,0};
        //4 neighbors of each cell.
        for(int d=0; d<4;d++){
            result = backtrack(row + rowOffsets[d], col+ colOffsets[d], word, index + 1);
            if(result){
                break;
            }
        }
        //Restore board/cell back to original state
        board[row][col] = word.charAt(index);
        return result;
    }
}
/*
Complexity Analysis

Time Complexity: O(N⋅3^L) where N is the number of cells in the board and L is the length of the word to be matched.

For the backtracking function, initially we could have at most 4 directions to explore, but further the choices are
reduced into 3 (since we won't go back to where we come from). As a result, the execution trace after the first step
could be visualized as a 3-ary tree, each of the branches represent a potential exploration in the corresponding direction.
Therefore, in the worst case, the total number of invocation would be the number of nodes in a full 3-nary tree, which is about 3^L

We iterate through the board for backtracking, i.e. there could be NN times invocation for the backtracking function in the worst case.
As a result, overall the time complexity of the algorithm would be O(N*3^L)

Space Complexity: O(L) where L is the length of the word to be matched.

The main consumption of the memory lies in the recursion call of the backtracking function. The maximum length of the
call stack would be the length of the word. Therefore, the space complexity of the algorithm is O(L).
* */
