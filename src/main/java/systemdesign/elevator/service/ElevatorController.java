package systemdesign.elevator.service;

import systemdesign.elevator.model.UserCommand;

public interface ElevatorController {
    public void processUserRequest(UserCommand command);
    public void startElevator();
    public void stopElevator();
}
