package CommonProblems;

import java.util.ArrayList;
import java.util.List;

public class MergeSortedList {
    public static void main(String[] args) {
        List<LogMessage> logOneList = new ArrayList<>();
        LogMessage logMessage = new LogMessage();
        logMessage.message = "MessageOne";
        logMessage.timeStamp = 1;
        logOneList.add(logMessage);
        logMessage = new LogMessage();
        logMessage.message = "MessageFour";
        logMessage.timeStamp = 4;
        logOneList.add(logMessage);
        List<LogMessage> logTwoList = new ArrayList<>();
        logMessage = new LogMessage();
        logMessage.message = "MessageTwo";
        logMessage.timeStamp = 2;
        logTwoList.add(logMessage);
        logMessage = new LogMessage();
        logMessage.message = "MessageThree";
        logMessage.timeStamp = 3;
        logTwoList.add(logMessage);

        for(LogMessage log: mergeLogs(logOneList, logTwoList)){
            System.out.println(log.message + "-" + log.timeStamp);
        }
    }
    public static List<LogMessage> mergeLogs(List<LogMessage> logOneList, List<LogMessage> logTwoList){
        List<LogMessage> result = new ArrayList<>();
        int idxOne = 0;
        int idxTwo = 0;
        while(idxOne < logOneList.size() || idxTwo < logTwoList.size()){
            if(idxOne < logOneList.size() && idxTwo < logTwoList.size()){
                if(logOneList.get(idxOne).timeStamp < logTwoList.get(idxTwo).timeStamp){
                    result.add(logOneList.get(idxOne));
                    idxOne++;
                }else{
                    result.add(logTwoList.get(idxTwo));
                    idxTwo++;
                }
            }
            else if(idxOne < logOneList.size()){
                result.add(logOneList.get(idxOne));
                idxOne++;
            }
            else if(idxTwo < logTwoList.size()){
                result.add(logTwoList.get(idxTwo));
                idxTwo++;
            }
        }
        return result;
    }
}
class LogMessage{
    public String message;
    public long timeStamp;
}
