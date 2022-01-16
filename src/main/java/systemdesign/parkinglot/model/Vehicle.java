package systemdesign.parkinglot.model;

public abstract class Vehicle {
    private String licenseNumber;
    private final VehicleType vehicleType;
    private ParkingTicket ticket;
    public Vehicle(VehicleType vehicleType){
        this.vehicleType = vehicleType;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public ParkingTicket getTicket() {
        return ticket;
    }

    public void setTicket(ParkingTicket ticket) {
        this.ticket = ticket;
    }
    public VehicleType getVehicleType(){
        return vehicleType;
    }
    public void assignTicket(ParkingTicket ticket){
        setTicket(ticket);
    }
}
