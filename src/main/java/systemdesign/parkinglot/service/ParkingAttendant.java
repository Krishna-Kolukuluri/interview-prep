package systemdesign.parkinglot.service;

import systemdesign.parkinglot.model.ParkingTicket;

public interface ParkingAttendant {
    public boolean processTicket(ParkingTicket parkingTicket);
}
