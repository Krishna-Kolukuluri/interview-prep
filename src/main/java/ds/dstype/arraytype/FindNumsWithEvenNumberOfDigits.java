package ds.dstype.arraytype;

public class FindNumsWithEvenNumberOfDigits {

    public static void main(String[] args) {
        int[] nums = new int[]{12,345,2,6,7896};
        int evenNumOfDigitsNumberCount = numOfEvenNumberOfDigits(nums);
        System.out.println("evenNumOfDigitsNumberCount ='" + evenNumOfDigitsNumberCount +"'");
        int oddNumOfDigitsNumberCount = numOfOddNumberOfDigits(nums);
        System.out.println("oddNumOfDigitsNumberCount ='" + oddNumOfDigitsNumberCount +"'");
    }

    static int numOfEvenNumberOfDigits(int[] nums){
        int evenNumOfDigitsNumberCount = 0;

        for(int num: nums){
            int digitsCount = 1;
            int resultNum = num/10;
            while(resultNum >= 1){
                digitsCount ++;
                resultNum = resultNum/10;
            }
            if(digitsCount % 2 == 0){
                evenNumOfDigitsNumberCount++;
            }
        }

        return evenNumOfDigitsNumberCount;

    }

    static int numOfOddNumberOfDigits(int[] nums){
        int oddNumOfDigitsNumberCount = 0;

        for(int num: nums){
            int digitsCount = 1;
            int resultNum = num/10;
            while(resultNum >= 1){
                digitsCount ++;
                resultNum = resultNum/10;
            }
            if(digitsCount % 2 != 0){
                oddNumOfDigitsNumberCount++;
            }
        }

        return oddNumOfDigitsNumberCount;

    }
}
