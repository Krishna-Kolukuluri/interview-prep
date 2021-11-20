package datastructures.dstype.arraytype;

public class MoveNumberToRight {
    public static void main(String[] args) {
        int[] arr = new int[]{0,1,0,3,12};
        arr = moveZeros(arr);
        for(int val:arr){
            System.out.println(val);
        }
    }

    static int[] moveZeros(int[] arr){
        int len = arr.length;
        int writePointer = 0;
        int numToMove = 0;
        for(int readPointer = 0; readPointer< len; readPointer++){
            if(arr[readPointer] != numToMove){
                arr[writePointer++] = arr[readPointer];
            }
        }
        while (writePointer < len){
            arr[writePointer++] = numToMove;
        }
        return arr;
    }
}
