package ds.dstype.arraytype;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayOrderCheck {
    public static void main(String[] args) {
        int[] heights = new int[]{5,1,2,3,4};
        int count = heightChecker(heights);
    }

    static int heightChecker(int[] heights){
        int count = 0;
        int len = heights.length - 1;
        //int[] expected = Arrays.copyOf(heights, heights.length);
        int[] expected = heights.clone();
        Arrays.sort(expected);
        for(int index = 0; index <= len; index++){
            if(heights[index] != expected[index]){
                count++;
            }
        }
        return count;
    }
}
