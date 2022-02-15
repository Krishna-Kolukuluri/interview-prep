package sorting.quicksort;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Random;


public class QuickSort {
    /*
    * Quicksort is the fastest known comparison-based sorting algorithm for arrays in the average case.
    * Caveat: Merge sort works better on linked lists, and there are other non-comparison based algorithms that outperform quicksort.
    *
    * Note that the worst-case time complexity of quicksort is in O(n^2) although the occurrence is rare.
    * The average case complexity of quicksort is in O(nlog(n)) because, for each log(n) recursive call,
    * the given array is iterated over.
    * */
    public static void quickSort(int arr[], int left, int right) {
        if (left < right) {
            // pi is where the pivot is at
            int pi = partition(arr, left, right);

            // Separately sort elements before and after partition
            quickSort(arr, left, pi - 1);
            quickSort(arr, pi + 1, right);
        }
    }
    public static int choosePivot(int left, int right) {
        Random rand = new Random();
        // Pick 3 random numbers within the range of the array
        int i1 = left + (rand.nextInt(right - left + 1));
        int i2 = left + (rand.nextInt(right - left + 1));
        int i3 = left + (rand.nextInt(right - left + 1));

        // Return their median
        return Math.max(Math.min(i1, i2), Math.min(Math.max(i1, i2), i3));
    }

    public static int partition(int arr[], int left, int right) {
        int pivotInd = choosePivot(left, right); // Index of pivot
        swap(arr, right, pivotInd); // self created function to swap two indices of an array
        int pivot = arr[right]; // Pivot
        int i = (left - 1); // All the elements less than or equal to the
        // pivot go before or at i

        for (int j = left; j <= right - 1; j++) {
            if (arr[j] <= pivot) {
                i++; // increment the index
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, right); // Putting the pivot back in place
        return (i + 1);
    }
    static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static void main(String args[]) {
        int arr[] = {5,4,1,0,5,95,4,-100,200,0};
        int arrSize = 10;
        quickSort(arr, 0, arrSize - 1);
        System.out.print("Sorted array: ");
        System.out.println(Arrays.toString(arr));
    }
}
