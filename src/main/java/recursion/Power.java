package recursion;

public class Power {
    public static void main(String[] args){

    }

    //Tail recursion, no further calculations are being done after power function return statement for each recursive call
    // which helps to reuse stack space for recursive function calls by directly returning value to original caller.
    private static double power(double base, int pow){
        if(pow == 0) {
            return 1;
        }
        //Handling -ve number powers i.e. dividing instead of multiplying.
        if(pow < 0){
            return 1/base * power(1/base, -(pow + 1));
        }
        return pow%2 == 0? power(base * base, pow/2): base * power(base * base, pow/2);
    }

    private static double mathPowerFunc(double base, int pow){
        return Math.pow(base, pow);
    }
}
