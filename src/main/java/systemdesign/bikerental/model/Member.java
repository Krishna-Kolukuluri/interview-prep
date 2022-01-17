package systemdesign.bikerental.model;

import systemdesign.bikerental.service.BikeReservation;

import java.util.Collections;
import java.util.List;

public class Member extends Account{
    private int totalBikesReserved;

    public int getTotalBikesReserved() {
        return totalBikesReserved;
    }

    public void setTotalBikesReserved(int totalBikesReserved) {
        this.totalBikesReserved = totalBikesReserved;
    }

    public List<BikeReservation> getReservations(){
        return Collections.emptyList();
    }
    @Override
    public boolean resetPassword() {
        return false;
    }
}
