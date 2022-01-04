package CommonProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class RandomizedSetExample {
}
class RandomizedSet{
    public HashMap<Integer, Integer> map;
    public List<Integer> result;
    public Random random;

    public RandomizedSet(){
        map = new HashMap<>();
        result = new ArrayList<>();
        random = new Random();
    }
    public boolean add(int val){
        if(map.containsKey(val)){
            return false;
        }
        map.put(val, result.size());
        result.add(result.size(), val);
        return true;
    }
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val){
        if(!map.containsKey(val)){
            return false;
        }
        // move the last element to the place idx of the element to delete
        int valIndex = map.get(val);
        int lastElement = result.get(result.size() - 1);
        if(valIndex != result.size() - 1){
            result.set(valIndex, lastElement);
            map.put(lastElement, valIndex);
        }
        // delete the last element
        result.remove(result.size() - 1);
        map.remove(val);
        return true;
    }
    public int getRandom(){
        return result.get(random.nextInt(result.size()));
    }
}
/*
*
Complexity Analysis

Time complexity: GetRandom is always O(1). Insert and Delete both have O(1) average time
complexity, O(N) in the worst-case scenario when the operation exceeds the capacity of currently allocated array/hashmap and invokes space reallocation.

Space complexity:O(N), to store N elements.
*
* */
