package shopify;

import java.util.ArrayList;
import java.util.List;
// # Write a function that takes a list of integers and outputs a list of pairs
// # representing the consecutive ranges contained in the input list
// #
// # test_list1 = [1,3,4]
// # test_output1 = [(1,1),(3,4)]
// #
// # test_list2 = [1,2,3,4,5]
// # test_output2 = [(1,5)]
// #
// # test_list3 = [1,3,4,5,6,7,9]
// # test_output3 = [(1,1), (3,7), (9,9)]
public class ConsecutivePairs {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4};
        List<List<Integer>> result = consecutivePairs(arr);
        System.out.println(result);
        int[] arr1 = {1, 2, 4, 5, 6, 7, 9};
        result = consecutivePairs(arr1);
        System.out.println(result);
    }

    static List<List<Integer>> consecutivePairs(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        int len = 1;
        if (arr.length == 0) {
            return result;
        }
        for (int i = 1; i <= arr.length; i++) {
            if (i == arr.length || arr[i] - arr[i - 1] != 1) {
                if (len == 1) {
                    List<Integer> res = new ArrayList<>();
                    res.add(arr[i - len]);
                    res.add(arr[i - len]);
                    result.add(res);
                } else {
                    List<Integer> res = new ArrayList<>();
                    res.add(arr[i - len]);
                    res.add(arr[i - 1]);
                    result.add(res);
                    len = 1;
                }
            } else {
                len++;
            }
        }
        return result;
    }
}
