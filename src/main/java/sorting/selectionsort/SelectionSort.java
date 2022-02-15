package sorting.selectionsort;

import java.util.Arrays;

public class SelectionSort {
    /*
    * The time complexity of this code is in O(n^2) because findMin() iterates over the entire array for each element of
    * the given array. The quadratic time complexity makes it impractical for large inputs.
    * */
    public static void selectionSort(int[] arr, int arrSize) {
        int minInd;
        //traverse through all elements of the array
        for (int i = 0; i < arrSize; i++) {
            //find the minimum element in the unsorted array
            minInd = findMin(arr, i, arrSize - 1);
            //Swap the found minimum element with the leftmost unsorted element
            int temp = arr[i];
            arr[i] = arr[minInd];
            arr[minInd] = temp;
        }
    }
    static int findMin(int[] arr, int start, int end) {
        if (end <= 0 || start < 0)
            return 0;

        int minInd = start;
        for (int i = start + 1; i <= end; i++) {
            if (arr[minInd] > arr[i])
                minInd = i;
        }
        return minInd;
    }

    public static void main(String args[]) {
        int arr[] = {5,4,1,0,5,95,4,-100,200,0};
        int arrSize = 10;
        selectionSort(arr, arrSize);
        System.out.println(Arrays.toString(arr));
    }
}
