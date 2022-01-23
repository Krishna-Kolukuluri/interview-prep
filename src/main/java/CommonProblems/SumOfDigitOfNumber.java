package CommonProblems;
/*
* Sum of digits of given integer
* */
public class SumOfDigitOfNumber {
    public static void main(String[] args) {
        System.out.println(digitsSum(123456));
    }
    public static int digitsSum(int num){
        int sum = 0;
        while(num>0){
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }
}
