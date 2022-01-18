package systemdesign.elevator.model;

public enum FloorNumButton {
    ONE("ONE", 1),
    TWO("TWO", 2),
    THREE("THREE", 3),
    FOUR("FOUR", 4),
    FIVE("FIVE", 5),
    SIX("SIX", 6),
    SEVEN("SEVEN", 7);

    public String getFloorString() {
        return floorString;
    }

    public void setFloorString(String floorString) {
        this.floorString = floorString;
    }

    public int getFloorNum() {
        return floorNum;
    }

    public void setFloorNum(int floorNum) {
        this.floorNum = floorNum;
    }

    private String floorString;
    private int floorNum;

    FloorNumButton(String floorStr, int floorNum) {
        this.floorNum = floorNum;
        this.floorString = floorStr;
    }
}
