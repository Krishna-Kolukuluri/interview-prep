package systemdesign.bikerental.service;

import systemdesign.bikerental.model.PaymentStatus;

import java.util.Date;

public abstract class Payment {
    private Date creationDate;
    private double amount;
    private PaymentStatus paymentStatus;

    public abstract boolean initiateTransaction();
}
