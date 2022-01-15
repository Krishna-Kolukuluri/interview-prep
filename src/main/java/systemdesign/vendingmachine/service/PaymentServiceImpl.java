package systemdesign.vendingmachine.service;

import systemdesign.vendingmachine.exceptions.NotSufficientChangeException;
import systemdesign.vendingmachine.model.Coin;
import systemdesign.vendingmachine.model.Inventory;
import systemdesign.vendingmachine.model.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PaymentServiceImpl implements PaymentService, CommonService {
    private Inventory<Coin> cashInventory = new Inventory<Coin>();
    public PaymentServiceImpl(){
        /*Initialize vending machine with 20 coins of each denomination*/
        for(Coin c: Coin.values()){
            cashInventory.put(c, 20);
        }
    }

    @Override
    public boolean hasSufficientChangeForAmount(long amount, Item currentItem) {
        try{
            getChange(amount, currentItem);
        }catch (NotSufficientChangeException nsce){
            return  false;
        }
        return true;
    }

    @Override
    public void updateCashInventory(List<Coin> change) {
        for(Coin c : change){
            cashInventory.deduct(c);
        }
    }

    @Override
    public List<Coin> collectChange(long changeAmount, Item currentItem) {
        List<Coin> change = getChange(changeAmount, currentItem);
        updateCashInventory(change);
        return change;
    }

    @Override
    public List<Coin> getChange(long amount, Item item) {
        List<Coin> changes = Collections.EMPTY_LIST;
        if(amount > 0){
            changes = new ArrayList<>();
            long balance = amount;
            while (balance > 0){
                if(balance >= Coin.FIVE$.getDenomination() && cashInventory.hasItem(Coin.FIVE$)){
                    changes.add(Coin.FIVE$);
                    balance = balance - Coin.FIVE$.getDenomination();
                    continue;
                }else if(balance >= Coin.TWO$.getDenomination() && cashInventory.hasItem(Coin.TWO$)){
                    changes.add(Coin.TWO$);
                    balance = balance - Coin.TWO$.getDenomination();
                    continue;
                }else if(balance >= Coin.ONE$.getDenomination() && cashInventory.hasItem(Coin.ONE$)){
                    changes.add(Coin.ONE$);
                    balance = balance - Coin.ONE$.getDenomination();
                    continue;
                }else if(balance >= Coin.QUARTER.getDenomination() && cashInventory.hasItem(Coin.QUARTER)){
                    changes.add(Coin.QUARTER);
                    balance = balance - Coin.QUARTER.getDenomination();
                    continue;
                }else if(balance >= Coin.DIME.getDenomination() && cashInventory.hasItem(Coin.DIME)){
                    changes.add(Coin.DIME);
                    balance = balance - Coin.DIME.getDenomination();
                    continue;
                }else if(balance >= Coin.NICKLE.getDenomination() && cashInventory.hasItem(Coin.NICKLE)){
                    changes.add(Coin.NICKLE);
                    balance = balance - Coin.NICKLE.getDenomination();
                    continue;
                }else if(balance >= Coin.PENNY.getDenomination() && cashInventory.hasItem(Coin.PENNY)){
                    changes.add(Coin.PENNY);
                    balance = balance - Coin.PENNY.getDenomination();
                    continue;
                }else{
                    throw new NotSufficientChangeException("NotSufficientChange for product: '"+ item.getName() + "'. Please try another product");
                }
            }
        }
        return changes;
    }

    @Override
    public List<Coin> refund(long currentBalance, Item currentItem) {
        List<Coin> refundCoins = getChange(currentBalance, currentItem);
        updateCashInventory(refundCoins);
        return refundCoins;
    }

    @Override
    public void reset() {
        cashInventory.clearInventory();
    }

    @Override
    public void insertCoin(Coin coin) {
        cashInventory.add(coin);
    }

    @Override
    public void printStats() {
        System.out.println("Current Cash Inventory : " + cashInventory);
    }
}
