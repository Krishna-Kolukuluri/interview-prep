package CommonProblems;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/*
* Find All Possible Recipes from Given Supplies
* https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies/
* https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies/discuss/1646584/JavaPython-3-Toplogical-Sort-w-brief-explanation.
* You have information about n different recipes. You are given a string array recipes and a 2D string array ingredients.
* The ith recipe has the name recipes[i], and you can create it if you have all the needed ingredients from ingredients[i].
* Ingredients to a recipe may need to be created from other recipes, i.e., ingredients[i] may contain a string that is in recipes.
You are also given a string array supplies containing all the ingredients that you initially have, and you have an infinite supply of all of them.
Return a list of all the recipes that you can create. You may return the answer in any order.
Note that two recipes may contain each other in their ingredients.
*
* */
public class FindAllPossibleRecipes {
    /* Topological sort:
    For each recipe, count its non-available ingredients as in degree; Store (non-available ingredient, dependent recipes) as HashMap;
    Store all 0-in-degree recipes into a list as the starting points of topological sort;
    Use topological sort to decrease the in degree of recipes, whenever the in-degree reaches 0, add it to return list.
    */
    public static List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> ans = new ArrayList<>();
        // Put all supplies into HashSet.
        Set<String> available = Stream.of(supplies).collect(Collectors.toCollection(HashSet::new));
        //Ingredient to recipe map
        Map<String, Set<String>> ingredientToRecipes = new HashMap<>();
        //non-available ingredients aka other recipe
        Map<String, Integer> inDegree = new HashMap<>();
        for (int i = 0; i < recipes.length; ++i) {
            int nonAvailable = 0;
            for (String ing : ingredients.get(i)) {
                if (!available.contains(ing)) {
                    ingredientToRecipes.computeIfAbsent(ing, s -> new HashSet<>()).add(recipes[i]);
                    ++nonAvailable;
                }
            }
            if (nonAvailable == 0) {
                ans.add(recipes[i]);
            }else {
                inDegree.put(recipes[i], nonAvailable);
            }
        }
        // Topological Sort.
        for (int i = 0; i < ans.size(); ++i) {
            String recipe = ans.get(i);
            if (ingredientToRecipes.containsKey(recipe)) {
                for (String rcp : ingredientToRecipes.remove(recipe)) {
                    //subtract inDegree of recipe by 1.
                    // inDegree.put(rcp, inDegree.getOrDefault(rcp, 0) - 1) == 0 equal to below if condition
                    if (inDegree.merge(rcp, -1, Integer::sum) == 0) {
                        ans.add(rcp);
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] recipes = new String[]{"bread"};
        List<String> ingredient = new ArrayList<>(Arrays.asList("yeast","flour"));
        List<List<String>> ingredients = new ArrayList<>();
        ingredients.add(ingredient);
        String[] supplies = new String[]{"yeast","flour","corn"};
        System.out.println(findAllRecipes(recipes, ingredients, supplies));

        ingredients = new ArrayList<>();
        recipes = new String[]{"bread","sandwich","burger"};
        ingredient = new ArrayList<>(Arrays.asList("yeast","flour"));
        ingredients.add(ingredient);
        ingredient = new ArrayList<>(Arrays.asList("bread","meat"));
        ingredients.add(ingredient);
        ingredient = new ArrayList<>(Arrays.asList("sandwich","meat","bread"));
        ingredients.add(ingredient);
        supplies = new String[]{"yeast","flour","meat"};
        System.out.println(findAllRecipes(recipes, ingredients, supplies));
    }
}
