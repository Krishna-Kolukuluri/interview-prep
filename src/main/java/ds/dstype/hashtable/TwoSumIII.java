package ds.dstype.hashtable;

import java.util.*;

public class TwoSumIII {
    List<Integer> nums;
    HashMap<Integer, Integer> counterParts;
    public TwoSumIII(){
        nums = new ArrayList<>();
        counterParts = new HashMap<>();
    }
    public void add(int number){
        counterParts.put(number, nums.size());
        nums.add(number);

    }
    //[3,1,2] , target = 3
    //Accepted solution
    public boolean find(int value){
        HashSet<Integer> counterpartNums = new HashSet<>();
        for(Integer num: nums){
            int counterpart = value - num;
            if(counterpartNums.contains(num)){
                return true;
            }
            counterpartNums.add(counterpart);
        }
        return false;
    }

    //Best possible time complexity, by preserving counterparts while adding inputs.
    public boolean findTarget(int value){
        for(int idx =0; idx<nums.size();idx++){
            int counterpart = value - nums.get(idx);
            if(counterParts.containsKey(counterpart) && counterParts.get(counterpart) != idx){
                return true;
            }
        }
        return false;
    }


}
