package systemdesign.elevator;

import systemdesign.elevator.model.Direction;
import systemdesign.elevator.model.Request;
import systemdesign.elevator.model.UserLocation;
import systemdesign.elevator.service.ElevatorService;
import systemdesign.elevator.service.ElevatorServiceImpl;

public class Elevator {
    public static void main(String[] args) {
        ElevatorService elevator = new ElevatorServiceImpl(0);

        Request upRequest1 = new Request(elevator.getCurrentFloor(), 5, Direction.UP, UserLocation.INSIDE_ELEVATOR);
        Request upRequest2 = new Request(elevator.getCurrentFloor(), 3, Direction.UP, UserLocation.INSIDE_ELEVATOR);

        Request downRequest1 = new Request(elevator.getCurrentFloor(), 1, Direction.DOWN, UserLocation.INSIDE_ELEVATOR);
        Request downRequest2 = new Request(elevator.getCurrentFloor(), 2, Direction.DOWN, UserLocation.INSIDE_ELEVATOR);
        Request downRequest3 = new Request(4, 0, Direction.DOWN, UserLocation.OUTSIDE_ELEVATOR);

        // Two people inside of the elevator pressed button to go up to floor 5 and 3.
        elevator.sendUpRequest(upRequest1);
        elevator.sendUpRequest(upRequest2);

        // One person outside of the elevator at floor 4 pressed button to go down to floor 0
        elevator.sendDownRequest(downRequest3);

        // Two person inside of the elevator pressed button to go down to floor 2 and 1.
        elevator.sendDownRequest(downRequest1);
        elevator.sendDownRequest(downRequest2);


        elevator.runElevator();
    }
}
