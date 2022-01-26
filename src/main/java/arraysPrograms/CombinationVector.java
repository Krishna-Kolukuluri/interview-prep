package arraysPrograms;

import java.io.*;

class CombinationVector {
 
    /* arr[]  ---> Input Array
    data[] ---> Temporary array to store current combination
    start & end ---> Starting and Ending indexes in arr[]
    index  ---> Current index in data[]
    r ---> Size of a combination to be printed */
    static void combinationUtil(int arr[], int data[], int start,
                                int end, int index, int r)
    {
        // Current combination is ready to be printed, print it
        if (index == r)
        {
            for (int j=0; j<r; j++)
                System.out.print(data[j]+" ");
            System.out.println("");
            return;
        }
 
        // replace index with all possible elements. The condition
        // "end-i+1 >= r-index" makes sure that including one element
        // at index will make a combination with remaining elements
        // at remaining positions
        for (int i=start; i<=end && end-i+1 >= r-index; i++)
        {
            data[index] = arr[i];
            combinationUtil(arr, data, i+1, end, index+1, r);
        }
    }
    public static void main (String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        int r = 3;
        int n = arr.length;
        int data[]=new int[r];
        combinationUtil(arr, data, 0, n-1, 0, r);
        
        recursive_vector_printer(0, "");
    }
    
    public static String[][] vec = {{"A1", "A2"}, {"B1", "B2", "B3"}, {"C1", "C2", "C3", "C4"}, {"D1", "D2", "D3", "D4"}, {"E1", "E2"}};
    public static void recursive_vector_printer(int d, String str) {
      if (d == vec.length) {
        System.out.println(str.substring(0, str.length()-1));
        return;
      }
      for (int k = 0; k < vec[d].length; k++) {
        recursive_vector_printer(d + 1, str + vec[d][k] + ",");
      }
      return;
    }

}
 
