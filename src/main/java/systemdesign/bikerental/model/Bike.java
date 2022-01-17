package systemdesign.bikerental.model;

import java.util.List;

public class Bike {
    private String chassisNumber;
    private String stockNumber;
    private int riderCapacity;
    private String barCode;
    private BikeStatus status;
    private String model;
    private String make;
    private int manufacturingYear;
    private List<BikeLog> log;
    private final BikeType bikeType;
    private ParkingRack parkingRack;


    protected Bike(BikeType bikeType) {
        this.bikeType = bikeType;
    }

    public ParkingRack getParkingRack() {
        return parkingRack;
    }

    public void setParkingRack(ParkingRack parkingRack) {
        this.parkingRack = parkingRack;
    }

    public BikeType getBikeType(){
        return this.bikeType;
    }

    public String getChassisNumber() {
        return chassisNumber;
    }

    public void setChassisNumber(String chassisNumber) {
        this.chassisNumber = chassisNumber;
    }

    public String getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(String stockNumber) {
        this.stockNumber = stockNumber;
    }

    public int getRiderCapacity() {
        return riderCapacity;
    }

    public void setRiderCapacity(int riderCapacity) {
        this.riderCapacity = riderCapacity;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public BikeStatus getStatus() {
        return status;
    }

    public void setStatus(BikeStatus status) {
        this.status = status;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getManufacturingYear() {
        return manufacturingYear;
    }

    public void setManufacturingYear(int manufacturingYear) {
        this.manufacturingYear = manufacturingYear;
    }
}
