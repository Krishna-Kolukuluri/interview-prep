package systemdesign.vendingmachine.model;
/*
* Coins supported by Vending machine.
* */
public enum Coin {
    PENNY(1),
    NICKLE(5),
    DIME(10),
    QUARTER(25),
    ONE$(100),
    TWO$(200),
    FIVE$(500),
    TEN$(1000);
    private int denomination;
    Coin(int denomination) {
        this.denomination = denomination;
    }
    public int getDenomination(){
        return this.denomination;
    }
}
