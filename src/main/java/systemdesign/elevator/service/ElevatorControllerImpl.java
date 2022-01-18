package systemdesign.elevator.service;

import systemdesign.elevator.model.AuxButton;
import systemdesign.elevator.model.Direction;
import systemdesign.elevator.model.Request;
import systemdesign.elevator.model.UserCommand;

public class ElevatorControllerImpl implements ElevatorController{
    private final ElevatorServiceImpl elevator;
    public ElevatorControllerImpl(ElevatorServiceImpl elevatorService){
        elevator =  elevatorService;
    }
    @Override
    public void processUserRequest(UserCommand command) {
        int desiredFloor;
        if(command.getButtonPressed().equals(AuxButton.FLOOR)){
            desiredFloor = command.getFloorNumButton().getFloorNum();
        }
        else{
            desiredFloor = elevator.getCurrentFloor();
        }
        Request request = new Request(elevator.getCurrentFloor(), desiredFloor, command.getCommandDirection(), command.getUserRequestedFrom());
        if(command.getCommandDirection().equals(Direction.UP)){
            elevator.upQueue.offer(request);
        }
        else if(command.getCommandDirection().equals(Direction.DOWN)){
            elevator.downQueue.offer(request);
        }
    }

    @Override
    public void startElevator() {
        Thread thread = new Thread(elevator);
        thread.start();
    }

    @Override
    public void stopElevator() {
        elevator.running = false;
    }
}
