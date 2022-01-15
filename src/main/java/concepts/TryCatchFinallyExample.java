package concepts;

public class TryCatchFinallyExample {
    public static void main(String[] args) {
        int result = getCountSum(100);
        System.out.println(result);
    }
    public static int getCountSum(int initialVal){
        int tempSum = 0;
        try{
            tempSum += initialVal;
            tempSum /= 2;
            initialVal = tempSum;
            //System.out.println("In try block");
            //This return will not have any effect as its getting overwritten by finally block return statement.
            return initialVal;
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            //In case of exceptions This return will not have any effect as its getting overwritten by finally block return statement.
            return initialVal;
        }
        finally {
            System.out.println("In finally block");
            return tempSum;
        }
    }
}
