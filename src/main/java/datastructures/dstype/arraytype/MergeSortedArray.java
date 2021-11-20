package datastructures.dstype.arraytype;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {

        int[] numsOne = new int[]{1,2,3,0,0,0};
        int[] numsTwo = new int[]{4,5,6};;
        int[] numSquares = mergeSortedArraysWithMap(numsOne,numsOne.length - numsTwo.length, numsTwo, numsTwo.length);
        for(int num:numSquares){
            System.out.println("numSquares ='" + num +"'");
        }
        numsTwo = new int[]{1,2,3};
        numsOne = new int[]{4,5,6,0,0,0};;
        numSquares = mergeSortedArraysWithMap(numsOne,numsOne.length - numsTwo.length, numsTwo, numsTwo.length);
        System.out.println("========");
        for(int num:numSquares){
            System.out.println("numSquares ='" + num +"'");
        }
        numsOne = new int[]{1,2,3,0,0,0};
        numsTwo = new int[]{2,5,6};

        numSquares = mergeSortedArraysWithMap(numsOne,numsOne.length - numsTwo.length, numsTwo, numsTwo.length);
        System.out.println("========");
        for(int num:numSquares){
            System.out.println("numSquares ='" + num +"'");
        }

        numsOne = new int[]{1,2,3,0,0,0};
        numsTwo = new int[]{2,5,6};
        numSquares = mergeSortedArrayBestTime(numsOne,numsOne.length - numsTwo.length, numsTwo, numsTwo.length);
        System.out.println("========");
        for(int num:numSquares){
            System.out.println("numSquares ='" + num +"'");
        }
    }

    static int[] mergeSortedArrays(int[] numsOne, int oneLength, int[] numsTwo, int twoLength){

        int numsOneCapacity = oneLength - 1;
        int numsTwoCapacity = twoLength - 1;
        if(numsOne[numsOneCapacity - numsTwoCapacity - 1]>=numsTwo[0]){
            int twoIndex = 0;
            for(int index= numsOneCapacity - numsTwoCapacity; index<=numsOneCapacity; index++){
                numsOne[index] = numsOne[twoIndex];
                numsOne[twoIndex] = numsTwo[twoIndex];
                twoIndex++;
            }
        }
        else if(numsTwo[0]>=numsOne[numsOneCapacity - numsTwoCapacity - 1]){
            int oneIndex = 0;
            for(int index= numsOneCapacity - numsTwoCapacity; index<=numsOneCapacity; index++ ){
                numsOne[index] = numsTwo[oneIndex];
                oneIndex++;
            }
        }
        else{
            int oneIndex = numsOneCapacity;
            for(int index = 0; index <= numsTwoCapacity;index++){
                if(numsOne[oneIndex] >= numsTwo[index]){
                    numsOne[oneIndex + 1] = numsOne[oneIndex];
                    numsOne[oneIndex] = numsTwo[index];
                    oneIndex--;
                }
                else{
                    numsOne[oneIndex + 1] = numsOne[oneIndex];
                    numsOne[oneIndex] = numsTwo[index];
                    oneIndex--;
                }
            }
        }

        return numsOne;
    }

    static int[] mergeSortedArraysWithMap(int[] nums1, int m, int[] nums2, int n){
        int startIndex = m;
        for(int index = 0 ; index < n; index++){
            nums1[startIndex + index] = nums2[index];
        }
        Arrays.sort(nums1);
        return nums1;
    }

    static int[] mergeSortedArrayBestTime(int[] nums1, int m, int[] nums2, int n){
        int currentOne = m - 1;
        int currentTwo = n - 1;
        for(int index = nums1.length - 1; index >=0; index--){
            if(currentOne>=0 && (currentTwo < 0 || nums1[currentOne] >= nums2[currentTwo])){
                nums1[index] = nums1[currentOne--];
            }else{
                nums1[index] = nums2[currentTwo--];
            }
        }

        return nums1;
    }
}
