package shopify;

import java.util.Arrays;
import java.util.TreeMap;

public class Sort2DArray {
    
    //Using a TreeMap to automatically sort the arrays.
    public static void sort2DArray_TreeMap(int[][] array){

        TreeMap<Integer, int[]> tree = new TreeMap<Integer, int[]>();
        for(int i = 0; i < array.length; i++){
            int[] row = array[i];
            tree.put(array[i][0], row);
        }

        int count = 0;

        for(Integer i : tree.keySet()){
            array[count] = tree.get(i);
            count++;    
        }
    }
    
    public static void main(String[] args) {
        int[][] grid1 = {{ 5, 12, 17, 21, 23},
                        { 1,  2,  4,  6,  8},
                        {12, 14, 18, 19, 27},
                        { 3,  7,  9, 15, 25}};
        sort2DArray(grid1);
        for(int[] row : grid1)
            System.out.println(Arrays.toString(row));
        System.out.println("------------------------------");
        int[][] grid2 = {{ 1, 2, 3, 21, 23}, 
                        {4, 5,  6,  8, 12,}, 
                        {12, 14, 18, 19, 27}, 
                        {7,  9, 15, 17, 25}};
        sort2DArray_TreeMap(grid2);
        for(int[] row : grid2)
            System.out.println(Arrays.toString(row));
    }

    private static void sort2DArray(int[][] grid) {
        for(int i=0;i<grid.length-1;i++) {
            for(int j=0;j<grid[0].length;j++) {
                int[] min;
                if(j == 0)
                    min = findMin(grid, i, 0);
                else
                    min = findMin(grid, i+1, 0);
                if(grid[i][j] > grid[min[0]][min[1]]) {
                    swap(grid, i, j, min[0], min[1]);
                    reorder(grid, min[0], min[1]);
                }
                
            }
        }
    }

    private static void reorder(int[][] grid, int i, int j) {
        int newVal = grid[i][j];
        for(int k = j+1; k<grid[0].length;k++) {
            if(grid[i][k] < newVal) {
                swap(grid, i, j, i, k);
                j=k;
            }
        }
    }

    private static void swap(int[][] grid, int i, int j, int ni, int nj) {
        int tmp = grid[i][j];
        grid[i][j] = grid[ni][nj];
        grid[ni][nj] = tmp;
    }

    private static int[] findMin(int[][] grid, int startI, int startJ) {
        int min = Integer.MAX_VALUE;
        int[] res = new int[2];
        res[1] = startJ;
        for(int i = startI;i<grid.length;i++) {
            if(min > grid[i][startJ]) {
                min = grid[i][startJ];
                res[0] = i;
            }
        }
        return res;
    }   
}
