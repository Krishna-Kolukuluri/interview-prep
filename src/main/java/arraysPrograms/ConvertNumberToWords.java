package arraysPrograms;

public class ConvertNumberToWords {

    public static void main(String args[]){
        System.out.println(numToWordConversion(1230000000));
        System.out.println(numToWordConversion(-8754));
    }

    public static String numToWordConversion(int n){
        String result = "";

        String unitsPosition[] = { "zero", "one", "two", "three", "four", "five", "six", 
                "seven", "eight", "nine", "ten", "eleven", "twelve",
                "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", 
                "eighteen", "nineteen" };
        String tensPosition[] = { "zero", "ten", "twenty", "thirty", "forty", "fifty",
                "sixty", "seventy", "eighty", "ninety" };

        if(n == 0){
            return "Zero";
        }
        if(n<0){
            String negativeNum = ""+n;
            negativeNum = negativeNum.substring(1);
            return "minus "+numToWordConversion(Integer.parseInt(negativeNum));
        }
        if ((n / 1000000) > 0) {
            result += numToWordConversion(n / 1000000) + " million ";
            n %= 1000000;
        }
        if ((n / 1000) > 0) {
            result += numToWordConversion(n / 1000) + " thousand ";
            n %= 1000;
        }
        if ((n / 100) > 0) {
            result += numToWordConversion(n / 100) + " hundred ";
            n %= 100;
        }
        if(n>0){
            if(n<20){
                result += unitsPosition[n];
            }else{
                result+=tensPosition[n/10];
                if((n%10)>0){
                    result+=" " +unitsPosition[n%10];
                }
            }
        }
        return result;
    }

}
