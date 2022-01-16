package systemdesign.parkinglot.model;

public class MotorbikeSpot extends ParkingSpot{
    public MotorbikeSpot(){
        super(ParkingSpotType.MOTORBIKE);
    }
    @Override
    public boolean isFree() {
        return false;
    }
}
