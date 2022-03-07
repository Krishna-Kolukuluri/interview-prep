package patterns.general;

import java.util.Arrays;

/*
* https://leetcode.com/problems/image-smoother/
* image smoother Or Average of Neighbors in matrix
* An image smoother is a filter of the size 3 x 3 that can be applied to each cell of an image by rounding down the
* average of the cell and the eight surrounding cells (i.e., the average of the nine cells in the blue smoother).
* If one or more of the surrounding cells of a cell is not present, we do not consider it in the average (i.e., the
* average of the four cells in the red smoother).
*
* Given an m x n integer matrix img representing the grayscale of an image, return the image after applying the smoother on each cell of it.
* */
public class ImageSmoother {
    public static int[][] imageSmoother(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0][0];
        int m = matrix.length, n = matrix[0].length;
        int[][] res = new int[m][n];
        int[][] moves = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {1, 1}, {1, -1}, {-1, 1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = matrix[i][j];
                int count = 1;
                for (int[] move : moves) {
                    int I = i + move[0];
                    int J = j + move[1];
                    if (I >= 0 && I < m && J >= 0 && J < n) {
                        count++;
                        sum += matrix[I][J];
                    }
                }
                res[i][j] = sum / count;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] img = new int[][]{{1,1,1},{1,0,1},{1,1,1}};
        int[][] result = imageSmoother(img);
        Arrays.stream(result).forEach(row-> {
            Arrays.stream(row).forEach(val -> System.out.println(val));
        });

        img =new int[][] {{100,200,100},{200,50,200},{100,200,100}};
        result = imageSmoother(img);
        Arrays.stream(result).forEach(row-> {
            Arrays.stream(row).forEach(val -> System.out.println(val));
        });
    }
}
