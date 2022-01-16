package systemdesign.coffeemachine.service;

import systemdesign.coffeemachine.exception.InvalidIngredientException;
import systemdesign.coffeemachine.exception.NotSufficientIngredientException;
import systemdesign.coffeemachine.model.Ingredient;

import java.util.HashMap;
import java.util.Map;

public class IngredientInventoryImpl  implements IngredientInventory{
    Map<Ingredient, Integer> ingredientInventoryMap = new HashMap<>();
    @Override
    public void addIngredient(Ingredient ingredient, Integer quantity) {
        ingredientInventoryMap.put(ingredient, ingredientInventoryMap.getOrDefault(ingredient, 0) + quantity);

    }

    @Override
    public boolean getIngredient(Ingredient ingredient, Integer requestedQuantity) {
        if(validateIngredientQuantity(ingredient, requestedQuantity)){
            deductIngredientInventory(ingredient, requestedQuantity);
            return true;
        }
        return false;
    }

    @Override
    public void sendAlert(Ingredient ingredient) {

    }

    private void deductIngredientInventory(Ingredient ingredient, Integer requestedQuantity){
        int curQuantity = ingredientInventoryMap.getOrDefault(ingredient, 0);
        curQuantity = curQuantity - requestedQuantity;
        ingredientInventoryMap.put(ingredient, ingredientInventoryMap.getOrDefault(ingredient, 0)  - requestedQuantity);
        if(curQuantity < 10){
            sendAlert(ingredient);
        }
    }

    private boolean validateIngredientQuantity(Ingredient ingredient, Integer quantity){
        if(!ingredientInventoryMap.containsKey(ingredient)){
            throw new InvalidIngredientException(ingredient.getName(), ", Ingredient is Not Found");
        }
        int curQuantity = ingredientInventoryMap.getOrDefault(ingredient, 0);
        if(curQuantity < quantity){
            throw new NotSufficientIngredientException(ingredient.getName(), ", Insufficient quantity of ingredient!!");
        }
        return true;
    }
}
