package arraysPrograms;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/*
* https://leetcode.com/problems/find-original-array-from-doubled-array/ find original array from doubled array
* https://leetcode.com/problems/find-original-array-from-doubled-array/discuss/1727828/Java-HashMap-or-Ez-to-Understand
*
* */
public class FindOriginalArrayFromDoubledArray {
    /*
    * Time complexity: O(N + N/2)
    * Space Complexity: O(N) <-- HashMap
    * */
    public static int[] findOriginalArray(int[] changed) {
        int len = changed.length;
        if(len % 2 == 1){
            return new int[]{};
        }
        Map<Integer, Integer> digitCountMap = new TreeMap<>();
        //Populate map with each digit occurrence count.
        for(int change : changed){
            digitCountMap.put(change, digitCountMap.getOrDefault(change, 0) + 1);
        }
        int[] ans = new int[len / 2];
        int index = 0;
        //Loop through all digits i.e. keys
        for(int digit : digitCountMap.keySet()) {
            if(digitCountMap.get(digit) == 0){
                continue;
            }

            int doubledDigit = digit * 2;
            //if original digit count is greater than its doubled digit count then, array is not doubled array
            if(digitCountMap.get(digit) > digitCountMap.getOrDefault(doubledDigit, 0)){
                return new int[]{};
            }
            //Updated doubled digit count after subtracting its counterpart original digit count.
            digitCountMap.put(doubledDigit, digitCountMap.get(doubledDigit) - digitCountMap.get(digit));
            int count = digitCountMap.get(digit);

            while(count > 0){
                ans[index] = digit;
                count--;
                index++;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] changed = new int[]{1,3,4,2,6,8};
        int[] original = findOriginalArray(changed);
        Arrays.stream(original).forEach(item -> System.out.println(item));

        changed = new int[]{6,3,0,1};
        original = findOriginalArray(changed);
        Arrays.stream(original).forEach(item -> System.out.println(item));
    }
}
