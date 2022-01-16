package systemdesign.parkinglot.exception;

public class ParkingFullException extends RuntimeException {

    private String name;
    private String message;

    public ParkingFullException(String name, String message){
        this.name = name;
        this.message = message;
    }

    public String getRemaining(){
        return message;
    }

    @Override
    public String getMessage(){
        return name + message;
    }
}
