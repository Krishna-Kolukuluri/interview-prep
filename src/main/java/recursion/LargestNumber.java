package recursion;

import java.util.Arrays;

public class LargestNumber {
    public static void main(String[] args) {
        long[] numbers = new long[]{1,4,3,2,6,10,0,9};
        long result = solution(numbers);
        System.out.println(result);

    }
    public static long solution(long[] numbers){
        if(numbers.length == 0){
            return 0;
        }
        Arrays.sort(numbers);
        return numbers[numbers.length - 1];
    }
}
