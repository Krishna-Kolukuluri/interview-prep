package systemdesign.parkinglot.service;

import systemdesign.parkinglot.model.*;

public interface ParkingDisplayBoard {
    public void showEmptySpotNumber();

    ParkingSpot getHandicappedFreeSpot();

    void setHandicappedFreeSpot(HandicappedSpot handicappedSpot);

    ParkingSpot getCompactFreeSpot();

    void setCompactFreeSpot(CompactSpot compactSpot);

    ParkingSpot getLargeFreeSpot();

    void setLargeFreeSpot(LargeSpot largeSpot);

    ParkingSpot getMotorbikeFreeSpot();

    void setMotorbikeFreeSpot(MotorbikeSpot motorbikeSpot);

    ParkingSpot getElectricFreeSpot();

    void setElectricFreeSpot(ElectricSpot electricSpot);
}
