package systemdesign.coffeemachine.service;

import systemdesign.coffeemachine.model.Ingredient;

public interface IngredientInventory {
    public void addIngredient(Ingredient ingredient, Integer quantity);
    public boolean getIngredient(Ingredient ingredient, Integer requestedQuantity);
    public void sendAlert(Ingredient ingredient);
}
