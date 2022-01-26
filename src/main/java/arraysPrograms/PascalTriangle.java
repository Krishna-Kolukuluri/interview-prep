package arraysPrograms;
import java.util.*;

public class PascalTriangle {
    public static List<Integer> getRow(int k) {
        Integer[] arr = new Integer[k + 1];
        Arrays.fill(arr, 0);
        arr[0] = 1;

        for (int i = 1; i <= k; i++)
            for (int j = i; j > 0; j--)
                arr[j] = arr[j] + arr[j - 1];

        return Arrays.asList(arr);
    }
    public static List<Integer> getRowRec(int rowIndex) {
        List<Integer> res = new ArrayList<>(rowIndex + 1);
        calc(rowIndex, res);
        return res;
    }
    private static void calc(int rowIndex, List<Integer> res) {
        if (rowIndex == 0) {
            res.add(0, 1);
        } else {
            calc(rowIndex - 1, res);
            res.add(1);
            for (int i = rowIndex - 1; i > 0; i--) {
                res.set(i, res.get(i) + res.get(i - 1));
            }
        }
    }
    
  //Pascal function ( O(n^2) time and O(1) extra space ) 
    public static void printPascal(int n)
    {
        for(int line = 1; line <= n; line++)
        {
            
        int C=1;// used to represent C(line, i)
        for(int i = 1; i <= line; i++)
        { 
            // The first value in a line is always 1
            System.out.print(C+" ");
            C = C * (line - i) / i; 
        }
        System.out.println();
        }
    }
    
    public static void main(String args[]){
        List<Integer> pascal = getRowRec(4);
        pascal.forEach(x->{System.out.println(x.intValue());});
        printPascal(4);
    }
}
