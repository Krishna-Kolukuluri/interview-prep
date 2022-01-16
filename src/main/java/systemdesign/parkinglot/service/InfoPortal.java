package systemdesign.parkinglot.service;

import systemdesign.parkinglot.model.ParkingTicket;

public interface InfoPortal {
    public boolean scanTicket(ParkingTicket parkingTicket);
    public boolean processPayment(ParkingTicket parkingTicket);
}
