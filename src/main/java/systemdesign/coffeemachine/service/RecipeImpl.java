package systemdesign.coffeemachine.service;

import systemdesign.coffeemachine.model.Ingredient;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RecipeImpl implements Recipe {
    private List<String> instructionList;
    private Map<Ingredient, Integer> ingredientIntegerMap = new LinkedHashMap<>();
    @Override
    public Map<Ingredient, Integer> getIngredientMap() {
        return this.ingredientIntegerMap;
    }

    @Override
    public List<String> getInstructionList() {
        return this.instructionList;
    }

    @Override
    public void setInstructionList(List<String> instructionList) {
        this.instructionList = instructionList;
    }

    @Override
    public void addIngredient(Ingredient ingredient, int ingredientQuantity) {
        this.ingredientIntegerMap.put(ingredient, ingredientQuantity);
    }

    @Override
    public String toString() {
        return "RecipeImpl{" +
                "instructionList=" + instructionList +
                ", ingredientIntegerMap=" + ingredientIntegerMap +
                '}';
    }
}
