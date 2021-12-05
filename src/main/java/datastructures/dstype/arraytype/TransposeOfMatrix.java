package datastructures.dstype.arraytype;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/*
*
Given a 2D integer array matrix, return the transpose of matrix.

The transpose of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and column indices.
*
* */
public class TransposeOfMatrix {
    public static void main(String[] args) {
        Integer[][] matrix = new Integer[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.println("Original Source Matrix");
        for (Integer[] row: matrix){
            List<Integer> rs = Arrays.asList(row);
            System.out.println(rs);
        }
        matrix = Transpose(matrix);
        System.out.println("Transposed Source Matrix");
        for (Integer[] row: matrix){
            List<Integer> rs = Arrays.asList(row);
            System.out.println(rs);
        }
    }
    private static Integer[][] Transpose(Integer[][] matrix){
        int R = matrix.length;
        int C = R>0?matrix[0].length:0;
        Integer[][] transposed = new Integer[C][R];
        for(int oR=0;oR<R;oR++){
            for(int oC=0;oC<C;oC++){
                transposed[oC][oR] = matrix[oR][oC];
            }
        }
        return transposed;
    }
}
/*
*
Complexity Analysis
Time Complexity: O(R∗C), where R and C are the number of rows and columns in the given matrix A.

Space Complexity: O(R * C), the space used by the answer.
*
* */
