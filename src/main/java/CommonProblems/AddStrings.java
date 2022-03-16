package CommonProblems;
/*
*
Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.
You must solve the problem without using any built-in library for handling large integers (such as BigInteger). You must
also not convert the inputs to integers directly.
*
Constraints:

1 <= num1.length, num2.length <= 104
num1 and num2 consist of only digits.
num1 and num2 don't have any leading zeros except for the zero itself.
* */
/*
Algorithm
Initialize an empty res structure. Once could use array in Python and StringBuilder in Java.
Start from carry = 0.
Set a pointer at the end of each string: p1 = num1.length() - 1, p2 = num2.length() - 1.
Loop over the strings from the end to the beginning using p1 and p2. Stop when both strings are used entirely.
Set x1 to be equal to a digit from string nums1 at index p1. If p1 has reached the beginning of nums1, set x1 to 0.
Do the same for x2. Set x2 to be equal to digit from string nums2 at index p2. If p2 has reached the beginning of nums2, set x2 to 0.
Compute the current value: value = (x1 + x2 + carry) % 10, and update the carry: carry = (x1 + x2 + carry) / 10.
Append the current value to the result: res.append(value).
Now both strings are done. If the carry is still non-zero, update the result: res.append(carry).
Reverse the result, convert it to a string, and return that string.
* */
public class AddStrings {
    public static void main(String[] args) {
        //This gives ASCII values of digit 1 which is 49.
        int test = '1';
        System.out.println(test);
        System.out.println(add("1", "5"));
    }

    public static String add(String num1, String num2){
        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int digitCount = 0;
        num1 = num1.replace(",","");
        num2 = num2.replace(",","");
        while (index1>=0 || index2 >=0){
            //The ASCII values for digits (0 to 9) are (48 to 57). so to get the exact integer value of a particular
            // character in the given string we use this logic num1.charAt(p1) - '0'
            if(digitCount == 3){
                result.append(",");
                digitCount = 0;
            }
            int val1 = index1>=0?num1.charAt(index1) - '0' : 0;
            int val2 = index2>=0?num2.charAt(index2) - '0' : 0;
            int val = (val1 + val2 + carry) % 10;
            carry = (val1 + val2 + carry) / 10;
            result.append(val);
            digitCount++;
            index1--;
            index2--;
        }
        if(carry != 0){
            result.append(carry);
        }
        return result.reverse().toString();
    }
    /*
    *
    Complexity Analysis:
        Time Complexity: O(max(N1,N2)) where N1  and N2 are length of nums1 and nums2. Here we do max(N1,N2) iterations at most.
        Space Complexity: O(max(N1,N2)) because the length of the new string is at most max(N1, N2)+1
    *
    * */
}
