package systemdesign.coffeemachine.exception;

public class InvalidIngredientException extends RuntimeException {
    private String message;
    private String ingredientName;

    public InvalidIngredientException(String ingredientName, String message){
        this.ingredientName = ingredientName;
        this.message = message;
    }

    @Override
    public String getMessage(){
        return ingredientName + message;
    }
}
