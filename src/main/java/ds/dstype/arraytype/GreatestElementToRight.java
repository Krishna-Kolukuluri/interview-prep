package ds.dstype.arraytype;

public class GreatestElementToRight {
    public static void main(String[] args) {
        int[] arr = new int[]{17,18,5,4,6,1};
        arr = replaceElements(arr);
        for(int val:arr){
            System.out.println(val);
        }

    }

    static int[] replaceElements(int[] arr){
        int len = arr.length;
        int maxVal =  arr[len-1];
        arr[len-1] = -1;
        for(int index = len - 2; index >= 0; index--){
            int tempVal = arr[index];
            arr[index] = maxVal;
            if(maxVal < tempVal){
                maxVal = tempVal;
            }
        }
        return arr;
    }
}
