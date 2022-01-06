package CommonProblems;
/*
Given two integers a and b, return the sum of the two integers without using the operators + and -.
Constraints:
-1000 <= a, b <= 1000
* */
public class SumOfTwoIntegers {
    public static void main(String[] args) {
        System.out.println(getSum(10, 20));
    }
    public static int getSum(int a, int b){
        while (b != 0){
            int answer = a ^ b; //XOR bitwise operator
            int carry = (a & b) << 1; //bitwise left-shift operator.
            a = answer;
            b = carry;
        }
        return a;
    }
    /*
    *
    Complexity Analysis:
        Time complexity: O(1).
        Space complexity: O(1).
    * */
}
