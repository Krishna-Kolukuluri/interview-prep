package systemdesign.bikerental.service;

import systemdesign.bikerental.model.Address;

public class SMSNotification extends Notification{
    private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean sendNotification() {
        return false;
    }
}
