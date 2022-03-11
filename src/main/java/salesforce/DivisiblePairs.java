package salesforce;

import java.util.*;

public class DivisiblePairs {
    //O(1) -HashMap

    public int numPairsDivisibleBy60(int[] time) {

        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < time.length; i++) {
            
            int key = time[i] % 60;
            int pairedKey = key == 0 ? key : 60 - key;
            
            count += map.getOrDefault(pairedKey, 0);           

            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        
        return count;
    }
}
