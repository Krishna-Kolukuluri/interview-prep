package systemdesign.parkinglot.service;

import systemdesign.parkinglot.model.Account;
import systemdesign.parkinglot.model.ParkingTicket;

public class ParkingAttendantImpl extends Account implements ParkingAttendant {
    @Override
    public boolean processTicket(ParkingTicket parkingTicket) {
        return false;
    }

    @Override
    public boolean resetPassword() {
        return false;
    }
}
