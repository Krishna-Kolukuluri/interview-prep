package systemdesign.parkinglot.service;

import systemdesign.parkinglot.model.ParkingTicket;

public class ParkingAttendantPortalImpl  implements InfoPortal{
    private String parkingAttendantPortalId;
    public String getParkingAttendantPortalId() {
        return parkingAttendantPortalId;
    }

    public void setParkingAttendantPortalId(String parkingAttendantPortalId) {
        this.parkingAttendantPortalId = parkingAttendantPortalId;
    }

    @Override
    public boolean scanTicket(ParkingTicket parkingTicket) {
        return false;
    }

    @Override
    public boolean processPayment(ParkingTicket parkingTicket) {
        return false;
    }
}
