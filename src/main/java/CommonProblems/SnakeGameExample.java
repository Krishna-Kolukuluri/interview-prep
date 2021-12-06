package CommonProblems;

import java.util.LinkedList;
import java.util.Queue;
/*
Snakes may now move in any of four directions - up, down, left, or right - one square at a time, but they will never
return to a square that they've already visited.  If a snake enters the board on an edge square, we want to catch it at
a different exit square on the board's edge.

The snake is familiar with the board and will take the route to the nearest reachable exit, in terms of the number of
squares it has to move through to get there. Note that there may not be a reachable exit.

Here is an example board:

    col-->        0  1  2  3  4  5  6  7  8
               +---------------------------
    row      0 |  +  +  +  +  +  +  +  0  0
     |       1 |  +  +  0  0  0  0  0  +  +
     |       2 |  0  0  0  0  0  +  +  0  +
     v       3 |  +  +  0  +  +  +  +  0  0
             4 |  +  +  0  0  0  0  0  0  +
             5 |  +  +  0  +  +  0  +  0  +

Write a function that takes a rectangular board with only +'s and 0's, along with a starting point on the edge of the
board, and returns the coordinates of the nearest exit to which it can travel.  If there is a tie, return any of the nearest exits.
*/
public class SnakeGameExample {
    public static void main(String[] args) {
        char[][] board1 = new char[][]
                {{'+', '+', '+', '+', '+', '+', '+', '0', '0'},
                {'+', '+', '0', '0', '0', '0', '0', '+', '+'},
                {'0', '0', '0', '0', '0', '+', '+', '0', '+'},
                {'+', '+', '0', '+', '+', '+', '+', '0', '0'},
                {'+', '+', '0', '0', '0', '0', '0', '0', '+'},
                {'+', '+', '0', '+', '+', '0', '+', '0', '+'},
                };
        SnakeGame snakeGame = new SnakeGame();
        int[] exit = snakeGame.findNearestExit(board1, new int[]{2,0});
        System.out.println("["+ exit[0] + "," + exit[1] + "]");

        exit = snakeGame.findNearestExit(board1, new int[]{0,7});
        System.out.println("["+ exit[0] + "," + exit[1] + "]");

        exit = snakeGame.findNearestExit(board1, new int[]{5,2});
        System.out.println("["+ exit[0] + "," + exit[1] + "]");

        char[][] board2 = new char[][]
                {{'+', '+', '0', '+', '+', '+', '+', '0', '0'},
                {'+', '+', '0', '0', '0', '0', '0', '+', '+'},
                {'0', '0', '0', '0', '0', '+', '+', '0', '+'},
                {'+', '+', '0', '+', '+', '+', '+', '0', '0'},
                {'+', '+', '0', '0', '0', '0', '0', '0', '+'},
                {'+', '+', '0', '+', '+', '0', '+', '0', '+'},
                };
        boolean sameRowExit = snakeGame.canSnakeExitFromSameRowOrColumn(board2, new int[]{0,2});
        System.out.println(sameRowExit);
        sameRowExit = snakeGame.canSnakeExitFromSameRowOrColumn(board2, new int[]{0,7});
        System.out.println(sameRowExit);
        sameRowExit = snakeGame.canSnakeExitFromSameRowOrColumn(board2, new int[]{5,7});
        System.out.println(sameRowExit);

    }
}

class SnakeGame {
    public int[] findNearestExit(char[][] board, int[] startPoint) {
        boolean[][] visitedCells = new boolean[board.length][board[0].length];
        Queue<int[]> pathQueue = new LinkedList<>();
        int[][] nextMoves = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        pathQueue.offer(startPoint);
        visitedCells[startPoint[0]][startPoint[1]] = true;

        while (!pathQueue.isEmpty()) {
            int[] cur = pathQueue.poll();
            for (int[] move : nextMoves) {
                int xIndex = move[0] + cur[0];
                int yIndex = move[1] + cur[1];
                if (xIndex >= 0 && xIndex < board.length && yIndex >= 0
                        && yIndex < board[0].length && board[xIndex][yIndex] == '0'
                        && !visitedCells[xIndex][yIndex]) {
                    if (xIndex == 0 || xIndex == board.length - 1 || yIndex == 0 || yIndex == board[0].length -1) {
                        return new int[]{xIndex, yIndex};
                    }
                    visitedCells[xIndex][yIndex] = true;
                    pathQueue.offer(new int[]{xIndex, yIndex});
                }
            }
        }
        return new int[]{-1, -1};
    }

    public boolean canSnakeExitFromSameRowOrColumn(char[][] board, int[] startPoint) {
        boolean[][] visitedCells = new boolean[board.length][board[0].length];
        Queue<int[]> pathQueue = new LinkedList<>();
        int[][] nextRowMoves = new int[][]{{1,0},{-1,0}};

        pathQueue.offer(startPoint);
        visitedCells[startPoint[0]][startPoint[1]] = true;

        while (!pathQueue.isEmpty()){
            int[] cur = pathQueue.poll();
            for(int[] move: nextRowMoves){
                int xIndex = move[0] + cur[0];
                int yIndex = move[1] + cur[1];
                if(xIndex>=0 && xIndex<board.length && yIndex >= 0 && yIndex<board[0].length
                        && board[xIndex][yIndex] == '0' && !visitedCells[xIndex][yIndex]){
                    if((xIndex ==0 || xIndex == board.length - 1) && yIndex == startPoint[1]){
                        return true;
                    }
                    visitedCells[xIndex][yIndex] = true;
                    pathQueue.offer(new int[]{xIndex, yIndex});
                }
            }
        }
        pathQueue.clear();
        visitedCells  = new boolean[board.length][board[0].length];
        int[][] nextColMoves = new int[][]{{0,1},{0,-1}};
        pathQueue.offer(startPoint);
        visitedCells[startPoint[0]][startPoint[1]] = true;

        while (!pathQueue.isEmpty()){
            int[] cur = pathQueue.poll();
            for(int[] move: nextColMoves){
                int xIndex = move[0] + cur[0];
                int yIndex = move[1] + cur[1];
                if(xIndex>=0 && xIndex<board.length && yIndex >= 0 && yIndex<board[0].length
                        && board[xIndex][yIndex] == '0' && !visitedCells[xIndex][yIndex]){
                    if((yIndex ==0 || yIndex == board[0].length - 1) && xIndex == startPoint[0]){
                        return true;
                    }
                    visitedCells[xIndex][yIndex] = true;
                    pathQueue.offer(new int[]{xIndex, yIndex});
                }
            }
        }

        return false;
    }
}
