package patterns.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/*
* https://leetcode.com/problems/pascals-triangle-ii/
* Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
*
* Input: rowIndex = 3
Output: [1,3,3,1]
* */
public class PascalsTriangleII {
    public static List<Integer> generate(int numRows){
        numRows += 1;
        List<List<Integer>> triangles = new ArrayList<List<Integer>>();
        triangles.add(new ArrayList<>());
        triangles.get(0).add(1);
        for(int i=1; i<numRows;i++){
            List<Integer> curRow = new ArrayList<>();
            List<Integer> preRow = triangles.get(i-1);
            //First element in the row always 1
            curRow.add(1);
            for(int j=1;j<i;j++){
                curRow.add(preRow.get(j) + preRow.get(j-1));
            }
            //Last element in the row always 1
            curRow.add(1);
            triangles.add(curRow);
        }
        numRows -= 1;
        return triangles.get(numRows);
    }

    public static void main(String[] args) {
        System.out.println(generate(3));
    }
}
