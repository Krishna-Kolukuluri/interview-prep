package systemdesign.coffeemachine.service;

import systemdesign.coffeemachine.model.DrinkType;
import systemdesign.coffeemachine.model.Ingredient;

import java.util.List;
import java.util.Map;

public class DrinkMixerImpl implements DrinkMixer {
    private IngredientInventory ingredientInventory;

    public DrinkMixerImpl(IngredientInventory ingredientInventory){
        this.ingredientInventory = ingredientInventory;
    }

    @Override
    public Drink makeDrink(String name, List<String> instructions, Map<Ingredient, Integer> ingredients) {
        for(Ingredient ingredient: ingredients.keySet()){
            if(ingredientInventory.getIngredient(ingredient, ingredients.get(ingredient))){
                continue;
            }
        }
        if(name.equals(DrinkType.AMERICANO)){
            return new Americano(name);
        }else if(name.equals(DrinkType.CAPPUCCINO)){
            return new Cappuccino(name);
        }else if(name.equals(DrinkType.ESPRESSO)){
            return new Espresso(name);
        }
        return null;
    }
}
