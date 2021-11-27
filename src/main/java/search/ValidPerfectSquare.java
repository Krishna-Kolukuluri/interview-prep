package search;
/*
Given a positive integer num, write a function which returns True if num is a perfect square else False.
Follow up: Do not use any built-in library function such as sqrt.
* */
public class ValidPerfectSquare {
    public static void main(String[] args) {
        boolean result = isPerfectSquare(4);
        System.out.println(4 +"-" +result);
        result = isPerfectSquare(3);
        System.out.println(3 +"-" +result);
        result = isPerfectSquare(9);
        System.out.println(9 +"-" +result);
    }
    //Binary search implementation.
    public static boolean isPerfectSquare(int num){
        if(num <2){
            return true;
        }
        int left = 2;
        int right = num>>1;

        while (left <= right){
            int pivot = left + ((right - left)>>1);
            long tempVal = (long) pivot * pivot;
            if(tempVal == num){
                return true;
            }
            if(tempVal>num){
                right = pivot - 1;
            }
            else{
                left = pivot + 1;
            }
        }
        return false;
    }

    //Newton's method
    public boolean isPerfectSquareNewtons(int num) {
        if (num < 2) return true;

        long x = num / 2;
        while (x * x > num) {
            x = (x + num / x) / 2;
        }
        return (x * x == num);
    }
}
