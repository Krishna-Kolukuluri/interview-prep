package systemdesign.parkinglot.service;

import systemdesign.parkinglot.model.ParkingTicket;
import systemdesign.parkinglot.model.PaymentStatus;

import java.util.Date;

public abstract class PaymentImpl implements Payment {
    private Date creationDate;
    private double amountDue;
    private PaymentStatus paymentStatus;
    private ParkingTicket parkingTicket;

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public double getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(double amountDue) {
        this.amountDue = amountDue;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public ParkingTicket getParkingTicket() {
        return parkingTicket;
    }

    public void setParkingTicket(ParkingTicket parkingTicket) {
        this.parkingTicket = parkingTicket;
    }
}
