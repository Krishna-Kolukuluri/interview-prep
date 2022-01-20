package CommonProblems;
/*
*
You are given an integer array arr.

We split arr into some number of chunks (i.e., partitions), and individually sort each chunk. After concatenating them,
the result should equal the sorted array.

Return the largest number of chunks we can make to sort the array.
*
* */
//O(N) and O(N) space and time complexity
public class MaxChunksToSortArray {
    public static void main(String[] args) {
        int[] arr= {5,4,3,2,1};
        System.out.println(maxChunksToSorted(arr));
        arr= new int[] {2,1,3,4,4};
        System.out.println(maxChunksToSorted(arr));
    }
    public static int maxChunksToSorted(int[] arr) {
        int[] lmax = new int[arr.length]; // lmax : left max
        int[] rmin = new int[arr.length + 1]; // rmin : right minimum

        lmax[0] = arr[0];

        for(int i = 1 ; i < arr.length ; i++){
            lmax[i] = Math.max(lmax[i - 1] , arr[i]);
        }

        rmin[arr.length] = Integer.MAX_VALUE;

        for(int i = arr.length - 1 ; i >= 0 ; i--){
            rmin[i] = Math.min(rmin[i + 1] , arr[i]);
        }

        int chunks = 0;

        for(int i = 0 ; i < arr.length ; i++){
            if(lmax[i] <= rmin[i + 1]){
                chunks++;
            }
        }
        return chunks;
    }
}
