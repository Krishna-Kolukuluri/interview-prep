package CommonProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
*
The array-form of an integer num is an array representing its digits in left to right order.

For example, for num = 1321, the array form is [1,3,2,1].
Given num, the array-form of an integer, and an integer k, return the array-form of the integer num + k.
*
* */
public class AddToArrayForm {
    public List<Integer> addToArrayForm(int[] A, int K) {
        int N = A.length;
        int cur = K;
        List<Integer> ans = new ArrayList();
        int i = N;
        while (--i >= 0 || cur > 0) {
            if (i >= 0)
                cur += A[i];
            ans.add(cur % 10); // Return from division
            cur /= 10; // carry from division(remaining)
        }
        Collections.reverse(ans);
        return ans;
    }
}
/*
Complexity Analysis:
Time Complexity: O(max(N,logK)) where N is the length of A.
Space Complexity: O(max(N,logK)).
* */
