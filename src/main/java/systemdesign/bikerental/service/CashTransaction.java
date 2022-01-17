package systemdesign.bikerental.service;

public class CashTransaction extends Payment{
    private double cashTendered;

    public double getCashTendered() {
        return cashTendered;
    }

    public void setCashTendered(double cashTendered) {
        this.cashTendered = cashTendered;
    }

    @Override
    public boolean initiateTransaction() {
        return false;
    }
}
