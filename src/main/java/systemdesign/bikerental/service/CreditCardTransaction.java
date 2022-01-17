package systemdesign.bikerental.service;

public class CreditCardTransaction  extends Payment{
    private String nameOnCard;

    public String getNameOnCard() {
        return nameOnCard;
    }

    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    @Override
    public boolean initiateTransaction() {
        return false;
    }
}
