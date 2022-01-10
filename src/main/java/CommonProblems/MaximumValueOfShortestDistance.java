package CommonProblems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
https://stackoverflow.com/questions/52562585/maximal-value-among-shortest-distances-in-a-matrix
https://leetcode.com/discuss/interview-question/221639/
Given a grid with w as width, h as height. A company wants to develop an office park in the grid where each cell represents a potential building lot. The goal is for the furthest of all lots to be as near as possible to an office building. Given an input n, which is the number of buildings to be placed in the lot, determine the building placement to minimize the distance the most distant empty lot is from the building. Distance is measured in horizontal and vertical directions, i.e. diagonal distance measurement is not considered.

inputs
w: an integer, the width of the grid
h: an integer, the height of the grid
n: an integer, the number of buildings to be placed

For example, w=4, h=4 and n=3. An optimal grid placement sets any lot within two unit distance of the building. The answer for this case is 2.

"0" indicates optimal building placement and in this case the maximal value of all shortest distances to the closest building for each cell is "2".

1 0 1 2
2 1 2 1
1 0 1 0
2 1 2 1
The above represents one optimal solution, there could be more like the above array rotated as an example. The above is an optimal solution because out of the 3 buildings (n=3), one building was placed at index (0,1), second was placed at (2,1) and third was placed at (2,3). The surrounding horizontal and vertical distance is shown as 1 and 2 by adding 1 each time we move horizontally and/or vertically. Note again that diagonal movement is not allowed:

1 ← 0 → 1 → 2
↓
2 ← 1 → 2 ← 1
↑. . ↑
1 ← 0 → 1 ← 0
↓ . . ↓
2 ← 1 → 2 ← 1
Other examples:

Example 1)

w=3, h=3, n=2
Two buildings (zeros) have to be optimally placed. One of the optimal plan for this case is:

01
11
10

0 → 1
↓
1 . . .1
. . . . ↑
1 ← 0
* */
public class MaximumValueOfShortestDistance {
    /*
     * Complete the 'findMinDistance' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER w
     *  2. INTEGER h
     *  3. INTEGER n
     */
    static int[] dx=new int[]{1,-1,0,0};
    static int[] dy=new int[]{0,0,-1,1};
    public static int findMinDistance(int w, int h, int n) {
        int[][] grid=new int[w][h];
        for(int i=0;i<w;i++){
            Arrays.fill(grid[i],-1);
        }
        return solve(n,w,h,0,0,grid);
    }
    static int bfs(int w,int h,int grid[][]){
        int[][] dist=new int[w][h];
        for(int i=0;i<w;i++){
            for(int j=0;j<h;j++){
                dist[i][j]=grid[i][j];
            }
        }
        int maxDist=0;
        Queue<Location> q=new LinkedList<>();
        for(int i=0;i<w;i++){
            for(int j=0;j<h;j++){
                if(dist[i][j]==0){
                    q.add(new Location(i,j));
                }
            }
        }
        while(!q.isEmpty()){
            int x=q.peek().first;
            int y=q.peek().second;
            maxDist=Math.max(maxDist,dist[x][y]);
            q.poll();
            for(int d=0;d<4;d++){
                int newX=x+dx[d];
                int newY=y+dy[d];
                if(newX>=w||newY>=h||newX<0||newY<0)
                    continue;
                if(dist[newX][newY]==-1){
                    dist[newX][newY]=dist[x][y]+1;
                    q.add(new Location(newX,newY));
                }
            }
        }
        return maxDist;
    }
    static int solve(int left,int w,int h,int row,int col,int[][]grid){
        if(left==0)
            return bfs(w,h,grid);
        int r=row,c=col;
        if(col>=h){
            r+=col/h;
            c=col%h;
        }
        int minDist=Integer.MAX_VALUE;
        for(int i=r;i<w;i++){
            for(int j=c;j<h;j++){
                grid[i][j]=0;
                int val=solve(left-1,w,h,i,j+1,grid);
                minDist=Math.min(minDist,val);
                grid[i][j]=-1;
            }
        }
        return minDist;
    }
    static class Location{
        int first,second;
        public Location(int a,int b){
            this.first=a;
            this.second=b;
        }
    }
}
