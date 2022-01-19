package CommonProblems;
/*
* Question - Given an array of integers return true if there is at-least a superNumber and a prime number in the array
* where superNumber is the one whose sum of the digits is prime number
Input = [11,11] Output = true
Input = [13,14] Output = true
Input = [14, 14] Output = false
* */
public class ArrayContainsSuperNumberAndPrimeNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{12,13};
        System.out.println(haveSuperAndPrimeNumber(nums));
    }
    //O(N * (sqrt(M) + sqrt(K)))
    public static boolean haveSuperAndPrimeNumber(int[] nums){
        boolean primeFlag = false;
        boolean superFlag = false;
        for(int num : nums){
            if(!superFlag && superNumber(num)){
                superFlag = true;
            }
            if(!primeFlag && primeNumber(num)){
                primeFlag = true;
            }
            if(primeFlag && superFlag){
                return true;
            }
        }
        return false;
    }
    //O(M)  M digits + O(sqrt(K)) K is numeric value of num digits sum.
    public static boolean superNumber(int num){
        int totalSum = 0;
        while (num > 0){
            int digit = num % 10;
            num = num/10;
            totalSum += digit;
        }
        System.out.println(totalSum);
        return primeNumber(totalSum);
    }

    //O(sqrt(N)) time complexity for checking each number
    public static boolean primeNumber(int num){
        if(num <= 1){
            return false;
        }
        for(int idx = 2; idx <= Math.sqrt(num); idx++){
            if(num%idx == 0){
                System.out.println(num + " is not prime number");
                return false;
            }
        }
        System.out.println(num + " is prime number");
        return true;
    }
}
