package datastructures.dstype.hashtable;

import java.util.*;

/*
Minimum Index Sum of Two Lists
Problem Statement:
Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants
represented by strings.

You need to help them find out their common interest with the least list index sum. If there is a choice tie between
answers, output all of them with no order requirement. You could assume there always exists an answer.

* */
public class MinimumIndexSumOfTwoLists {
    public static void main(String[] args) {

    }
    public String[] findRestaurant(String[] list1, String[] list2){
        HashMap<String, Integer> firstMap = new HashMap<>();
        List<String> resultList = new ArrayList<>();
        int min_sum = Integer.MAX_VALUE, sum;
        int index =0;
        for(String l:list1){
            firstMap.put(l,index);
            index++;
        }
        for(int idx=0;idx<list2.length && idx <=min_sum;idx++){
            if(firstMap.containsKey(list2[idx])){
                sum = idx + firstMap.get(list2[idx]);
                if(sum < min_sum){
                    resultList.clear();
                    resultList.add(list2[idx]);
                    min_sum = sum;
                }else if(sum == min_sum){
                    resultList.add(list2[idx]);
                }
            }
        }
        return resultList.toArray(new String[resultList.size()]);
    }
    /*
    Complexity Analysis
    Time complexity : O(l1 +l2 ). Every item of list2 is checked in a map of list1list1.
    l1 and l2 are the lengths of list1 and list2 respectively.

    Space complexity : O(l1 ∗x). hashmap size grows upto l1 ∗x, where x refers to average string length.
    * */
}
