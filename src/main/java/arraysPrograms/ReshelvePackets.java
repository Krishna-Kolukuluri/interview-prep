package arraysPrograms;

import java.util.*;
import java.util.HashMap;
import java.util.List;

public class ReshelvePackets {
    
    public static void main(String args[]){
        List<Integer> arr = new ArrayList<>();
        arr.add(4);
        arr.add(1);
        arr.add(3);
        arr.add(7);
        arr.add(3);
        reshelve(arr);
    }
    static List<Integer> reshelve(List<Integer> arr){
        List<Integer> array = new ArrayList<>();
        for(int i=0;i<arr.size();i++){
            array.add(arr.get(i));
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        Collections.sort(array);
        int val=1;
        for(int n:array){
            if (map.get(n) == null)
                map.put(n, val);
            val++;
        }
        
        List<Integer> result =  new ArrayList<>();
        for(int n:arr){
            result.add(map.get(n));
            System.out.println(map.get(n));
        }
        return result;
        
    }

}
