package systemdesign.coffeemachine.model;

import java.util.HashMap;
import java.util.Map;

/*
 * An Adapter over Map to create Inventory to hold Ingredient inside Coffee Machine
 * */
public class Inventory<T> {
    private Map<T, Integer> inventory = new HashMap<T, Integer>();
    public int getQuantity(T item){
        Integer value =  inventory.get(item);
        return value == null ? 0: value;
    }

    public void add(T item){
        Integer count =  inventory.get(item);
        count = count==null ? 0+1: count+1;
        inventory.put(item, count);
    }

    public void deduct(T item){
        if(hasItem(item)){
            int count = inventory.get(item);
            inventory.put(item, count - 1);
        }
    }

    public boolean hasItem(T item){
        return getQuantity(item) > 0;
    }

    public void clearInventory(){
        inventory.clear();
    }

    public void put(T item, int quantity){
        inventory.put(item, quantity);
    }
}
