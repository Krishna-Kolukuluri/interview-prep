package systemdesign.coffeemachine.service;

import systemdesign.coffeemachine.model.Ingredient;

import java.util.List;
import java.util.Map;

public interface DrinkMixer {
    public Drink makeDrink(String name, List<String> instructions, Map<Ingredient, Integer> ingredients);
}
