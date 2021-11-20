package datastructures.dstype.arraytype;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

* */
public class PascalsTriangles {
    public static void main(String[] args) {
        generate(5);
    }
    public static List<List<Integer>> generate(int numRows){
        List<List<Integer>> pasTriangles = new ArrayList<>();
        List<Integer> firstRow = new ArrayList<Integer>(Arrays.asList(1));
        pasTriangles.add(firstRow);
        for(int index=2;index<=numRows;index++){
            List<Integer> row = new ArrayList<>();
            for(int rIndex=0;rIndex<index;rIndex++){
                if(rIndex==0 || rIndex==index-1){
                    row.add(1);
                }
                else{
                    List<Integer> prevRow = pasTriangles.get(index-2);
                    row.add(prevRow.get(rIndex) + prevRow.get(rIndex -1));
                }
            }
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
