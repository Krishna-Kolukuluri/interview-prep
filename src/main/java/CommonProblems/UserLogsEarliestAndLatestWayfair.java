package CommonProblems;

import java.util.*;

/*
*
Suppose we have an unsorted log file of accesses to web resources. Each log entry consists of an access time, the ID of
the user making the access, and the resource ID.

The access time is represented as seconds since 00:00:00, and all times are assumed to be in the same day.

For example:
logs1 = [
["58523", "user_1", "resource_1"],
["62314", "user_2", "resource_2"],
["54001", "user_1", "resource_3"],
["200", "user_6", "resource_5"],
["215", "user_6", "resource_4"],
["54060", "user_2", "resource_3"],
["53760", "user_3", "resource_3"],
["58522", "user_22", "resource_1"],
["53651", "user_5", "resource_3"],
["2", "user_6", "resource_1"],
["100", "user_6", "resource_6"],
["400", "user_7", "resource_2"],
["100", "user_8", "resource_6"],
["54359", "user_1", "resource_3"],
]

We would like to compute user sessions, specifically: write a function that takes the logs and returns a data structure
that associates to each user their earliest and latest access times.

Example:
{'user_1': [54001, 58523],
'user_2': [54060, 62314],
'user_3': [53760, 53760],
'user_5': [53651, 53651],
'user_6': [2, 215],
'user_7': [400, 400],
'user_8': [100, 100],
'user_22': [58522, 58522],
}

Example 2:
logs2 = [
["300", "user_1", "resource_3"],
["599", "user_1", "resource_3"],
["900", "user_1", "resource_3"],
["1199", "user_1", "resource_3"],
["1200", "user_1", "resource_3"],
["1201", "user_1", "resource_3"],
["1202", "user_1", "resource_3"]
]

Should return:
{'user_1': [300, 1202]}

Example 3:
logs3 = [
["300", "user_10", "resource_5"]
]

Should return:
{'user_10': [300, 300]}

Complexity analysis variables:

n: number of logs in the input
* */
public class UserLogsEarliestAndLatestWayfair {

    public static void main(String[] args) {

        List<List<String>> logs = new ArrayList<>();
        List<String> log = new ArrayList<>(Arrays.asList("58523", "user_1", "resource_1"));
        logs.add(log);
        log = new ArrayList<>(Arrays.asList("62314", "user_2", "resource_2"));
        logs.add(log);
        log = new ArrayList<>(Arrays.asList("54001", "user_1", "resource_3"));
        logs.add(log);
        log = new ArrayList<>(Arrays.asList("200", "user_6", "resource_5"));
        logs.add(log);
        log = new ArrayList<>(Arrays.asList("215", "user_6", "resource_4"));
        logs.add(log);
        System.out.println(getUserLogs(logs));

    }

    public static List<UserLog> getUserLogs(List<List<String>> userLogs){

        HashMap<String, List<Integer>> logs = new HashMap<>();

        for(List<String> strings: userLogs){
            String userId = strings.get(1);
            if(logs.containsKey(userId)){
                logs.get(userId).add(Integer.parseInt(strings.get(0)));
            }
            else{
                List<Integer> log = new ArrayList<>();
                log.add(Integer.parseInt(strings.get(0)));
                logs.put(userId, log);
            }
        }

        List<UserLog> result = new ArrayList<>();

        for(Map.Entry<String, List<Integer>> entry: logs.entrySet()){
            UserLog userLog = new UserLog();
            userLog.userId = entry.getKey();
            userLog.logTimes = getEarliestAndLatest(entry.getValue());
            result.add(userLog);
        }

        return result;
    }

    public static List<Integer> getEarliestAndLatest(List<Integer> logTimes){
        Collections.sort(logTimes);
        return new ArrayList<Integer>(Arrays.asList(logTimes.get(0), logTimes.get(logTimes.size() - 1)));
    }

}

class UserLog {

    String userId;

    List<Integer> logTimes;

    @Override
    public String toString() {
        return "UserLog{" +
                "userId='" + userId + '\'' +
                ", logTimes=" + logTimes +
                '}';
    }
}
