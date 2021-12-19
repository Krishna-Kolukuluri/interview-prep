package CommonProblems;
/*
*
You are given a map of a server center, represented as a m * n integer matrix grid, where 1 means that on that cell
there is a server and 0 means that it is no server. Two servers are said to communicate if they are on the same row or
on the same column.

Return the number of servers that communicate with any other server.
*
* */
public class ServerCommunication {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,0},{0,1}};
        System.out.println(countServers(grid));
        grid = new int[][]{{1,0},{1,1}};
        System.out.println(countServers(grid));
        grid = new int[][]{{1,1,0,0},{0,0,1,0},{0,0,1,0},{0,0,0,1}};
        System.out.println(countServers(grid));
        grid = new int[][]{{1,0,0,1,0},{0,0,0,0,0},{0,0,0,1,0}};
        System.out.println(countServers(grid));
    }
    private static int countServers(int[][] grid){
        int numRows = grid.length;
        int numCols = grid[0].length;
        int[] rowCount = new int[numRows];
        int[] colCount = new int[numCols];
        int totalServers = 0;
        //Count all servers in each row and column, along with all servers in grid
        // if any rowCount or columnCount have exactly one server then they are not connected
        for(int r=0;r<numRows;r++){
            for(int c=0;c<numCols;c++){
                if(grid[r][c] == 1){
                    rowCount[r] += 1;
                    colCount[c] += 1;
                    totalServers += 1;
                }
            }
        }
        //Remove servers which are not connected i.e. only servers in row and column.
        for(int r=0;r<numRows;r++){
            for(int c=0;c<numCols;c++){
                if(grid[r][c] == 1){
                    if(rowCount[r] == 1 && colCount[c] == 1){
                        totalServers -= 1;
                    }
                }
            }
        }
        return totalServers;
    }
}
/*
*
Time Complexity : O(M . N) M is rows and N is columns
* */
