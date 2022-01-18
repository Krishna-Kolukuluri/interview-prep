package systemdesign.elevator.service;

import systemdesign.elevator.model.Request;

public interface ElevatorService extends Runnable {
    public void sendUpRequest(Request request);
    public void sendDownRequest(Request request);
    public void runElevator();
    public int getCurrentFloor();
    public boolean stopElevator();
}
