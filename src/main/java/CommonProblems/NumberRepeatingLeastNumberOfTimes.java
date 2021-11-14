package CommonProblems;

import java.sql.ClientInfoStatus;
import java.util.*;

public class NumberRepeatingLeastNumberOfTimes {
    public static void main(String[] args) {

    }
    public static long[] solution(long[] numbers){
        Map<Long, Integer> counts = new HashMap<>();
         if(numbers.length == 0){
             long[] longs;
             longs = new long[0];
             return longs;
         }

        for (Long i : numbers) {
            if (counts.get(i) == null) {
                counts.put(i, 1);
            } else {
                counts.put(i, counts.get(i) + 1);
            }
        }

        //find min value by sorting values and taking top element
        List<Integer> cs = new ArrayList<Integer>(counts.values());
        Collections.sort(cs);
        int minVal = cs.get(0);

        //find elements with minVal as their count
        List<Long> minElements = new ArrayList<>();
        for (Map.Entry<Long, Integer> entry : counts.entrySet()) {
            if (entry.getValue() == minVal) {
                minElements.add(entry.getKey());
            }
        }
        Collections.sort(minElements);
        return minElements.stream().mapToLong(l -> l).toArray();

    }
}
