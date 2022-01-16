package systemdesign.parkinglot.service;

import systemdesign.parkinglot.model.ParkingSpot;
import systemdesign.parkinglot.model.Vehicle;

public interface ParkingFloor {
    public void addParkingSpot(ParkingSpot spot);
    public void assignVehicleToSpot(Vehicle vehicle, ParkingSpot parkingSpot);
    public void freeSpot(ParkingSpot parkingSpot);
    public boolean isFull();
}
