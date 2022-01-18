package systemdesign.elevator.model;

public class UserCommand {
    private AuxButton buttonPressed;
    private UserLocation userRequestedFrom;
    private Direction commandDirection;
    private String currentFloor;

    public String getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(String currentFloor) {
        this.currentFloor = currentFloor;
    }

    public FloorNumButton getFloorNumButton() {
        return floorNumButton;
    }

    public void setFloorNumButton(FloorNumButton floorNumButton) {
        this.floorNumButton = floorNumButton;
    }

    private FloorNumButton floorNumButton;

    public AuxButton getButtonPressed() {
        return buttonPressed;
    }

    public void setButtonPressed(AuxButton buttonPressed) {
        this.buttonPressed = buttonPressed;
    }

    public UserLocation getUserRequestedFrom() {
        return userRequestedFrom;
    }

    public void setUserRequestedFrom(UserLocation userRequestedFrom) {
        this.userRequestedFrom = userRequestedFrom;
    }

    public Direction getCommandDirection() {
        return commandDirection;
    }

    public void setCommandDirection(Direction commandDirection) {
        this.commandDirection = commandDirection;
    }
}
