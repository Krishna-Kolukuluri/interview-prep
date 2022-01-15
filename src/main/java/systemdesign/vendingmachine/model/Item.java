package systemdesign.vendingmachine.model;
/*
* Items or products supported by Vending Machine.
* */
public enum Item {
    COKE("Coke", 25),
    PEPSI("Pepsi", 35),
    SODA("Soda", 45),
    WATER("Water", 30);
    private String name;
    private int price;

    private Item(String name, int price){
        this.name = name;
        this.price = price;
    }
    public String getName(){
        return this.name;
    }
    public long getPrice(){
        return this.price;
    }
}
