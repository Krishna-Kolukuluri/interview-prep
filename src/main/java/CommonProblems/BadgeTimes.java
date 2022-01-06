package CommonProblems;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
*
We are working on a security system for a badged-access room in our company's building.
We want to find employees who badged into our secured room unusually often. We have an unordered list of names and entry
times over a single day. Access times are given as numbers up to four digits in length using 24-hour time, such as "800" or "2250".
Write a function that finds anyone who badged into the room three or more times in a one-hour period, and returns each
time that they badged in during that period. (If there are multiple one-hour periods where this was true, just return the first one.)
*
badge_times = [
["Paul", 1355],
["Jennifer", 1910],
["John", 830],
["Paul", 1315],
["John", 1615],
["John", 1640],
["John", 835],
["Paul", 1405],
["John", 855],
["John", 930],
["John", 915],
["John", 730],
["Jennifer", 1335],
["Jennifer", 730],
["John", 1630],
]

Expected output (in any order)
John: 830 835 855 915 930
Paul: 1315 1355 1405

n: length of the badge records array
* */
public class BadgeTimes {
    public static void main(String[] args) {
        String[][] badgeTimes = {
                {"Paul", "1355"},
                {"Jennifer", "1910"},
                {"John", "830"},
                {"Paul", "1315"},
                {"John", "1615"},
                {"John", "1640"},
                {"John", "835"},
                {"Paul", "1405"},
                {"John", "855"},
                {"John", "930"},
                {"John", "915"},
                {"John", "730"},
                {"Jennifer", "1335"},
                {"Jennifer", "730"},
                {"John", "1630"}
        };
        System.out.println(unusualAccess(badgeTimes));
    }

    private static Map<String, List<Integer>> unusualAccess(String[][] accessLogs){
        Map<String, TreeSet<Integer>> map = new HashMap<>();
        Map<String, List<Integer>> resultMap = new HashMap<>();
        //Convert accessLogs per user
        for(int i=0;i<accessLogs.length;i++){
            map.computeIfAbsent(accessLogs[i][0], val -> new TreeSet<>()).add(Integer.parseInt(accessLogs[i][1]));
        }
        //Calculate unusual accesses
        for(Map.Entry<String, TreeSet<Integer>> mapItem: map.entrySet()){
            String userName = mapItem.getKey();
            TreeSet<Integer> userAccessLog = mapItem.getValue();
            List<Integer> accessTimes = new ArrayList<>(userAccessLog);

            if(accessTimes.size() >= 3){
                int index = 0;
                while(index < accessTimes.size() - 2){
                    int hStartIndex = index;
                    if(accessTimes.get(index+2) - accessTimes.get(index) <= 100){
                        hStartIndex = index  + 2;
                        while (hStartIndex < accessTimes.size() && accessTimes.get(hStartIndex) - accessTimes.get(index) <= 100){
                            hStartIndex++;
                        }
                        List<Integer> subList =accessTimes.subList(index, hStartIndex);
                        if(!resultMap.containsKey(userName)){
                            resultMap.put(userName, subList);
                        }else{
                            List<Integer> temp = resultMap.get(userName);
                            resultMap.put(userName, Stream.concat(temp.stream(), subList.stream()).collect(Collectors.toList()));
                        }
                        index = hStartIndex;
                    }else{
                        index = hStartIndex + 1;
                    }
                }
            }
        }
        return  resultMap;
    }
}
