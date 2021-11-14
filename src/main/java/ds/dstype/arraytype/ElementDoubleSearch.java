package ds.dstype.arraytype;

public class ElementDoubleSearch {
    public static void main(String[] args) {
        int[] arr = new int[]{10,2,5,3};
        boolean status = checkIfDoublesExist(arr);
        System.out.println(status);

        arr = new int[]{7,1,14,11};
        status = checkIfDoublesExist(arr);
        System.out.println(status);

        arr = new int[]{3,1,7,11};
        status = checkIfDoublesExist(arr);
        System.out.println(status);
    }

    static boolean checkIfDoublesExist(int[] arr){

        for(int oIndex = 0; oIndex<arr.length; oIndex++){
            if(arr[oIndex] % 2 == 0){
                // >> shift right operator i.e. arr[oIndex] / 2^1
                //for arr[oIndex] >> 2 equals to arr[oIndex] / 2^2

                //<< shift left operator i.e arr[oIndex] * 2^1 for arr[oIndex] << 1
                //for arr[oIndex] << 2 equals to arr[oIndex] * 2^2
                //int val = arr[oIndex] >> 1;
                for(int iIndex = 0; iIndex<arr.length; iIndex++){
                    if(oIndex != iIndex && (arr[oIndex] == 2 * arr[iIndex] || 2 * arr[oIndex] == arr[iIndex] )){
                        return true;
                    }
                }
            }

        }

        return false;
    }
}
