package systemdesign.bikerental.model;

public class Bill {
    private double amount;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean addBillItem(BillItem billItem){
        return false;
    }
}
