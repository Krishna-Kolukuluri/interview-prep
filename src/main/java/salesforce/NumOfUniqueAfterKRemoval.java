package salesforce;

import java.util.*;

/**
 Given an array of integers arr and an integer k. Find the least number of unique integers after removing exactly k elements.

Example 1:
Input: arr = [5,5,4], k = 1
Output: 1
Explanation: Remove the single 4, only 5 is left.

Example 2:
Input: arr = [4,3,1,1,3,3,2], k = 3
Output: 2
Explanation: Remove 4, 2 and either one of the two 1s or three 3s. 1 and 3 will be left.
 */

public class NumOfUniqueAfterKRemoval {
    class Pair{
        int a;
        int b;
        Pair(int a , int b){
            this.a = a;
            this.b = b;
        }
    }

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i : arr){
            if(map.containsKey(i)){
                map.put(i , map.get(i) + 1);
            }
            else{
                map.put(i , 1);
            }
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((aa , bb) -> aa.b - bb.b);
        for(Map.Entry<Integer , Integer> m : map.entrySet()){
            int key = m.getKey();
            int val = m.getValue();
            pq.add(new Pair(key , val));
        }
        for(int i = 0 ; i < k ; i++){
            Pair p= pq.remove();
            int key = p.a;
            int val = p.b;
            if(val - 1 > 0){
                pq.add(new Pair(key , val - 1));
            }
        }
       
        int ans = pq.size();
        return ans;
    }
}
