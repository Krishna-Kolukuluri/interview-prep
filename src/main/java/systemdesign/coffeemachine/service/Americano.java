package systemdesign.coffeemachine.service;

import systemdesign.coffeemachine.model.DrinkType;
import systemdesign.coffeemachine.model.Ingredient;

import java.util.Map;

public class Americano extends DrinkImpl {

    public Americano(String name) {
        super(name);
    }

    public Americano(String name, Recipe recipe, long price, DrinkMixer mixer) {
        super(DrinkType.AMERICANO.name(), recipe, price, mixer);
    }

    @Override
    public Americano process(){
        Map<Ingredient, Integer> ingredientMap = getWholeIngredients(recipe.getIngredientMap());
        Americano americano = (Americano) mixer.makeDrink(this.name, recipe.getInstructionList(), ingredientMap);
        americano.price = this.price;
        americano.recipe = this.recipe;
        return americano;
    }

    @Override
    public void addCommonIngredient(Ingredient ingredient, int quantity){
        this.commonIngredients.put(ingredient, quantity);
    }

    @Override
    public String toString() {
        return "Americano{" +
                "name='" + name + '\'' +
                ", recipe=" + recipe +
                ", price=" + price +
                '}';
    }
}
