package amazon.DynamicProgramming;

import java.util.*;

public class KnightChessBoard {
    static class cell{
        int x,y,dis;
        public cell(int x,int y,int dis){
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }
    
    static boolean isInside(int x,int y,int N){
        if(x >= 1 && x <= N && y >=1 && y<=N){
            return true;
        }
        return false;
    }
    
    // KnightPos : knight position coordinates
    // targetPos : target position coordinated
    // N : square matrix size
    public static int minStepToReachTarget(int knightpos[], int targetpos[], int N) {
        int[] dx = { -2, -1, 1, 2, -2, -1, 1, 2 };
        int[] dy = { -1, -2, -2, -1, 1, 2, 2, 1 };
        boolean[][] matrix = new boolean[N+1][N+1];
        Queue<cell> queue = new LinkedList<>();
        int xKnight = knightpos[0], yKnight = knightpos[1];
        int xTarget = targetpos[0], yTarget = targetpos[1];
        queue.add(new cell(xKnight,yKnight,0));
        int steps = 0;
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                matrix[i][j] = false;
            }
        }
        cell t;
        int x,y;
        
        matrix[xKnight][yKnight] = true;
        while(!queue.isEmpty()){
            t = queue.poll();
            if(t.x == xTarget && t.y == yTarget){
                return t.dis;
            }
            for(int i=0;i<8;i++){
                x = t.x + dx[i];
                y = t.y + dy[i];
                
                if(isInside(x,y,N) && !matrix[x][y]){
                    matrix[x][y] = true;
                    queue.add(new cell(x,y,t.dis+1));
                }
            }
        }
        return Integer.MAX_VALUE;
    }
    
    public static void main(String args[]){
        System.out.println(minStepToReachTarget(new int[]{2,3},new int[]{6,7},8));
    }
}
