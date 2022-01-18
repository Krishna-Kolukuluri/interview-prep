package systemdesign.elevator.service;

import systemdesign.elevator.model.AuxButton;
import systemdesign.elevator.model.Direction;
import systemdesign.elevator.model.Request;
import systemdesign.elevator.model.UserLocation;

import java.util.PriorityQueue;

public class ElevatorServiceImpl implements ElevatorService{
    int currentFloor;
    Direction direction;

    public AuxButton getAuxButton() {
        return auxButton;
    }

    public void setAuxButton(AuxButton auxButton) {
        this.auxButton = auxButton;
    }

    AuxButton auxButton;
    PriorityQueue<Request> upQueue;
    PriorityQueue<Request> downQueue;
    boolean running = false;
    private static ElevatorServiceImpl elevatorService;
    private ElevatorServiceImpl(){
        this.setCurrentFloor(0);
        this.direction = Direction.IDLE;
        this.auxButton = AuxButton.OPEN_DOORS;
        //Min Heap
        upQueue = new PriorityQueue<>((a, b) -> a.getDesiredFloor() - b.getDesiredFloor());
        //Map Heap
        downQueue = new PriorityQueue<>((a, b) -> b.getDesiredFloor() - a.getDesiredFloor());
    }
    public static ElevatorServiceImpl getInstance(){
        if(elevatorService == null){
            synchronized (ElevatorControllerImpl.class){
                if(elevatorService == null){
                    elevatorService = new ElevatorServiceImpl();
                }
            }
        }
        return elevatorService;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }
    public int getCurrentFloor() {
        return currentFloor;
    }

    @Override
    public boolean stopElevator() {

        return false;
    }


    @Override
    public void sendUpRequest(Request request) {
        // If the request is sent from out side of the elevator,
        // we need to stop at the current floor of the requester
        // to pick him up, and then go the the desired floor.
        if(request.getLocation() == UserLocation.OUTSIDE_ELEVATOR){
            // Go pick up the requester who is outside of the elevator
            upQueue.offer(new Request(request.getCurrentFloor(), request.getCurrentFloor(), Direction.UP, UserLocation.OUTSIDE_ELEVATOR));
            System.out.println("Append up request going to floor " + request.getCurrentFloor() + ".");
        }
        upQueue.offer(request);
        System.out.println("Append up request going to floor " + request.getDesiredFloor() + ".");
    }

    @Override
    public void sendDownRequest(Request request) {
        // If the request is sent from out side of the elevator,
        // we need to stop at the current floor of the requester
        // to pick him up, and then go the the desired floor.
        if(request.getLocation() == UserLocation.OUTSIDE_ELEVATOR){
            downQueue.offer(new Request(request.getCurrentFloor(), request.getCurrentFloor(), Direction.DOWN, UserLocation.OUTSIDE_ELEVATOR));
            System.out.println("Append down request going to floor " + request.getCurrentFloor() + ".");
        }
        downQueue.offer(request);
        System.out.println("Append down request going to floor " + request.getDesiredFloor() + ".");

    }

    private void processDownRequest(){
        while (!downQueue.isEmpty()){
            Request request = downQueue.poll();
            //Communicate/Send signal with/to hardware
            this.setCurrentFloor(request.getDesiredFloor());
            System.out.println("Processing down requests. Elevator stopped at floor " + this.getCurrentFloor() + ".");
        }
        if(!upQueue.isEmpty()){
            this.direction = Direction.UP;
        }else {
            this.direction = Direction.IDLE;
        }

    }

    private void processUpRequest(){
        while (!upQueue.isEmpty()){
            Request request = upQueue.poll();
            //Communicate/Send signal with Hardware
            this.setCurrentFloor(request.getDesiredFloor());
            System.out.println("Processing up requests. Elevator stopped at floor " + this.getCurrentFloor() + ".");
        }
        if(!downQueue.isEmpty()){
            this.direction = Direction.DOWN;
        }else{
            this.direction = Direction.IDLE;
        }
    }

    @Override
    public void runElevator() {
        while (running){
            if(this.direction == Direction.UP || this.direction == Direction.IDLE){
                processUpRequest();
                processDownRequest();
            }else{
                processDownRequest();
                processUpRequest();
            }
        }
    }

    @Override
    public void run() {
        running =  true;
        runElevator();
    }
}
