package CommonProblems;

/*
*
Given an array of positive integers arr,  find a pattern of length m that is repeated k or more times.

A pattern is a subarray (consecutive sub-sequence) that consists of one or more values, repeated multiple times
consecutively without overlapping. A pattern is defined by its length and the number of repetitions.

Return true if there exists a pattern of length m that is repeated k or more times, otherwise return false.
*
Input: arr = [1,2,4,4,4,4], m = 1, k = 3
Output: true
Explanation: The pattern (4) of length 1 is repeated 4 consecutive times. Notice that pattern can be repeated k or more
times but not less.
* */
public class DetectPatternOfLenMRepKTimes {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,4,4,4,4};
        int m =1;
        int k =3;
        //System.out.println(containPattern(arr, m, k));

        arr = new int[]{2,2,2,2};
        m =2;
        k =3;
        System.out.println(containPattern(arr, m, k));

    }
    public static boolean containPattern(int[] arr, int m, int k){
        int lengthOfSubString = 0;
        for(int i=0; i< arr.length-m;i++){
            if(arr[i] == arr[i+m]){
                lengthOfSubString++;
            }else {
                lengthOfSubString = 0;
            }
            //Length of substring equals to pattern length times number of patters(starting with 0,1,2..).
            if(lengthOfSubString == m *(k-1)){
                return true;
            }
        }
        return false;
    }
}
