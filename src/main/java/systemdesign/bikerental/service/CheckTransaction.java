package systemdesign.bikerental.service;

public class CheckTransaction extends Payment{
    private String bankName;
    private String checkNumber;

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }

    @Override
    public boolean initiateTransaction() {
        return false;
    }
}
