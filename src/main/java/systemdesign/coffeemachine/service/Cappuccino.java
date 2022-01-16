package systemdesign.coffeemachine.service;

import systemdesign.coffeemachine.model.DrinkType;
import systemdesign.coffeemachine.model.Ingredient;
/*
 * Implementing Strategy design pattern
 * */
import java.util.Map;

public class Cappuccino extends DrinkImpl {
    public Cappuccino(String name) {
        super(name);
    }

    public Cappuccino(String name, Recipe recipe, long price, DrinkMixer mixer) {
        super(DrinkType.CAPPUCCINO.name(), recipe, price, mixer);
    }

    @Override
    public Cappuccino process(){
        Map<Ingredient, Integer> ingredientMap = getWholeIngredients(recipe.getIngredientMap());
        Cappuccino cappuccino = (Cappuccino) mixer.makeDrink(this.name, recipe.getInstructionList(), ingredientMap);
        cappuccino.price = this.price;
        cappuccino.recipe = this.recipe;
        return cappuccino;
    }

    @Override
    public void addCommonIngredient(Ingredient ingredient, int quantity){
        this.commonIngredients.put(ingredient, quantity);
    }

    @Override
    public String toString() {
        return "Cappuccino{" +
                "name='" + name + '\'' +
                ", recipe=" + recipe +
                ", price=" + price +
                '}';
    }
}
