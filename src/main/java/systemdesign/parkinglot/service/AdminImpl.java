package systemdesign.parkinglot.service;

import systemdesign.parkinglot.model.Account;
import systemdesign.parkinglot.model.ParkingSpot;

public class AdminImpl extends Account implements Admin{
    @Override
    public boolean addParkingFloor(ParkingFloor parkingFloor) {
        return false;
    }

    @Override
    public boolean addParkingSpot(String floorName, ParkingSpot parkingSpot) {
        return false;
    }

    @Override
    public boolean addParkingDisplayBoard(String floorName, ParkingDisplayBoard displayBoard) {
        return false;
    }

    @Override
    public boolean addCustomerInfoPortal(String floorName, CustomerInfoPortal customerInfoPortal) {
        return false;
    }

    @Override
    public boolean addEntrancePanel(EntrancePanel entrancePanel) {
        return false;
    }

    @Override
    public boolean addExitPanel(ExitPanel exitPanel) {
        return false;
    }

    @Override
    public boolean resetPassword() {
        return false;
    }
}
