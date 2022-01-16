package systemdesign.parkinglot.model;

public abstract class ParkingSpot {
    private String number;
    private boolean free;
    private Vehicle vehicle;
    private final ParkingSpotType parkingSpotType;
    public ParkingSpot(ParkingSpotType parkingSpotType){
        this.parkingSpotType = parkingSpotType;
    }
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public boolean getFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingSpotType getParkingSpotType(){
        return this.parkingSpotType;
    }

    public abstract boolean isFree();

    public void assignVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
        free = false;
    }

    public void removeVehicle(){
        this.vehicle = null;
        free = true;
    }

}
