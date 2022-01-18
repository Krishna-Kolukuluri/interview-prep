package systemdesign.elevator.model;

public class Request {
    private int currentFloor;
    private int desiredFloor;
    private Direction direction;
    private UserLocation location;

    public Request(int currentFloor, int desiredFloor, Direction direction, UserLocation location){
        this.setCurrentFloor(currentFloor);
        this.setDesiredFloor(desiredFloor);
        this.setDirection(direction);
        this.setLocation(location);
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public int getDesiredFloor() {
        return desiredFloor;
    }

    public void setDesiredFloor(int desiredFloor) {
        this.desiredFloor = desiredFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public UserLocation getLocation() {
        return location;
    }

    public void setLocation(UserLocation location) {
        this.location = location;
    }
}
