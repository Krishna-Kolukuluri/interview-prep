package CommonProblems;

/*
*
*
                                    * Amazon OA Question *
                    * Minimum adjacent swaps required to Sort Binary array *
Given a binary array, task is to sort this binary array using minimum swaps. We are allowed to swap only adjacent elements
*
Input : [0, 0, 1, 0, 1, 0, 1, 1]
Output : 3
1st swap : [0, 0, 1, 0, 0, 1, 1, 1]
2nd swap : [0, 0, 0, 1, 0, 1, 1, 1]
3rd swap : [0, 0, 0, 0, 1, 1, 1, 1]

Input : Array = [0, 1, 0, 1, 0]
Output : 3
* */
public class MinimumAdjacentSwapsBinaryArray {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 0, 1, 0, 1, 0, 1, 1};
        System.out.println(minSwaps(arr));
    }

    private static int minSwaps(int[] arr){
        int leftSwaps = 0;
        int rightSwaps = 0;
        int numOfZerosToSwaps = 0;
        for(int index = arr.length - 1; index>=0; index--){
            if(arr[index] == 0){
                numOfZerosToSwaps += 1;
            }else{
                rightSwaps += numOfZerosToSwaps;
            }
        }
        numOfZerosToSwaps = 0;
        for (int index=0;index<arr.length;index++){
            if(arr[index] == 0){
                numOfZerosToSwaps += 1;
            }else{
                leftSwaps += numOfZerosToSwaps;
            }
        }
        return Math.min(leftSwaps, rightSwaps);
    }
}
/*
Time Complexity: O(N) + O(N) --> O(N) linear time complexity
Auxiliary Space: O(1)
* */