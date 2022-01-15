package systemdesign.vendingmachine.service;

import systemdesign.vendingmachine.model.Item;

public interface InventoryService extends CommonService {
    public void updateItemInventory(Item item);
    public boolean hasSufficientItems(Item item);
}
