package systemdesign.coffeemachine.service;

import systemdesign.coffeemachine.model.Ingredient;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public interface Recipe {
    public Map<Ingredient, Integer> getIngredientMap();
    public List<String> getInstructionList();
    public void setInstructionList(List<String> instructionList);
    public void addIngredient(Ingredient ingredient, int ingredientQuantity);
}
