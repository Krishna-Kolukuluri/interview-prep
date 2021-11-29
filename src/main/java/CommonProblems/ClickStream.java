package CommonProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClickStream {
    public static void main(String[] args) {
        String[] user0 = new String[] {"/start", "/green", "/blue", "/pink", "/register", "/orange", "/one/two"};
        String[] user1 = new String[] {"/start", "/pink", "/register", "/orange", "/red", "a"};
        String[] user2 = new String[] {"a", "/one", "/two"};
        String[] user3 = new String[] {"/pink", "/orange", "/yellow", "/plum", "/blue", "/tan", "/red", "/amber", "/HotRodPink", "/CornflowerBlue", "/LightGoldenRodYellow", "/BritishRacingGreen"};
        String[] user4 = new String[] {"/pink", "/orange", "/amber", "/BritishRacingGreen", "/plum", "/blue", "/tan", "/red", "/lavender", "/HotRodPink", "/CornflowerBlue", "/LightGoldenRodYellow"};
        String[] user5 = new String[] {"a"};
        String[] user6 = new String[] {"/pink","/orange","/six","/plum","/seven","/tan","/red", "/amber"};
        List<String> resul = findContiguousHistory(user0, user1);
        System.out.println(resul);

    }
    //Best Time Complexity and Space Complexity
    public static List<String> findContiguousHistory(String [] array1 , String [] array2){

        String [] longArray = array1;
        String [] shortArray = array2;


        if(array1.length < array2.length){
            shortArray = array1;
            longArray = array2;
        } else {
            shortArray = array2;
            longArray = array1;
        }

        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<longArray.length; i++){
            map.put(longArray[i],i);
        }

        List<String> result = new ArrayList<>();

        for(int i=0; i<shortArray.length; i++){
            List<String> curr = new ArrayList<>();
            String str = shortArray[i];
            if(map.containsKey(str)){
                int index = map.get(str);
                int k = i;
                while(index < longArray.length && k< shortArray.length){
                    if(longArray[index].equalsIgnoreCase(shortArray[k])){
                        curr.add(shortArray[k]);
                    } else break;
                    index++;
                    k++;
                }
                if(result.size() < curr.size()){
                    result = curr;
                }
            }
        }

        return result;
    }
}
