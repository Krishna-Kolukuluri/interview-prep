package ds.dstype.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class FourSumOrKSumII {
    /*
    Complexity Analysis
    Time Complexity: O(n^2) We have 2 nested loops to count sums, and another 2 nested loops to find complements.
    Space Complexity: O(n^2) for the hashmap. There could be up to O(n^2) distinct a + b keys.
    * */
    /*
    *
    * Algorithm
        For each a in A.

        For each b in B.
        If a + b exists in the hashmap m, increment the value.
        Else add a new key a + b with the value 1.
        For each c in C.

        For each d in D.
        Lookup key -(c + d) in the hashmap m.
        Add its value to the count cnt.
        Return the count cnt.
* */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D){
        HashMap<Integer, Integer> countsMap = new HashMap<>();
        int count = 0;
        for(int a: A){
            for(int b:B){
                countsMap.put(a+b, countsMap.getOrDefault(a+b, 0)+1);
            }
        }
        for(int c: C){
            for(int d:D){
                count += countsMap.getOrDefault(-(c+d), 0);
            }
        }
        return count;
    }

    /*
    Algorithm
      We can implement k/2 nested loops using a recursion, passing the index i of the current list as the parameter. The first group will be
      processed by addToHash recursive function, which accumulates sum and terminates when adding the final sum to a hashmap m.

        The second function, countComplements, will process the other group, accumulating the complement value. In the end,
        it searches for the final complement value in the hashmap and adds its count to the result.
    * */
    /*
     Time Complexity: O(n^(k/2)) or O(n^2) for 4Sum II.We have k/2 nested loops to count sums, and another k/2 nested
     loops to find complements. for odd number of arrays O(n^((k+1)/2))
     Space Complexity:O(n^(k/2)) for the hashmap. The space needed for the recursion will not exceed k/2
    * */
    public int fourSumCountGeneral(int[] A, int[] B, int[] C, int[] D) {
        return kSumCount(new int[][]{A, B, C, D});
    }
    public int kSumCount(int[][] lists) {
        Map<Integer, Integer> m = new HashMap<>();
        addToHash(lists, m, 0, 0);
        return countComplements(lists, m, lists.length / 2, 0);
    }
    void addToHash(int[][] lists, Map<Integer, Integer> m, int i, int sum) {
        if (i == lists.length / 2)
            m.put(sum, m.getOrDefault(sum, 0) + 1);
        else
            for (int a : lists[i])
                addToHash(lists, m, i + 1, sum + a);
    }
    int countComplements(int[][] lists, Map<Integer, Integer> m, int i, int complement) {
        if (i == lists.length)
            return m.getOrDefault(complement, 0);
        int cnt = 0;
        for (int a : lists[i])
            cnt += countComplements(lists, m, i + 1, complement - a);
        return cnt;
    }
}
