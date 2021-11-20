package datastructures.dstype.arraytype;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class RecentItems {
    public static void main(String[] args) {

    }
    private static LinkedHashSet<String> recentItemsSet = new LinkedHashSet<>();
    public static List<String> recentItems(List<String> logs){
        for(String log: logs){
            LinkedHashSet<String> tempSet = new LinkedHashSet<>();
            if(recentItemsSet.contains(log)){
                recentItemsSet.remove(log);
            }
            tempSet.add(log);
            tempSet.addAll(recentItemsSet);
            recentItemsSet = tempSet;
        }
       return new ArrayList<String>(recentItemsSet);
    }
}
