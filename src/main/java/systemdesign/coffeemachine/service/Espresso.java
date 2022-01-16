package systemdesign.coffeemachine.service;

import systemdesign.coffeemachine.model.DrinkType;
import systemdesign.coffeemachine.model.Ingredient;

import java.util.Map;

public class Espresso extends DrinkImpl {
    String extraIngredient;

    public Espresso(String name){
        super(name);
    }

    public Espresso(String name, Recipe recipe, long price, DrinkMixer drinkMixer, String extraIngredient){
        super(DrinkType.ESPRESSO.name(), recipe, price, drinkMixer);
        this.extraIngredient = extraIngredient;
    }

    @Override
    public Espresso process(){
        Map<Ingredient, Integer> ingredientMap = getWholeIngredients(recipe.getIngredientMap());
        Espresso espresso = (Espresso) mixer.makeDrink(this.name, recipe.getInstructionList(), ingredientMap);
        espresso.price = this.price;
        espresso.recipe = this.recipe;
        return espresso;
    }

    @Override
    public void addCommonIngredient(Ingredient ingredient, int quantity){
        this.commonIngredients.put(ingredient, quantity);
    }

    @Override
    public String toString() {
        return "Espresso{" +
                "name='" + name + '\'' +
                ", recipe=" + recipe +
                ", price=" + price +
                ", extraIngredient='" + extraIngredient + '\'' +
                '}';
    }
}
