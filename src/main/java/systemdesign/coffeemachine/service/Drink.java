package systemdesign.coffeemachine.service;

import systemdesign.coffeemachine.model.Ingredient;

import java.util.LinkedHashMap;
import java.util.Map;

public interface Drink {
    public Map<Ingredient, Integer> getWholeIngredients(Map<Ingredient, Integer> drinkSpecificIngredientMap);
    public Drink process();
    public void addCommonIngredient(Ingredient ingredient, int volume);
}
