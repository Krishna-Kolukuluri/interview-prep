package systemdesign.vendingmachine.service;

import systemdesign.vendingmachine.model.Bucket;
import systemdesign.vendingmachine.model.Coin;
import systemdesign.vendingmachine.model.Item;

import java.util.List;

public interface VendingMachine extends CommonService {
    public long selectItemAndGetPrice(Item item);
    public void insertCoin(Coin coin);
    public List<Coin> refund();
    public Bucket<Item, List<Coin>> collectItemAndChange();

}
