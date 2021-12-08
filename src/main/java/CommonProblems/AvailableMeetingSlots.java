package CommonProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AvailableMeetingSlots {
    public static void main(String[] args) {
        List<List<Integer>> usedSlots = new ArrayList<>();
        List<Integer> tempSlot = new ArrayList<Integer>(Arrays.asList(1,3));
        usedSlots.add(tempSlot);
        tempSlot = new ArrayList<Integer>(Arrays.asList(5,7));
        usedSlots.add(tempSlot);
        tempSlot = new ArrayList<Integer>(Arrays.asList(9,10));
        usedSlots.add(tempSlot);
        List<List<Integer>> result = getAvailableSlots(usedSlots);
        for(List<Integer> slot: result){
            System.out.println(slot.get(0) + " - " + slot.get(1));
        }
    }
    public static List<List<Integer>> getAvailableSlots(List<List<Integer>> usedSlots){
        usedSlots.sort((A, B) -> {
            if(A.get(0) != B.get(0)){
                return A.get(0) - B.get(0);
            }
            else{
                return A.get(1) - B.get(0);
            }
        });

        List<List<Integer>> distinctUsedSlots = new ArrayList<>();
        List<Integer> tempSlot = usedSlots.get(0);
        for(int index = 1; index < usedSlots.size(); index++){
          List<Integer> currentSlot = usedSlots.get(index);
          if(overlapped(tempSlot, currentSlot)){
              int aSlotStart = Math.min(currentSlot.get(0), tempSlot.get(0));
              int aSlotEnd = Math.max(currentSlot.get(1), tempSlot.get(1));
              tempSlot.add(0, aSlotStart);
              tempSlot.add(1, aSlotEnd);
          }
          else{
              distinctUsedSlots.add(tempSlot);
              tempSlot = currentSlot;
          }
        }
        distinctUsedSlots.add(tempSlot);
        List<List<Integer>> availableSlots = new ArrayList<>();
        for(int index = 0; index<distinctUsedSlots.size() -1; index++){
            int start = distinctUsedSlots.get(index).get(1);
            int end = distinctUsedSlots.get(index+1).get(0);
            List<Integer> slot = new ArrayList<>();
            slot.add(0, start);
            slot.add(1, end);
            availableSlots.add(slot);
        }
        return availableSlots;

    }
    public static boolean overlapped(List<Integer> list1, List<Integer> list2){
        return !(list1.get(1) < list2.get(0) || list2.get(1) < list1.get(0));
    }
}
