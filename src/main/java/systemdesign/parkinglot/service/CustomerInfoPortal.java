package systemdesign.parkinglot.service;

import systemdesign.parkinglot.model.ParkingTicket;

public interface CustomerInfoPortal {
    public boolean scanTicket(ParkingTicket parkingTicket);
    public boolean processPayment(ParkingTicket parkingTicket);
}
