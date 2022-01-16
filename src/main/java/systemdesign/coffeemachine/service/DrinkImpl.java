package systemdesign.coffeemachine.service;

import systemdesign.coffeemachine.model.Ingredient;

import java.util.LinkedHashMap;
import java.util.Map;

public class DrinkImpl  implements Drink {
    String name;
    Recipe recipe;
    long price;
    DrinkMixer mixer;
    Map<Ingredient, Integer> commonIngredients;

    public DrinkImpl(String name){
        this.name = name;
    }

    public DrinkImpl(String name, Recipe recipe, long price, DrinkMixer mixer){
        this.name = name;
        this.recipe = recipe;
        this.price = price;
        this.mixer = mixer;
    }

    @Override
    public Map<Ingredient, Integer> getWholeIngredients(Map<Ingredient, Integer> drinkSpecificIngredientMap){
        Map<Ingredient, Integer> map = new LinkedHashMap<>(drinkSpecificIngredientMap);
        map.putAll(commonIngredients);
        return map;
    }

    @Override
    public Drink process() {
        return null;
    }

    @Override
    public void addCommonIngredient(Ingredient ingredient, int volume) {

    }
}
