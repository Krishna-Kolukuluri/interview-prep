package systemdesign.parkinglot.service;

import systemdesign.parkinglot.model.*;

public class ParkingDisplayBoardImpl implements ParkingDisplayBoard{
    private String parkingDisplayBoardId;
    private HandicappedSpot handicappedFreeSpot;
    private CompactSpot compactFreeSpot;
    private LargeSpot largeFreeSpot;
    private MotorbikeSpot motorbikeFreeSpot;
    private ElectricSpot electricFreeSpot;

    public String getParkingDisplayBoardId() {
        return parkingDisplayBoardId;
    }

    public void setParkingDisplayBoardId(String parkingDisplayBoardId) {
        this.parkingDisplayBoardId = parkingDisplayBoardId;
    }

    public HandicappedSpot getHandicappedFreeSpot() {
        return handicappedFreeSpot;
    }

    public void setHandicappedFreeSpot(HandicappedSpot handicappedFreeSpot) {
        this.handicappedFreeSpot = handicappedFreeSpot;
    }

    public CompactSpot getCompactFreeSpot() {
        return compactFreeSpot;
    }

    public void setCompactFreeSpot(CompactSpot compactFreeSpot) {
        this.compactFreeSpot = compactFreeSpot;
    }

    public LargeSpot getLargeFreeSpot() {
        return largeFreeSpot;
    }

    public void setLargeFreeSpot(LargeSpot largeFreeSpot) {
        this.largeFreeSpot = largeFreeSpot;
    }

    public MotorbikeSpot getMotorbikeFreeSpot() {
        return motorbikeFreeSpot;
    }

    public void setMotorbikeFreeSpot(MotorbikeSpot motorbikeFreeSpot) {
        this.motorbikeFreeSpot = motorbikeFreeSpot;
    }

    public ElectricSpot getElectricFreeSpot() {
        return electricFreeSpot;
    }

    public void setElectricFreeSpot(ElectricSpot electricFreeSpot) {
        this.electricFreeSpot = electricFreeSpot;
    }

    @Override
    public void showEmptySpotNumber() {
        StringBuilder message = new StringBuilder();
        if(handicappedFreeSpot.isFree()){
            message.append("Free Handicapped: "+ handicappedFreeSpot.getNumber());
        }else{
            message.append("Handicapped is full");
        }
        message.append(System.lineSeparator());
        if(compactFreeSpot.isFree()){
            message.append("Free CompactSpot: "+ compactFreeSpot.getNumber());
        }else{
            message.append("CompactSpot is full");
        }
        message.append(System.lineSeparator());
        if(largeFreeSpot.isFree()){
            message.append("Free LargeSpot: "+ largeFreeSpot.getNumber());
        }else{
            message.append("LargeSpot is full");
        }
        message.append(System.lineSeparator());
        if(motorbikeFreeSpot.isFree()){
            message.append("Free MotorbikeSpot: "+ motorbikeFreeSpot.getNumber());
        }else{
            message.append("MotorbikeSpot is full");
        }
        message.append(System.lineSeparator());
        if(electricFreeSpot.isFree()){
            message.append("Free ElectricSpot: "+ electricFreeSpot.getNumber());
            message.append(System.lineSeparator());
        }else{
            message.append("ElectricSpot is full");
        }
        //Show(message) on the display-board
        System.out.println(message.toString());
    }
}
