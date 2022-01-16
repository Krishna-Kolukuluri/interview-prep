package systemdesign.parkinglot.exception;

public class ParkingFloorFullException extends ParkingFullException{
    public ParkingFloorFullException(String name, String message) {
        super(name, message);
    }
}
