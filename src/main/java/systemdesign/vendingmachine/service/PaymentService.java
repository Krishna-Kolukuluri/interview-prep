package systemdesign.vendingmachine.service;

import systemdesign.vendingmachine.model.Coin;
import systemdesign.vendingmachine.model.Item;

import java.util.List;

public interface PaymentService extends CommonService {
    public boolean hasSufficientChangeForAmount(long amount, Item currentItem);
    public void updateCashInventory(List<Coin> change);
    public List<Coin> collectChange(long changeAmount, Item currentItem);
    public List<Coin> getChange(long amount, Item item);
    public List<Coin> refund(long currentBalance, Item currentItem);
    public void insertCoin(Coin coin);
}
