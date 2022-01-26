package arraysPrograms;

public class ArraySumPairDivisible {
//    [1,2,3,4,5,10,6,7,8,9]
//            5
    public boolean canArrange(int[] arr, int k) {
        int count=0;
        int[] arr2 = new int[arr.length];
        for(int i=0;i<=(arr.length/2)-1;i++){
          for(int j=arr.length/2;j<arr.length;j++){
              if((arr[i]+arr[j])%k==0){
                  count++;
              }
          }
        }
       
        if(count == arr.length/2)
         return true;
        else
            return false;
    }
}
