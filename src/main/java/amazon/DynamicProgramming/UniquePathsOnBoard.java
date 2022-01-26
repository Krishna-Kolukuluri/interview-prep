package amazon.DynamicProgramming;

import java.util.Arrays;

public class UniquePathsOnBoard {
    public static int uniquePaths(int m, int n) {
        int[][] d = new int[m][n];

        for(int[] arr : d) {
          Arrays.fill(arr, 1);
        }
        for(int col = 1; col < m; ++col) {
          for(int row = 1; row < n; ++row) {
            d[col][row] = d[col - 1][row] + d[col][row - 1];
          }
        }
        return d[m - 1][n - 1];
      }
    
    public static void main(String args[]){
        System.out.println(uniquePaths(3,2));
    }

}
