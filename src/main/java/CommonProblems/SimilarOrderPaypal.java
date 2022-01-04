package CommonProblems;

import java.util.*;

public class SimilarOrderPaypal {
    public static void main(String[] args) {
        String strOne = "Krishna";
        String strTwo = "KrishnaTwo";
        //System.out.println(strTwo - strOne);

    }
    private static List<String> similarOrders(List<String> userOneOrders, List<String> userTwoOrders){
        List<String> result = new ArrayList<>();
        for(String oOne: userOneOrders){
            for(String oTwo: userTwoOrders){
                if(oOne.length() != oTwo.length()){
                    continue;
                }
                HashMap<Character, Integer> oMap = getCharMap(oOne);
                HashMap<Character, Integer> tMap = getCharMap(oTwo);
                 if(isSimilarOrder(oMap, tMap)){
                     result.add("YES");
                 }else{
                     result.add("NO");
                 }
            }
        }
        return result;
    }
    private static HashMap<Character, Integer> getCharMap(String order){
        char[] oChars = order.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c: oChars){
            Integer count = map.getOrDefault(c, 0);
            count++;
            map.put(c,count);
        }
        return map;
    }

    private static boolean isSimilarOrder(HashMap<Character, Integer> oOrderMap,
                                        HashMap<Character, Integer> tOrderMap){
        int disCharCount = 0;
        for(Map.Entry<Character, Integer> order: oOrderMap.entrySet()){
            if(tOrderMap.containsKey(order.getKey())){
                Integer tOrder = tOrderMap.get(order.getKey());
                if(tOrder - order.getValue() >3){
                    return false;
                }
            }
            else{
                disCharCount++;
            }
        }
        if(disCharCount>3){
            return false;
        }

        return true;

    }
}
