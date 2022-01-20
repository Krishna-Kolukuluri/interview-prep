package CommonProblems;

import java.util.*;

/*
https://leetcode.com/problems/alert-using-same-key-card-three-or-more-times-in-a-one-hour-period/
https://leetcode.com/problems/alert-using-same-key-card-three-or-more-times-in-a-one-hour-period/discuss/1674077/Java-Simple-Solution-Using-HashMap
LeetCode company workers use key-cards to unlock office doors. Each time a worker uses their key-card, the security
system saves the worker's name and the time when it was used. The system emits an alert if any worker uses the key-card
three or more times in a one-hour period.

You are given a list of strings keyName and keyTime where [keyName[i], keyTime[i]] corresponds to a person's name and
the time when their key-card was used in a single day.

Access times are given in the 24-hour time format "HH:MM", such as "23:51" and "09:49".

Return a list of unique worker names who received an alert for frequent keycard use. Sort the names in ascending order
alphabetically.

Notice that "10:00" - "11:00" is considered to be within a one-hour period, while "22:51" - "23:52" is not considered
to be within a one-hour period.
* */
public class KeyCardAlerts {
    public static void main(String[] args) {
       String[] keyName = {"daniel","daniel","daniel","luis","luis","luis","luis"};
       String[] keyTime = {"10:00","10:40","11:00","09:00","11:00","13:00","15:00"};
       System.out.println(alertNames(keyName,keyTime));

        keyName = new String[] {"alice","alice","alice","bob","bob","bob","bob"};
        keyTime = new String[] {"12:01","12:00","18:00","21:00","21:20","21:30","23:00"};
        System.out.println(alertNames(keyName,keyTime));
    }
    public static List<String> alertNames(String[] keyName, String[] keyTime) {
        HashMap<String, List<Integer>> hm = new HashMap<>();

        for(int i=0; i<keyName.length; i++){
            String s = keyName[i];

            hm.putIfAbsent(s, new ArrayList<>());

            String[] arr = keyTime[i].split(":");

            String time = arr[0] + arr[1];
            System.out.println(time);
            System.out.println(Integer.parseInt(time));

            hm.get(s).add(Integer.parseInt(time));
        }

        Set<String> res = new TreeSet<>();

        for(Map.Entry<String, List<Integer>> map: hm.entrySet()){
            List<Integer> l = new ArrayList<>(map.getValue());

            Collections.sort(l);

            int count = 1;

            for(int i=0; i<l.size(); i++){
                for(int j=i+1; j<l.size(); j++){
                    if(l.get(j) - l.get(i) <= 100)
                        count++;
                    else{
                        count = 1;
                        break;
                    }
                    if(count >= 3)
                        break;
                }
                if(count >= 3){
                    res.add(map.getKey());
                    break;
                }
            }
        }

        return new ArrayList<>(res);
    }
}
