package systemdesign.parkinglot.service;

import systemdesign.parkinglot.model.ParkingTicket;

public interface ExitPanel {
    public boolean scanTicket(ParkingTicket parkingTicket);
    public boolean processPayment(ParkingTicket parkingTicket);
}
