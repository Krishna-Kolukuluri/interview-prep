package datastructures.dstype.arraytype;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/problems/pascals-triangle/

Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
* */
public class PascalsTriangles {
    public static void main(String[] args) {
        generate(5);
    }
    public static List<List<Integer>> generate(int numRows){
        List<List<Integer>> pasTriangles = new ArrayList<List<Integer>>();
        List<Integer> firstRow = new ArrayList<Integer>(Arrays.asList(1));
        pasTriangles.add(firstRow);
        for(int index=1;index<numRows;index++){
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = pasTriangles.get(index-1);

            //First element of any row is always 1
            row.add(1);

            // Each triangle element (other than the first and last of each row)
            // is equal to the sum of the elements above-and-to-the-left and
            // above-and-to-the-right.
            for(int j=1;j<index;j++){
                row.add(prevRow.get(j-1) + prevRow.get(j));
            }

            //Last element of any row is always 1
            row.add(1);

            pasTriangles.add(row);
        }
        return pasTriangles;
    }
    /*
    Time complexity : O(numRows^2)
    Although updating each value of triangle happens in constant time, it is performed O(numRows^2) times.

    Space complexity : O(numRows^2)
    Because we need to store each number that we update in triangle, the space requirement is the same as the time complexity.
    * */
}
