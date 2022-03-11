package salesforce;

public class SortArray {
    //O(nlogn)
    public static int[] sortArray(int[] nums) {
        qsort(nums,0,nums.length-1);
        return nums;
    }
    public static void qsort(int[] nums,int leftbound,int rightbound){
        if(leftbound<rightbound){
            int pivot = nums[leftbound];
            int leftindex=leftbound;
            int rightindex=rightbound;
            int temp=0;
            while(leftindex<rightindex){
                while(nums[leftindex]<pivot && leftindex<rightbound){
                    leftindex++;
                }
                while(nums[rightindex]>pivot){
                    rightindex--;
                }
                if(leftindex<rightindex){
                    temp=nums[leftindex];
                    nums[leftindex]=nums[rightindex];
                    nums[rightindex]=temp;
                }
            }
            temp=pivot;
            pivot=nums[rightindex];
            nums[rightindex]=temp;
            qsort(nums,leftbound,rightindex-1);
            qsort(nums,rightindex+1,rightbound);
        }
    }
    public static void main(String args[]){
        int[] nums = {1,3,8,4,6,2};
        int[] result = sortArray(nums);
        for(int i:result){
            System.out.println(i);
        }
    }
}
