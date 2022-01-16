package systemdesign.parkinglot.service;

import systemdesign.parkinglot.model.ParkingSpot;

public interface Admin {
    public boolean addParkingFloor(ParkingFloor parkingFloor);
    public boolean addParkingSpot(String floorName, ParkingSpot parkingSpot);
    public boolean addParkingDisplayBoard(String floorName, ParkingDisplayBoard displayBoard);
    public boolean addCustomerInfoPortal(String floorName, CustomerInfoPortal customerInfoPortal);

    public boolean addEntrancePanel(EntrancePanel entrancePanel);
    public boolean addExitPanel(ExitPanel exitPanel);
}
