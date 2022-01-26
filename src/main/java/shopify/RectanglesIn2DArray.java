package shopify;

import java.util.*;

public class RectanglesIn2DArray {
    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1,1,1,1,1},
                                    {1,0,0,1,1},
                                    {1,0,0,1,1},
                                    {1,1,1,1,1}};
        System.out.println(getCoordinates(matrix));
        matrix = new int[][] {{1,1,1,1,1},
                            {1,0,0,1,1},
                            {1,0,0,1,1},
                            {1,1,1,1,0}};
        System.out.println(getCoordinates(matrix));
    }

    public static List<List<List<Integer>>> getCoordinates(int[][] matrix){
        List<List<List<Integer>>> res = new ArrayList<>();
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                List<Integer> startPair = new ArrayList<>();
                List<Integer> endPair = new ArrayList<>();
                if(matrix[i][j] == 0){
                    startPair.add(i);
                    startPair.add(j);
                    while(j < matrix[0].length && matrix[i][j] == 0){
                        j++;
                    }
                    j -= 1;
                    int depth = i + 1;
                    while(depth < matrix.length && matrix[depth][j] == 0){
                        depth++;
                    }
                    endPair.add(depth - 1);
                    endPair.add(j);
                    markAllOne(matrix, startPair, endPair);
                    List<List<Integer>> rect = new ArrayList<>();
                    rect.add(startPair);                
                    rect.add(endPair);
                    res.add(rect);
                    
                }
                
            }
        }
        return res;
    }

    public static void markAllOne(int[][] matrix, List<Integer> pair1, List<Integer> pair2){
        int colStart = pair1.get(1);
        int colEnd = pair2.get(1);
        int rowStart = pair1.get(0);
        int rowEnd = pair2.get(0);
        for(int i = colStart; i <= colEnd; i++){
            for(int j = rowStart; j <= rowEnd; j++){
                matrix[j][i] = 1;
            }
        }
    }
}
