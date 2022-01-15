package systemdesign.vendingmachine.tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import systemdesign.vendingmachine.exceptions.NotSufficientChangeException;
import systemdesign.vendingmachine.exceptions.SoldOutException;
import systemdesign.vendingmachine.model.Bucket;
import systemdesign.vendingmachine.model.Coin;
import systemdesign.vendingmachine.model.Item;
import systemdesign.vendingmachine.service.VendingMachine;
import systemdesign.vendingmachine.service.VendingMachineFactory;
import systemdesign.vendingmachine.service.VendingMachineImpl;

import java.util.List;

import static org.junit.Assert.*;

public class VendingMachineTest {
    private static VendingMachine vendingMachine;

    @BeforeClass
    public static void setUp(){
        vendingMachine = new VendingMachineImpl();
    }
    @AfterClass
    public static void tearDown(){
        vendingMachine = null;
    }

    @Test
    public void testBuyItemWithExactPrice(){
        long price = vendingMachine.selectItemAndGetPrice(Item.COKE);
        assertEquals(Item.COKE.getPrice(), price);

        vendingMachine.insertCoin(Coin.QUARTER);
        Bucket<Item, List<Coin>> bucket = vendingMachine.collectItemAndChange();
        Item item = bucket.getFirst();
        List<Coin> change = bucket.getSecond();
        assertEquals(Item.COKE, item);
        assertTrue(change.isEmpty());
    }

    @Test
    public void testBuyItemWithMorePrice(){
        long price = vendingMachine.selectItemAndGetPrice(Item.SODA);
        assertEquals(Item.SODA.getPrice(), price);

        vendingMachine.insertCoin(Coin.QUARTER);
        vendingMachine.insertCoin(Coin.QUARTER);
        Bucket<Item, List<Coin>> bucket = vendingMachine.collectItemAndChange();
        Item item = bucket.getFirst();
        List<Coin> change = bucket.getSecond();

        assertEquals(Item.SODA, item);
        assertFalse(change.isEmpty());
        assertEquals(50 - Item.SODA.getPrice(), getTotal(change));
    }

    @Test
    public void testRefund(){
        long price = vendingMachine.selectItemAndGetPrice(Item.PEPSI);
        assertEquals(Item.PEPSI.getPrice(), price);

        vendingMachine.insertCoin(Coin.DIME);
        vendingMachine.insertCoin(Coin.NICKLE);
        vendingMachine.insertCoin(Coin.PENNY);
        vendingMachine.insertCoin(Coin.QUARTER);

        assertEquals(41, getTotal(vendingMachine.refund()));
    }

    @Test(expected = SoldOutException.class)
    public void testSoldOut(){
        for(int i = 0; i < 21; i++){
            vendingMachine.selectItemAndGetPrice(Item.COKE);
            vendingMachine.insertCoin(Coin.QUARTER);
            vendingMachine.collectItemAndChange();
        }
    }

    @Test(expected = NotSufficientChangeException.class)
    public void testNotSufficientChangeException(){
        for (int i = 0; i < 21; i++) { 
            vendingMachine.selectItemAndGetPrice(Item.SODA);
            vendingMachine.insertCoin(Coin.QUARTER);
            vendingMachine.insertCoin(Coin.QUARTER);
            vendingMachine.collectItemAndChange();
            vendingMachine.selectItemAndGetPrice(Item.PEPSI);
            vendingMachine.insertCoin(Coin.QUARTER);
            vendingMachine.insertCoin(Coin.QUARTER);
            vendingMachine.collectItemAndChange();
        }
        
    }

    @Test(expected = SoldOutException.class)
    public void testReset(){
        VendingMachine machine = VendingMachineFactory.createVendingMachine();
        machine.reset();
        machine.selectItemAndGetPrice(Item.PEPSI);
    }


    private long getTotal(List<Coin> change){
        long total = 0;
        for(Coin c : change){
            total = total + c.getDenomination();
        }
        return total;
    }

}
