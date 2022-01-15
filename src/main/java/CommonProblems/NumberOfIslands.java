package CommonProblems;
/*
*
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume
all four edges of the grid are all surrounded by water.

* Island by definition-> any land surrounded water on Four sides(like East, West, North and South) then its considered as Island.
*
* Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.
* */
public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(numOfIslands(grid));
        grid = new char[][] {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println(numOfIslands(grid));
    }
    public static void DFS(char[][] grid, int rIdx, int cIdx){
        int numRows = grid.length;
        int numCols = grid[0].length;
        if(rIdx<0 || cIdx < 0 || rIdx>=numRows || cIdx >= numCols || grid[rIdx][cIdx] == '0'){
            return;
        }
        grid[rIdx][cIdx] = '0';
        DFS(grid, rIdx-1, cIdx);
        DFS(grid, rIdx+1, cIdx);
        DFS(grid, rIdx, cIdx-1);
        DFS(grid, rIdx, cIdx+1);
    }
    public static int numOfIslands(char[][] grid){
        if(grid == null || grid.length == 0){
            return 0;
        }

        int numRows = grid.length;
        int numCols = grid[0].length;
        int islandsCount = 0;
        for(int r =0; r<numRows; r++){
            for(int c=0; c<numCols; c++){
                if(grid[r][c] == '1'){
                    islandsCount++;
                    DFS(grid, r, c);
                }
            }
        }
        return islandsCount;
    }
    /*
    Complexity Analysis:
    Time complexity : O(M×N) where MM is the number of rows and NN is the number of columns.
    Space complexity : worst case O(M×N) in case that the grid map is filled with lands where DFS goes by M×N deep.
    * */
}
