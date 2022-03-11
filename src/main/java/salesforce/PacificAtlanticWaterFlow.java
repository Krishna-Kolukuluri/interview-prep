package salesforce;

import java.util.*;
/**
 * We know that water will flow from high -> low which is given in question
neighboring cell's height is less than or equal to the current cell's height

We know that water will definitely flow from boundary heights to sea because water should come from high places and flow towards sea(low)

In order to solve this problem we move from boundaries to inwards in this case
the current cell's height must be less than or equal to neighboring cell's height opposite to given cell means we are moving from low -> high

we will maintian two 2-D arrays one for pacific and another for atlantic

for pacific we will move from left(0, i) and top(i, 0)
for atlantic we will move from right(N-1, i) and bottom(M-1, i)

Example
[[2,1,3], [3, 2, 1], [1, 4, 2]]
#######
#2 1 3 *

#3 2 1 *

#1 4 2 *
********
For pacific ocean The values stored for flow is
#2 1 3 *
#3 2 1 *
#1 4 2 *
********
pacific left side visit
For 2 (0,1) water will come from 3(1,0)
For 3 (1,0) already visited and also its water definitely go to sea
For (1,0) water will come from 4(2,1)
For 4(2,1) water dont come from neighbours
pacific top side visit
2(0,1) already visited in left side view
For 1(0,1) water come from 2(1,1), 3(0,2)
For 3(0,2) already visited but its water will got to sea

Atlantic
#######
#2 1 3 *
#3 2 1 *
#1 4 2 *
********
For Atlantic visit left side
For 3(0,2) water dont come from other but its water will go to sea
For 1(1,2) water will come from 2(0,1), 2(2,2)
For 2(2,2) already visited

For Atlantic bottom side visit
For 1 (2,0) water will come from 3(1,0), 4(2,1)
For 3(1,0) water wont come from others
For 4(2,1) water wont come from others
For 2(2,2) already visited in right side view

Get the commonly visited heights(water flows to both pacific and atlantic)

#######
#2 1 3 *
#3 2 1 *
#1 4 2 *
********
=> [[0,2],[1,0],[1,1],[2,0],[2,1]]
 */

public class PacificAtlanticWaterFlow {

    private static final int[][] DIRECTIONS = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    private int numRows;
    private int numCols;
    private int[][] landHeights;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        int M = heights.length, N = heights[0].length;
        boolean[][] pacific = new boolean[M][N];
        boolean[][] atlantic = new boolean[M][N];
        for(int i=0; i< M ; i++){   //all boundary heights must flow to water
            dfsHelper(heights, pacific, i, 0, Integer.MIN_VALUE);  //start marking from left side for pacific ocean;
            dfsHelper(heights, atlantic, i, N-1, Integer.MIN_VALUE); //start marking from right side for atlantic ocean
        }

        for(int i=0; i< N ; i++){ //all boundary heights must flow to water
            dfsHelper(heights, pacific, 0, i, Integer.MIN_VALUE);  //start marking from left side for pacific ocean;
            dfsHelper(heights, atlantic, M-1, i, Integer.MIN_VALUE); //start marking from right side for atlantic ocean
        }

        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    result.add(Arrays.asList(i,j));
                }
            }
        }
        return result;
    }

    int dirs[][] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}}; //bottom, right, top, left

    private void dfsHelper(int[][] matrix, boolean[][] visited, int sr, int sc, int height){
        if(sr<0 || sr>=matrix.length || sc<0 || sc>=matrix[0].length || matrix[sr][sc] < height || visited[sr][sc]) return;
        visited[sr][sc] = true;
        for(int[] dir: dirs) {
            dfsHelper(matrix, visited, sr+dir[0], sc+dir[1], matrix[sr][sc]);
        }
    }
}