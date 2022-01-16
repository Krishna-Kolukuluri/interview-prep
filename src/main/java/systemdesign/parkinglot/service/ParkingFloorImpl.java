package systemdesign.parkinglot.service;

import systemdesign.parkinglot.model.*;

import java.util.HashMap;


public class ParkingFloorImpl implements ParkingFloor{
    private String name;
    private HashMap<String, HandicappedSpot> handicappedSpots;
    private HashMap<String, CompactSpot> compactSpots;
    private HashMap<String, LargeSpot> largeSpots;
    private HashMap<String, MotorbikeSpot> motorbikeSpots;
    private HashMap<String, ElectricSpot> electricSpots;
    private HashMap<String, CustomerInfoPortal> infoPortals;
    private ParkingDisplayBoard displayBoard;
    private int freeHandicappedSpotCount=0;
    private int freeCompactSpotCount=0;
    private int freeLargeSpotCount=0;
    private int freeMotorbikeSpotCount=0;
    private int freeElectricSpotCount=0;

    public ParkingFloorImpl(ParkingDisplayBoard displayBoard){
        this.displayBoard = displayBoard;
    }

    @Override
    public void addParkingSpot(ParkingSpot spot) {

    }

    @Override
    public void assignVehicleToSpot(Vehicle vehicle, ParkingSpot parkingSpot) {
        parkingSpot.assignVehicle(vehicle);
        switch (parkingSpot.getParkingSpotType()) {
            case HANDICAPPED:
                updateDisplayBoardForHandicapped(parkingSpot);
                break;
            case COMPACT:
                updateDisplayBoardForCompact(parkingSpot);
                break;
            case LARGE:
                updateDisplayBoardForLarge(parkingSpot);
                break;
            case MOTORBIKE:
                updateDisplayBoardForMotorbike(parkingSpot);
                break;
            case ELECTRIC:
                updateDisplayBoardForElectric(parkingSpot);
                break;
            default:
                System.out.print("Wrong parking spot type!");
        }
    }
    private void updateDisplayBoardForHandicapped(ParkingSpot spot) {
        if (this.displayBoard.getHandicappedFreeSpot().getNumber() == spot.getNumber()) {
            // find another free handicapped parking and assign to displayBoard
            for (String key : handicappedSpots.keySet()) {
                if (handicappedSpots.get(key).isFree()) {
                    this.displayBoard.setHandicappedFreeSpot(handicappedSpots.get(key));
                }
            }
            this.displayBoard.showEmptySpotNumber();
        }
    }

    private void updateDisplayBoardForCompact(ParkingSpot spot) {
        if (this.displayBoard.getCompactFreeSpot().getNumber() == spot.getNumber()) {
            // find another free compact parking and assign to displayBoard
            for (String key : compactSpots.keySet()) {
                if (compactSpots.get(key).isFree()) {
                    this.displayBoard.setCompactFreeSpot(compactSpots.get(key));
                }
            }
            this.displayBoard.showEmptySpotNumber();
        }
    }
    private void updateDisplayBoardForLarge(ParkingSpot spot) {
        if (this.displayBoard.getLargeFreeSpot().getNumber() == spot.getNumber()) {
            // find another free handicapped parking and assign to displayBoard
            for (String key : largeSpots.keySet()) {
                if (largeSpots.get(key).isFree()) {
                    this.displayBoard.setLargeFreeSpot(largeSpots.get(key));
                }
            }
            this.displayBoard.showEmptySpotNumber();
        }
    }

    private void updateDisplayBoardForMotorbike(ParkingSpot spot) {
        if (this.displayBoard.getMotorbikeFreeSpot().getNumber() == spot.getNumber()) {
            // find another free compact parking and assign to displayBoard
            for (String key : motorbikeSpots.keySet()) {
                if (motorbikeSpots.get(key).isFree()) {
                    this.displayBoard.setMotorbikeFreeSpot(motorbikeSpots.get(key));
                }
            }
            this.displayBoard.showEmptySpotNumber();
        }
    }
    private void updateDisplayBoardForElectric(ParkingSpot spot) {
        if (this.displayBoard.getElectricFreeSpot().getNumber() == spot.getNumber()) {
            // find another free compact parking and assign to displayBoard
            for (String key : electricSpots.keySet()) {
                if (electricSpots.get(key).isFree()) {
                    this.displayBoard.setElectricFreeSpot(electricSpots.get(key));
                }
            }
            this.displayBoard.showEmptySpotNumber();
        }
    }

    @Override
    public void freeSpot(ParkingSpot parkingSpot) {
        parkingSpot.removeVehicle();
        switch (parkingSpot.getParkingSpotType()) {
            case HANDICAPPED:
                freeHandicappedSpotCount++;
                break;
            case COMPACT:
                freeCompactSpotCount++;
                break;
            case LARGE:
                freeLargeSpotCount++;
                break;
            case MOTORBIKE:
                freeMotorbikeSpotCount++;
                break;
            case ELECTRIC:
                freeElectricSpotCount++;
                break;
            default:
               System.out.print("Wrong parking spot type!");
        }
    }

    @Override
    public boolean isFull() {
        return false;
    }
}
