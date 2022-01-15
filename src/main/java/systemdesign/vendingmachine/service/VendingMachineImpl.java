package systemdesign.vendingmachine.service;

import systemdesign.vendingmachine.exceptions.NotFullPaidException;
import systemdesign.vendingmachine.exceptions.NotSufficientChangeException;
import systemdesign.vendingmachine.exceptions.SoldOutException;
import systemdesign.vendingmachine.model.Bucket;
import systemdesign.vendingmachine.model.Coin;
import systemdesign.vendingmachine.model.Item;

import java.util.List;

public class VendingMachineImpl implements VendingMachine {
    private PaymentService paymentService;
    private InventoryService inventoryService;
    private long totalSales;
    private Item currentItem;
    private long currentBalance;

    public VendingMachineImpl(){
        initialize();
    }

    private void initialize(){
        paymentService = new PaymentServiceImpl();
        inventoryService = new InventoryServiceImpl();
    }

    @Override
    public long selectItemAndGetPrice(Item item) {
        if(inventoryService.hasSufficientItems(item)){
            currentItem = item;
            return currentItem.getPrice();
        }
        throw new SoldOutException(item.getName() + " is sold out, Please select another item");
    }

    @Override
    public void insertCoin(Coin coin) {
        currentBalance = currentBalance + coin.getDenomination();
        paymentService.insertCoin(coin);
    }

    @Override
    public List<Coin> refund() {
        List<Coin> refundCoins = paymentService.refund(currentBalance, currentItem);
        currentBalance = 0;
        currentItem = null;
        return refundCoins;
    }

    public boolean isFullPricePaid(){
        if(currentBalance >= currentItem.getPrice()){
            return true;
        }
        return false;
    }

    @Override
    public Bucket<Item, List<Coin>> collectItemAndChange() {
        Item item = collectItem();
        totalSales = totalSales + currentItem.getPrice();
        List<Coin> change =  collectChange();
        return new Bucket<Item, List<Coin>>(item, change);
    }

    private List<Coin> collectChange(){
        long changeAmount = currentBalance - currentItem.getPrice();
        List<Coin> change = paymentService.collectChange(changeAmount, currentItem);
        currentBalance = 0;
        currentItem = null;
        return change;
    }

    private Item collectItem() throws NotSufficientChangeException, NotFullPaidException{
        if(isFullPricePaid()){
            if(hasSufficientChange()){
                inventoryService.updateItemInventory(currentItem);
                return currentItem;
            }
            throw new NotSufficientChangeException("Not Sufficient change in Inventory");
        }
        long remainingBalance = currentItem.getPrice() - currentBalance;
        throw new NotFullPaidException("Price not full paid, remaining balance:" , remainingBalance);
    }

    private boolean hasSufficientChange(){
        long changeAmount = currentBalance - currentItem.getPrice();
        return paymentService.hasSufficientChangeForAmount(changeAmount, currentItem);
    }

    public long getTotalSales(){
        return totalSales;
    }

    public void printStats(){
        System.out.println("Total Sales : " + totalSales);
        inventoryService.printStats();
        paymentService.printStats();
    }

    @Override
    public void reset() {
        paymentService.reset();
        inventoryService.reset();
        totalSales = 0;
        currentItem = null;
        currentBalance = 0;
    }
}
