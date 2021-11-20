package datastructures.dstype.treeType;

public class MaximumBranchBinaryTree {
    public static String solution(long[] arr) {
        // Type your solution here
        if(arr == null || arr.length==0) return "";
        long leftSum = 0;
        long rightSum = 0;
        int left = 1;
        int right = 2;

        leftSum = getTreeSum(arr,left);
        rightSum = getTreeSum(arr,right);

        if(leftSum > rightSum) return "Left";
        else if (leftSum < rightSum) return "Right";
        return "";
    }
    public static long getTreeSum(long arr[], int i){
        if(i> arr.length-1 || arr[i]==-1) return 0;
        int leftChild = 2*i+1;
        int rightChild = 2*i+2;
        long sum = 0;
        if(i <arr.length){
            sum = arr[i] +getTreeSum(arr,leftChild) +getTreeSum(arr,rightChild);
        }
        return sum;
    }
}
