package systemdesign.parkinglot.service;

import systemdesign.parkinglot.model.ElectricSpot;

import java.util.Date;

public class ElectricPanelImpl  implements ElectricPanel{
    private int payedForMinutes;
    private Date chargingStartTime;
    private final ElectricSpot electricSpot;

    public ElectricPanelImpl(ElectricSpot electricSpot) {
        this.electricSpot = electricSpot;
    }

    public int getPayedForMinutes() {
        return payedForMinutes;
    }

    public void setPayedForMinutes(int payedForMinutes) {
        this.payedForMinutes = payedForMinutes;
    }

    public Date getChargingStartTime() {
        return chargingStartTime;
    }

    public void setChargingStartTime(Date chargingStartTime) {
        this.chargingStartTime = chargingStartTime;
    }

    @Override
    public boolean cancelCharging() {
        return false;
    }
}
