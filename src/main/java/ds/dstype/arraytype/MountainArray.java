package ds.dstype.arraytype;

public class MountainArray {
    public static void main(String[] args) {
        int[] arr = new int[]{3,5,5};
        boolean status =  validMountainArray(arr);
        System.out.println(status);

        arr = new int[]{0,3,2,1};
        status =  validMountainArray(arr);
        System.out.println(status);

        arr = new int[]{0,2,3,4,5,2,1,0};
        status =  validMountainArray(arr);
        System.out.println(status);

        arr = new int[]{0,2,3,3,5,2,1,0};
        status =  validMountainArray(arr);
        System.out.println(status);

        arr = new int[]{9,8,7,6,5,4,3,2,1,0};
        status =  validMountainArray(arr);
        System.out.println(status);

    }

    static boolean validMountainArray(int[] arr){
        int climb = 0;
        int len = arr.length;
        if(arr.length < 3){
            return false;
        }
        while (climb < len - 1 && arr[climb] < arr[climb+1]){
            climb++;
        }
        if(climb == 0 || climb == len - 1){
            return false;
        }
        while (climb < len - 1){

            if(arr[climb] <= arr[climb+1]){
                return false;
            }
            climb++;
        }
        return true;
    }
}
