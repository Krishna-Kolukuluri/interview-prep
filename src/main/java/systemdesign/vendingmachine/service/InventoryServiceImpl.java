package systemdesign.vendingmachine.service;

import systemdesign.vendingmachine.model.Inventory;
import systemdesign.vendingmachine.model.Item;

public class InventoryServiceImpl implements InventoryService {
    private Inventory<Item> itemInventory = new Inventory<Item>();
    public InventoryServiceImpl(){
        /*Initialize vending machine with 20 cans of each item*/
        for(Item item: Item.values()){
            itemInventory.put(item, 20);
        }
    }

    @Override
    public void printStats() {
        System.out.println("Current Item Inventory : "+ itemInventory);
    }

    @Override
    public void reset() {
        itemInventory.clearInventory();
    }

    @Override
    public void updateItemInventory(Item item) {
        itemInventory.deduct(item);
    }

    @Override
    public boolean hasSufficientItems(Item item) {
        return itemInventory.hasItem(item);
    }
}
