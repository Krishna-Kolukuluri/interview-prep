package systemdesign.parkinglot.service;

public class CashTransaction extends PaymentImpl{
    @Override
    public boolean initiateTransaction() {
        return false;
    }
}
