package sorting.insertionsort;

import java.util.Arrays;

public class InsertionSort {
    /*
    * Time complexity:
    The algorithm is in O(n^2) which, again, makes it a poor choice for large input sizes. However, notice that the complexity
    is actually n^2 only when the input array is sorted in reverse. So, the ‘best-case’ complexity
    (when the array is already sorted in the correct order) is Omega(n) .

    Space complexity:
    Also, note that all of these algorithms are in-place, hence their space complexity is in O(1).
    *
    * */
    static void insertionSort(int[] arr, int arrSize) {
        int ele, j;
        //Traverse through 1 to size of the array
        for (int i = 1; i < arrSize; i++) {
            ele = arr[i]; // Element to be inserted
            j = i - 1;

            //shifts elements back to create space for the element to be inserted
            while (j >= 0 && arr[j] > ele) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = ele;
        }
    }
    public static void main(String args[]) {
        int arr[] = {5,4,1,0,5,95,4,-100,200,0};
        int arrSize = 10;
        insertionSort(arr, arrSize);
        System.out.println(Arrays.toString(arr));
    }
}
