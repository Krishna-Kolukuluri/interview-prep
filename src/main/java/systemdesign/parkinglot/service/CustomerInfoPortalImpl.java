package systemdesign.parkinglot.service;

import systemdesign.parkinglot.model.ParkingTicket;

public class CustomerInfoPortalImpl implements InfoPortal{
    public String getCustomerInfoPortalId() {
        return customerInfoPortalId;
    }

    public void setCustomerInfoPortalId(String customerInfoPortalId) {
        this.customerInfoPortalId = customerInfoPortalId;
    }

    private String customerInfoPortalId;

    @Override
    public boolean scanTicket(ParkingTicket parkingTicket) {
        return false;
    }

    @Override
    public boolean processPayment(ParkingTicket parkingTicket) {
        return false;
    }
}
