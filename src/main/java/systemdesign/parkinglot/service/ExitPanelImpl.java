package systemdesign.parkinglot.service;

import systemdesign.parkinglot.model.ParkingTicket;

public class ExitPanelImpl  implements ExitPanel{
    private String exitPanelId;

    public String getExitPanelId() {
        return exitPanelId;
    }

    public void setExitPanelId(String exitPanelId) {
        this.exitPanelId = exitPanelId;
    }

    @Override
    public boolean scanTicket(ParkingTicket parkingTicket) {
        return false;
    }

    @Override
    public boolean processPayment(ParkingTicket parkingTicket) {
        return false;
    }
}
