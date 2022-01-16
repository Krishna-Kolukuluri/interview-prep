package systemdesign.parkinglot.model;

public class ParkingAttendant extends Account {
    public boolean processTicket(){
        return false;
    }

    @Override
    public boolean resetPassword() {
        return false;
    }
}
