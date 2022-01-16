package systemdesign.parkinglot.model;

public class LargeSpot extends ParkingSpot{
    public LargeSpot(){
        super(ParkingSpotType.LARGE);
    }
    @Override
    public boolean isFree() {
        return false;
    }
}
