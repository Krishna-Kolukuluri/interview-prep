package systemdesign.elevator.service;

import systemdesign.elevator.model.Request;

public interface ElevatorService {
    public void sendUpRequest(Request request);
    public void sendDownRequest(Request request);
    public void runElevator();
    public int getCurrentFloor();
}
