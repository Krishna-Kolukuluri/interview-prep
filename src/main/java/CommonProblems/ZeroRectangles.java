package CommonProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZeroRectangles {
    public static void main(String[] args) {

        int[][] matrix = new int[][]{{1,1,1,1,1},
                                     {1,0,0,1,1},
                                     {1,0,0,1,1},
                                     {1,1,1,1,1}};

        System.out.println(getCoordinates(matrix) + "\n");

        matrix = new int[][]{{1,1,1,1,1},
                             {1,0,0,1,1},
                             {1,0,1,1,1},
                             {1,1,1,1,1}};

        System.out.println(getCoordinates(matrix) + "\n");

        matrix = new int[][]{{1,1,1,1,1},
                             {1,0,0,0,1},
                             {1,0,1,0,1},
                             {1,1,1,1,1}};

        System.out.println(getCoordinates(matrix) + "\n");

        matrix = new int[][] {{1,1,1,1,1},
                {1,0,0,1,1},
                {1,0,0,1,1},
                {1,1,1,1,0}};

        System.out.println(getCoordinates(matrix) + "\n");
    }

    public static List<List<List<Integer>>> getCoordinates(int[][] matrix){

        List<List<List<Integer>>> res = new ArrayList<>();

        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {

                if (matrix[i][j] == 0) {

                    int beginRow = i;
                    int beginColumn = j;
                    int endColumn = findEndColumn(i, j, matrix);
                    int endRow = findEndRow(i, beginColumn, endColumn, matrix);

                    markAllOne(matrix, beginRow, beginColumn, endRow, endColumn);

                    List<Integer> startPair = new ArrayList<>(Arrays.asList(beginRow, beginColumn));
                    List<Integer> endPair =  new ArrayList<>(Arrays.asList(endRow, endColumn));

                    List<List<Integer>> pairs = new ArrayList<>(Arrays.asList(startPair, endPair));
                    res.add(pairs);
                }
            }
        }


        return res;
    }

    public static int findEndColumn(int i, int j, int[][] matrix) {

        while (j < matrix[0].length) {
            if (matrix[i][j] == 0) {
                j++;
            } else {
                break;
            }
        }

        return j-1;
    }

    public static int findEndRow(int i, int beginColumn, int endColumn, int[][] matrix) {

        boolean allZero = true;

        while (i < matrix.length) {

            for (int j=endColumn; j>=beginColumn; j--) {
                if (matrix[i][j] != 0) {
                    allZero = false;
                    break;
                }
            }

            if (allZero) {
                i++;
            } else {
                break;
            }
        }

        return i-1;
    }

    public static void markAllOne(int[][] matrix, int beginRow, int beginColumn, int endRow, int endColumn){

        for (int i= beginRow; i<=endRow; i++) {
            for (int j= beginColumn; j<=endColumn; j++) {
                matrix[i][j] = 1;
            }
        }
    }
}
