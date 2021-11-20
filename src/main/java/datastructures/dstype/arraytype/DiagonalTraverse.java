package datastructures.dstype.arraytype;

import java.util.ArrayList;
import java.util.Collections;

public class DiagonalTraverse {
    public static void main(String[] args) {
        findDiagonalOrder(new int[][]{{2},{4}});
    }
    public static int[] findDiagonalOrder(int[][] matrix) {

        // Check for empty matrices
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }

        // Variables to track the size of the matrix
        int N = matrix.length;
        int M = matrix[0].length;

        // The two arrays as explained in the algorithm
        int[] result = new int[N * M];
        int k = 0;
        ArrayList<Integer> intermediate = new ArrayList<Integer>();

        // We have to go over all the elements in the first
        // row and the last column to cover all possible diagonals
        for (int d = 0; d < N + M - 1; d++) {

            // Clear the intermediate array every time we start
            // to process another diagonal
            intermediate.clear();

            // We need to figure out the "head" of this diagonal
            // The elements in the first row and the last column
            // are the respective heads.
            int r = d < M ? 0 : d - M + 1;
            int c = d < M ? d : M - 1;

            // Iterate until one of the indices goes out of scope
            // Take note of the index math to go down the diagonal
            while (r < N && c > -1) {
                int tempVal = matrix[r][c];
                intermediate.add(tempVal);
                r += 1;
                c -= 1;
            }

            // Reverse even numbered diagonals. The
            // article says we have to reverse odd
            // numbered articles but here, the numbering
            // is starting from 0 :P
            if (d % 2 == 0) {
                Collections.reverse(intermediate);
            }

            for (int i = 0; i < intermediate.size(); i++) {
                result[k++] = intermediate.get(i);
            }
        }
        return result;
    }
}
/*
Complexity Analysis

Time Complexity: O(N⋅M) considering the array has N rows and M columns. An important thing to remember is
that for all the odd numbered diagonals, we will be processing the elements twice since we have to reverse the elements
before adding to the result array. Additionally, to save space, we have to clear the intermediate array before we process
a new diagonal. That operation also takes O(K) where K is the size of that array. So, we will be processing all
the elements of the array at least twice. But, as far as the asymptotic complexity is concerned, it remains the same.

Space Complexity: O(min(N,M)) since the extra space is occupied by the intermediate arrays we use for
storing diagonal elements and the maximum it can occupy is the equal to the minimum of N and M. Remember,
the diagonal can only extend till one of its indices goes out of scope.

* */
