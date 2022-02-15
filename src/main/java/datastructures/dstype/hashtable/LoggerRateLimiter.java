package datastructures.dstype.hashtable;

import java.util.HashMap;

//Logger Rate Limiter
/*
https://leetcode.com/problems/logger-rate-limiter/
https://leetcode.com/problems/logger-rate-limiter/solution/
Problem Statement:
Design a logger system that receives a stream of messages along with their timestamps. Each unique message should only
be printed at-most every 10 seconds (i.e. a message printed at timestamp t will prevent other identical messages from
being printed until timestamp t + 10).

All messages will come in chronological order. Several messages may arrive at the same timestamp.

Implement the Logger class:
Logger() Initializes the logger object.
bool shouldPrintMessage(int timestamp, string message) Returns true if the message should be printed in the given
timestamp, otherwise returns false.
* */
public class LoggerRateLimiter {
    public static void main(String[] args) {

    }
    private HashMap<String, Integer> timeTrackingMap;
    public LoggerRateLimiter(){
        timeTrackingMap = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message){
        if(timeTrackingMap.containsKey(message)){
           if(timestamp > timeTrackingMap.get(message)+10){
               timeTrackingMap.put(message, timestamp);
               return true;
           }
           else{
               return false;
           }
        }else{
            timeTrackingMap.put(message, timestamp);
        }
        return true;
    }
    /*
    Complexity Analysis:
    Time Complexity: O(1). The lookup and update of the hashtable takes a constant time.

    Space Complexity: O(M) where MM is the size of all incoming messages. Over the time, the hashtable would have an
    entry for each unique message that has appeared.
    * */
}
