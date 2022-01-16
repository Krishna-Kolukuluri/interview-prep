package systemdesign.parkinglot.service;

public class CreditCardTransaction extends PaymentImpl{
    @Override
    public boolean initiateTransaction() {
        return false;
    }
}
